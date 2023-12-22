package com.sebss.juegosnake.juego;

import java.util.List;
import android.graphics.Color;
import com.sebss.juegosnake.Juego;
import com.sebss.juegosnake.Graficos;
import com.sebss.juegosnake.Input.TouchEvent;
import com.sebss.juegosnake.Pixmap;
import com.sebss.juegosnake.Pantalla;

public class PantallaJuego extends Pantalla {

    enum EstadoJuego {
        Preparado,
        Ejecutandose,
        Pausado,
        FinJuego
    }

    EstadoJuego estado = EstadoJuego.Preparado;
    Mundo mundo;
    int antiguaPuntuacion = 0;
    String puntuacion = "0";




    public PantallaJuego(Juego juego) {
        super(juego);
        mundo = new Mundo();
    }

    @Override
    public void update(float deltaTime) {
        List<TouchEvent> touchEvents = juego.getInput().getTouchEvents();
        juego.getInput().getKeyEvents();

        if(estado == EstadoJuego.Preparado)
            updateReady(touchEvents);
        if(estado == EstadoJuego.Ejecutandose)
            updateRunning(touchEvents, deltaTime);
        if(estado == EstadoJuego.Pausado)
            updatePaused(touchEvents);
        if(estado == EstadoJuego.FinJuego)
            updateGameOver(touchEvents);

    }

    private void updateReady(List<TouchEvent> touchEvents) {
        if(touchEvents.size() > 0)
            estado = EstadoJuego.Ejecutandose;

    }

    private void updateRunning(List<TouchEvent> touchEvents, float deltaTime) {

        int len = touchEvents.size();
        for(int i = 0; i < len; i++) {
            TouchEvent event = touchEvents.get(i);
            if(event.type == TouchEvent.TOUCH_UP) {
                if(event.x < 64 && event.y < 64) {
                    if(Configuraciones.sonidoHabilitado)
                        Assets.pulsar.play(1);
                    estado = EstadoJuego.Pausado;
                    return;
                }
            }
            if(event.type == TouchEvent.TOUCH_DOWN) {
                if(event.x < 64 && event.y > 416) {
                    mundo.coche.girarIzquierda();
                }
                if(event.x > 256 && event.y > 416) {
                    mundo.coche.girarDerecha();
                }
            }
        }

        mundo.update(deltaTime);
        if(mundo.finalJuego) {
            if(Configuraciones.sonidoHabilitado)
                Assets.derrota.play(1);
            estado = EstadoJuego.FinJuego;
        }
        if(antiguaPuntuacion != mundo.puntuacion) {
            antiguaPuntuacion = mundo.puntuacion;
            puntuacion = "" + antiguaPuntuacion;
            if(Configuraciones.sonidoHabilitado)
                Assets.ataque.play(1);
        }


    }


    private void updatePaused(List<TouchEvent> touchEvents) {
       // mundo.detenerTimerAceleracion();
        int len = touchEvents.size();

        for(int i = 0; i < len; i++) {

            TouchEvent event = touchEvents.get(i);
            mundo.detenerTimerAceleracion();
            if(event.type == TouchEvent.TOUCH_UP) {

                if(event.x > 80 && event.x <= 240) {

                    if(event.y > 100 && event.y <= 148) {
                        if(Configuraciones.sonidoHabilitado)
                            Assets.pulsar.play(1);

                        estado = EstadoJuego.Ejecutandose;
                        mundo.reanudarTimerAceleracion();
                        return;
                    }
                    if(event.y > 148 && event.y < 196) {
                        if(Configuraciones.sonidoHabilitado) {
                            Assets.pulsar.play(1);
                            Assets.ambiente.stop();
                        }
                        mundo.reiniciarVelocidad();
                        mundo.detenerTimerAceleracion();
                        juego.setScreen(new MainMenuScreen(juego));
                        return;
                    }
                }
            }
        }
    }

    private void updateGameOver(List<TouchEvent> touchEvents) {
        int len = touchEvents.size();
        for(int i = 0; i < len; i++) {
            TouchEvent event = touchEvents.get(i);
            if(event.type == TouchEvent.TOUCH_UP) {
                if(event.x >= 128 && event.x <= 192 &&
                        event.y >= 200 && event.y <= 264) {
                    if(Configuraciones.sonidoHabilitado) {
                        Assets.pulsar.play(1);
                        Assets.ambiente.stop();
                    }
                    mundo.reiniciarVelocidad();
                    mundo.detenerTimerAceleracion();

                    juego.setScreen(new MainMenuScreen(juego));
                    return;
                }
            }
        }
    }


    @Override
    public void present(float deltaTime) {
        Graficos g = juego.getGraphics();


        g.drawPixmap(Assets.fondo, 0, 0);
        drawWorld(mundo);
        if(estado == EstadoJuego.Preparado)
            drawReadyUI();
        if(estado == EstadoJuego.Ejecutandose)
            drawRunningUI();
        if(estado == EstadoJuego.Pausado)
            drawPausedUI();
        if(estado == EstadoJuego.FinJuego)
            drawGameOverUI();


        drawText(g, puntuacion, g.getWidth() / 2 - puntuacion.length()*20 / 2, g.getHeight() - 42);
    }

