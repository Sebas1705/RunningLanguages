package com.sebss.juegosnake.juego;

import com.sebss.juegosnake.Juego;
import com.sebss.juegosnake.Graficos;
import com.sebss.juegosnake.Pantalla;
import com.sebss.juegosnake.Graficos.PixmapFormat;

public class LoadingScreen extends Pantalla{
    public LoadingScreen(Juego juego) {
        super(juego);
    }

    @Override
    public void update(float deltaTime) {
        Graficos g = juego.getGraphics();
        Assets.fondo = g.newPixmap("fondo.png", PixmapFormat.RGB565);
        Assets.logo = g.newPixmap("logo.png", PixmapFormat.ARGB4444);
        Assets.menuprincipal = g.newPixmap("menuprincipal.png", PixmapFormat.ARGB4444);
        Assets.botones = g.newPixmap("botones.png", PixmapFormat.ARGB4444);
        Assets.ayuda1 = g.newPixmap("ayuda1.png", PixmapFormat.ARGB4444);
        Assets.ayuda2 = g.newPixmap("ayuda2.png", PixmapFormat.ARGB4444);
        Assets.ayuda3 = g.newPixmap("ayuda3.png", PixmapFormat.ARGB4444);
        Assets.ayuda4 = g.newPixmap("ayuda4.png", PixmapFormat.ARGB4444);
        Assets.numeros = g.newPixmap("numeros.png", PixmapFormat.ARGB4444);
        Assets.preparado = g.newPixmap("preparado.png", PixmapFormat.ARGB4444);
        Assets.menupausa = g.newPixmap("menupausa.png", PixmapFormat.ARGB4444);
        Assets.finjuego = g.newPixmap("finjuego.png", PixmapFormat.ARGB4444);
        Assets.cochearriba = g.newPixmap("cochearriba.png", PixmapFormat.ARGB4444);
        Assets.cocheizquierda = g.newPixmap("cocheizquierda.png", PixmapFormat.ARGB4444);
        Assets.cocheabajo = g.newPixmap("cocheabajo.png", PixmapFormat.ARGB4444);
        Assets.cochederecha = g.newPixmap("cochederecha.png", PixmapFormat.ARGB4444);
        Assets.delicuenteDetenido = g.newPixmap("detenido.png", PixmapFormat.ARGB4444);
        Assets.ladron = g.newPixmap("ladron.png", PixmapFormat.ARGB4444);
        Assets.hacker = g.newPixmap("hacker.png", PixmapFormat.ARGB4444);
        Assets.mafioso = g.newPixmap("mafioso.png", PixmapFormat.ARGB4444);
        Assets.yaya = g.newPixmap("yaya.png", PixmapFormat.ARGB4444);
        Assets.nino = g.newPixmap("niño.png", PixmapFormat.ARGB4444);
        Assets.cani = g.newPixmap("cani.png", PixmapFormat.ARGB4444);
        Assets.camion = g.newPixmap("camion.png", PixmapFormat.ARGB4444);
        Assets.pulsar = juego.getAudio().nuevoSonido("pulsar.mp3");
        Assets.ataque = juego.getAudio().nuevoSonido("ataque.mp3");
        Assets.derrota = juego.getAudio().nuevoSonido("derrota.mp3");
        Assets.accidenteCamion=juego.getAudio().nuevoSonido("accidenteCamion.mp3");
        Assets.ambiente = juego.getAudio().nuevaMusica("ambiente.mp3");
        Assets.ambiente.setVolume(1f);
        Assets.ambiente.setLooping(true);
        
        Configuraciones.cargar(juego.getFileIO());
        juego.setScreen(new MainMenuScreen(juego));
    }

    @Override
    public void present(float deltaTime){

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