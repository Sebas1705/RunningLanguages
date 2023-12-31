package com.sebss.juegosnake.juego;

import android.util.Log;

import java.util.ArrayList;
import java.util.Random;

import java.util.Timer;
import java.util.TimerTask;


public class Mundo {
    static final int MUNDO_ANCHO = 10;
    static final int MUNDO_ALTO = 13;
    static final int INCREMENTO_PUNTUACION = 10;
    static final float TICK_INICIAL = 0.5f;
    static final float TICK_DECREMENTO = 0.05f;
    static final int MAX_ENTIDADES = 6;
    static final int PENALIZACION_YAYA = 50;
    static final int PENALIZACION_NINO = 100;
    static final int PENALIZACION_CANI = 10;
    static final int PENALIZACION_CAMION = 3;
    private static final int INTERVALO_ACELERACION = 30 * 1000; // 30 segundos en milisegundos

    //static final float VELOCIDAD_MAXIMA = 0.1f;

    public CochePolicia coche;

    public ArrayList<Entidad> entidades = new ArrayList<>();
    public boolean finalJuego = false;
    public int puntuacion = 0;
    private Timer aceleracionTimer;


    boolean[][] campos = new boolean[MUNDO_ANCHO][MUNDO_ALTO];
    Random random = new Random();
    float tiempoTick = 0;
    static float tick = TICK_INICIAL;

    public Mundo() {
        coche = new CochePolicia();
        Log.d("Mundo", "Cual es mi velocidad ahora1 : " + tick);
        colocarEntidades();
        // Inicializar el temporizador para acelerar cada 30 segundos
        aceleracionTimer = new Timer();
        aceleracionTimer.scheduleAtFixedRate(new TimerTask() {
            @Override
            public void run() {
                acelerarJuego();

            }
        }, INTERVALO_ACELERACION, INTERVALO_ACELERACION);
    }


    private void colocarEntidades() {
        for (int x = 0; x < MUNDO_ANCHO; x++) {
            for (int y = 0; y < MUNDO_ALTO; y++) {
                campos[x][y] = false;
            }
        }
        entidades.clear();

        int len = coche.partes.size();
        for (int i = 0; i < len; i++) {
            DelicuentesDetenidos parte = coche.partes.get(i);
            campos[parte.x][parte.y] = true;
        }

        int ladronX = random.nextInt(MUNDO_ANCHO);
        int ladronY = random.nextInt(MUNDO_ALTO);
        while (campos[ladronX][ladronY]) {
            ladronX += 1;
            if (ladronX >= MUNDO_ANCHO) {
                ladronX = 0;
                ladronY += 1;
                if (ladronY >= MUNDO_ALTO) {
                    ladronY = 0;
                }
            }
        }
        campos[ladronX][ladronY] = true;
        entidades.add(new Delincuente(ladronX, ladronY, random.nextInt(3)));

        int maxEntidades = (int)Math.ceil(random.nextInt(MAX_ENTIDADES*(1-(coche.partes.size()/(MUNDO_ALTO*MUNDO_ANCHO)))));
        for (int i = 0; i < maxEntidades; i++) {
            int entidadX = random.nextInt(MUNDO_ANCHO);
            int entidadY = random.nextInt(MUNDO_ALTO);
            while (campos[entidadX][entidadY]) {
                entidadX = (entidadX+random.nextInt(MUNDO_ANCHO))%MUNDO_ANCHO;
                entidadY = (entidadY+random.nextInt(MUNDO_ALTO))%MUNDO_ALTO;
            }
            campos[entidadX][entidadY] = true;
            entidades.add((random.nextInt(2) == 0) ?
                    new Camion(entidadX, entidadY) :
                    new Civil(entidadX, entidadY, random.nextInt(3)));
        }
    }

    public void update(float deltaTime) {
        if (finalJuego) return;
        tiempoTick += deltaTime;
        while (tiempoTick > tick) {
            tiempoTick -= tick;
            coche.avance();
            int choque = comprobarChoque();
            if (choque == -1) {
                finalJuego = true;
                return;
            } else if (choque == 1) {
                colocarEntidades();
            }
        }
    }
    public int comprobarChoque() {
        int len = coche.partes.size();
        DelicuentesDetenidos cocheCabeza = coche.partes.get(0);
        for (int i = 1; i < len; i++) {
            DelicuentesDetenidos parte = coche.partes.get(i);
            if (parte.x == cocheCabeza.x && parte.y == cocheCabeza.y)
                return -1;
        }
        for (Entidad entidad : entidades) {
            if (entidad.x == cocheCabeza.x && entidad.y == cocheCabeza.y) {
                if (entidad instanceof Civil) {
                    Civil civil = ((Civil) entidad);
                    if (civil.tipo == Civil.NINO) {
                        detenerTimerAceleracion();
                        reiniciarVelocidad();
                        if (puntuacion > PENALIZACION_NINO) puntuacion -= PENALIZACION_NINO;
                        else puntuacion = 0;
                        return -1;
                    } else if (civil.tipo == Civil.YAYA) {
                        detenerTimerAceleracion();
                        reiniciarVelocidad();
                        if (puntuacion > PENALIZACION_YAYA) puntuacion -= PENALIZACION_YAYA;
                        else puntuacion = 0;
                        return -1;
                    } else {
                        if (puntuacion > PENALIZACION_CANI) puntuacion -= PENALIZACION_CANI;
                        else puntuacion = 0;
                        return 1;
                    }
                } else if (entidad instanceof Camion) {
                    Assets.accidenteCamion.play(1);
                    for (int i = 0; i < Math.min(coche.partes.size() - 1, PENALIZACION_CAMION); i++)
                        coche.partes.remove(coche.partes.size() - 1);
                    return 1;
                } else {
                    puntuacion += INCREMENTO_PUNTUACION;
                    coche.atrapar();
                    if (coche.partes.size() == MUNDO_ANCHO * MUNDO_ALTO) return -1;
                    if (puntuacion % 100 == 0 && tick - TICK_DECREMENTO > 0)
                        tick -= TICK_DECREMENTO;
                    return 1;
                }
            }
        }


        return 0;
    }

    private void acelerarJuego() {
        try {
            // Tu lógica actual aquí
            // Decrementar gradualmente la velocidad del juego en incrementos de 0.1 hasta llegar a 0.1
            Log.d("Mundo", "Cual es mi velocidad ahora: " + tick);
            if (tick - 0.1f >= 0.2f) {
                tick -= 0.1f;
                Log.d("Mundo", "¡Juego acelerado! Nueva velocidad: " + tick);
            } else {
                tick = 0.2f;
                Log.d("Mundo", "Velocidad máxima alcanzada");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    void reiniciarVelocidad() {
        tick = TICK_INICIAL;
        Log.d("Mundo", "Velocidad del juego reiniciada");
    }
    void detenerTimerAceleracion() {
        Log.d("Mundo", "Deteniendo temporizador de aceleración");
        try {
            aceleracionTimer.cancel();
            Log.d("Mundo", "Temporizador de aceleración detenido con éxito");
        } catch (Exception e) {
            e.printStackTrace();
            Log.e("Mundo", "Error al detener el temporizador de aceleración: " + e.getMessage());
        }
    }
    void reanudarTimerAceleracion() {
        Log.d("Mundo", "A contah");
        aceleracionTimer = new Timer();
        aceleracionTimer.scheduleAtFixedRate(new TimerTask() {
            @Override
            public void run() {
                acelerarJuego();
            }
        }, INTERVALO_ACELERACION, INTERVALO_ACELERACION);
    }

}