    private void drawWorld(Mundo mundo) {
        Graficos g = juego.getGraphics();
        CochePolicia coche = mundo.coche;
        DelicuentesDetenidos head = coche.partes.get(0);


        Pixmap stainPixmap;
        Delincuente delincuente = ((Delincuente)mundo.entidades.get(0));
        if(delincuente.tipo== Delincuente.LADRON)
            stainPixmap = Assets.ladron;
        else if(delincuente.tipo == Delincuente.HACKER)
            stainPixmap = Assets.hacker;
        else
            stainPixmap = Assets.mafioso;
        int x = delincuente.x * 32;
        int y = delincuente.y * 32;
        g.drawPixmap(stainPixmap, x, y);

        for(int i=1;i<mundo.entidades.size();i++){
            Entidad entidad = mundo.entidades.get(i);
            if(entidad instanceof Civil){
                Civil civil = ((Civil)entidad);
                if(civil.tipo == Civil.YAYA)
                    stainPixmap = Assets.yaya;
                else if(civil.tipo == Civil.NINO)
                    stainPixmap = Assets.nino;
                else
                    stainPixmap = Assets.cani;
                x = civil.x * 32;
                y = civil.y * 32;
                g.drawPixmap(stainPixmap, x, y);
            }else {
                Camion camion = ((Camion)entidad);
                stainPixmap = Assets.camion;
                x = camion.x * 32;
                y = camion.y * 32;
                g.drawPixmap(stainPixmap, x, y);
            }
        }

        int len = coche.partes.size();
        for(int i = 1; i < len; i++) {
            DelicuentesDetenidos part = coche.partes.get(i);
            x = part.x * 32;
            y = part.y * 32;
            g.drawPixmap(Assets.delicuenteDetenido, x, y);
        }

        Pixmap headPixmap = null;
        if(coche.direccion == CochePolicia.ARRIBA)
            headPixmap = Assets.cochearriba;
        if(coche.direccion == CochePolicia.IZQUIERDA)
            headPixmap = Assets.cocheizquierda;
        if(coche.direccion == CochePolicia.ABAJO)
            headPixmap = Assets.cocheabajo;
        if(coche.direccion == CochePolicia.DERECHA)
            headPixmap = Assets.cochederecha;
        x = head.x * 32 + 16;
        y = head.y * 32 + 16;
        assert headPixmap != null;
        g.drawPixmap(headPixmap, x - headPixmap.getWidth() / 2, y - headPixmap.getHeight() / 2);
    }

    private void drawReadyUI() {
        Graficos g = juego.getGraphics();

        g.drawPixmap(Assets.preparado, 47, 100);
        g.drawLine(0, 416, 480, 416, Color.BLACK);
    }

    private void drawRunningUI() {
        Graficos g = juego.getGraphics();

        g.drawPixmap(Assets.botones, 0, 0, 64, 128, 64, 64);
        g.drawLine(0, 416, 480, 416, Color.BLACK);
        g.drawPixmap(Assets.botones, 0, 416, 64, 64, 64, 64);
        g.drawPixmap(Assets.botones, 256, 416, 0, 64, 64, 64);
    }

    private void drawPausedUI() {
        Graficos g = juego.getGraphics();

        g.drawPixmap(Assets.menupausa, 80, 100);
        g.drawLine(0, 416, 480, 416, Color.BLACK);
    }

    private void drawGameOverUI() {
        Graficos g = juego.getGraphics();

        g.drawPixmap(Assets.finjuego, 62, 100);
        g.drawPixmap(Assets.botones, 128, 200, 0, 128, 64, 64);
        g.drawLine(0, 416, 480, 416, Color.BLACK);
    }

    public void drawText(Graficos g, String line, int x, int y) {
        int len = line.length();
        for (int i = 0; i < len; i++) {
            char character = line.charAt(i);

            if (character == ' ') {
                x += 20;
                continue;
            }

            int srcX;
            int srcWidth;
            if (character == '.') {
                srcX = 200;
                srcWidth = 10;
            } else {
                srcX = (character - '0') * 20;
                srcWidth = 20;
            }

            g.drawPixmap(Assets.numeros, x, y, srcX, 0, srcWidth, 32);
            x += srcWidth;
        }
    }

    @Override
    public void pause() {
        if(estado == EstadoJuego.Ejecutandose)
            estado = EstadoJuego.Pausado;


        if(mundo.finalJuego) {

            Configuraciones.addScore(mundo.puntuacion);
            Configuraciones.save(juego.getFileIO());
        }
    }

    @Override
    public void resume() {

    }

    @Override
    public void dispose() {

    }
}