package com.sebss.juegosnake.juego;

import com.sebss.juegosnake.Graficos;
import com.sebss.juegosnake.Input.TouchEvent;
import com.sebss.juegosnake.Juego;
import com.sebss.juegosnake.Pantalla;

import java.util.List;

public class PantallaAyuda4 extends Pantalla {
    public PantallaAyuda4(Juego juego) {
        super(juego);
    }

    @Override
    public void update(float deltaTime) {
        List<TouchEvent> touchEvents = juego.getInput().getTouchEvents();
        juego.getInput().getKeyEvents();

        int len = touchEvents.size();
        for(int i = 0; i < len; i++) {
            TouchEvent event = touchEvents.get(i);
            if(event.type == TouchEvent.TOUCH_UP) {
                if(event.x > 256 && event.y > 416 ) {
                    juego.setScreen(new MainMenuScreen(juego));
                    if(Configuraciones.sonidoHabilitado)
                        Assets.pulsar.play(1);
                    return;
                }
            }
        }
    }

    @Override
    public void present(float deltaTime) {
        Graficos g = juego.getGraphics();
        g.drawPixmap(Assets.fondo, 0, 0);
        g.drawPixmap(Assets.ayuda4, 10, 80);
        g.drawPixmap(Assets.botones, 256, 416, 0, 128, 64, 64);
    }

    @Override
    public void pause() {

    }

    @Override
    public void resume() {

    }

    @Override
    public void dispose() {

    }
}