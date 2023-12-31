package com.sebss.pass_word.juego

import com.sebss.pass_word.interfaces.Game
import com.sebss.pass_word.interfaces.Graphics.PixmapFormat
import com.sebss.pass_word.interfaces.Screen
import com.sebss.pass_word.juego.Configuraciones.load

class LoadingScreen(game: Game) : Screen(game) {
    override fun update(deltaTime: Float) {
        val g = game.graphics
        Assets.background = g.newPixmap("fondo.jpg", PixmapFormat.RGB565)
        Assets.logo = g.newPixmap("logo.png", PixmapFormat.ARGB4444)
        Assets.play = g.newPixmap("play.png", PixmapFormat.ARGB4444)
        Assets.records = g.newPixmap("record.png", PixmapFormat.ARGB4444)
        Assets.shop = g.newPixmap("shop.png", PixmapFormat.ARGB4444)
        Assets.buttons = g.newPixmap("botones.png", PixmapFormat.ARGB4444)
        Assets.helps = arrayListOf(
            g.newPixmap("ayuda1.png", PixmapFormat.ARGB4444),g.newPixmap("ayuda2.png", PixmapFormat.ARGB4444),
            g.newPixmap("ayuda3.png", PixmapFormat.ARGB4444),g.newPixmap("ayuda4.png", PixmapFormat.ARGB4444))
        Assets.numbers = g.newPixmap("numeros.png", PixmapFormat.ARGB4444)
        Assets.ready = g.newPixmap("preparado.png", PixmapFormat.ARGB4444)
        Assets.pausedmenu = g.newPixmap("menupausa.png", PixmapFormat.ARGB4444)
        Assets.endgame = g.newPixmap("finjuego.png", PixmapFormat.ARGB4444)
        Assets.carUp = g.newPixmap("cochearriba.png", PixmapFormat.ARGB4444)
        Assets.carDown = g.newPixmap("cocheizquierda.png", PixmapFormat.ARGB4444)
        Assets.carLeft = g.newPixmap("cocheabajo.png", PixmapFormat.ARGB4444)
        Assets.carRight = g.newPixmap("cochederecha.png", PixmapFormat.ARGB4444)
        Assets.prisioner = g.newPixmap("detenido.png", PixmapFormat.ARGB4444)
        Assets.thief = g.newPixmap("ladron.png", PixmapFormat.ARGB4444)
        Assets.hacker = g.newPixmap("hacker.png", PixmapFormat.ARGB4444)
        Assets.gangster = g.newPixmap("mafioso.png", PixmapFormat.ARGB4444)
        Assets.yaya = g.newPixmap("yaya.png", PixmapFormat.ARGB4444)
        Assets.child = g.newPixmap("niño.png", PixmapFormat.ARGB4444)
        Assets.cani = g.newPixmap("cani.png", PixmapFormat.ARGB4444)
        Assets.truck = g.newPixmap("camion.png", PixmapFormat.ARGB4444)
        Assets.press = game.audio.newSound("pulsar.mp3")
        Assets.atack = game.audio.newSound("ataque.mp3")
        Assets.defeat = game.audio.newSound("derrota.mp3")
        Assets.truckAccident = game.audio.newSound("accidenteCamion.mp3")
        Assets.ambient = game.audio.newMusic("ambiente.mp3")
        Assets.ambient.setVolume(1f)
        Assets.ambient.isLooping = true
        load(game.fileIO)

        game.setScreen(MainMenuScreen(game))
    }

    override fun present(deltaTime: Float) {}
    override fun pause() {}
    override fun resume() {}
    override fun dispose() {}
}