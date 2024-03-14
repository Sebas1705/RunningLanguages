package com.sebss.pass_word.juego

import com.sebss.pass_word.interfaces.Game
import com.sebss.pass_word.interfaces.Graphics
import com.sebss.pass_word.interfaces.Input
import com.sebss.pass_word.interfaces.Screen
import com.sebss.pass_word.juego.Configuraciones.save

class MainMenuScreen(game: Game) : Screen(game) {
    
    override fun update(deltaTime: Float) {
        val g: Graphics = game.graphics
        val touchEvents = game.input.touchEvents
        game.input.keyEvents
        val len = touchEvents.size
        for (i in 0 until len) {
            val event = touchEvents[i]
            if (event.type == Input.TouchEvent.TOUCH_UP) {
                if (inBounds(event, 0, g.height - 64, 64, 64)) {
                    Configuraciones.soundEnabled = !Configuraciones.soundEnabled
                    if (Configuraciones.soundEnabled) Assets.press.play(1f) else Assets.ambient.stop()
                    return
                }
                if (inBounds(event, 80, 220, 395, 155)) {
                    game.setScreen(
                        GameScreen(
                            game
                        )
                    )
                    if (Configuraciones.soundEnabled) {
                        Assets.press.play(1f)
                        Assets.ambient.play()
                    }
                    return
                }
                if (inBounds(event, 64, 220 + 42, 192, 42)) {
                    game.setScreen(
                        RecordScreen(
                            game
                        )
                    )
                    if (Configuraciones.soundEnabled) Assets.press.play(1f)
                    return
                }
                if (inBounds(event, 64, 220 + 84, 192, 42)) {
                    game.setScreen(
                        HelpScreen(
                            game,0
                        )
                    )
                    if (Configuraciones.soundEnabled) Assets.press.play(1f)
                    return
                }
            }
        }
    }

    private fun inBounds(
        event: Input.TouchEvent?,
        x: Int,
        y: Int,
        width: Int,
        height: Int
    ): Boolean {
        return event!!.x > x && event.x < x + width - 1 && event.y > y && event.y < y + height - 1
    }

    override fun present(deltaTime: Float) {
        val g: Graphics = game.graphics
        g.drawPixmap(Assets.background, 0, 0)
        g.drawPixmap(Assets.logo, 860, -50)
        g.drawPixmap(Assets.play, 80, 220)
        g.drawPixmap(Assets.records, 80, 380)
        g.drawPixmap(Assets.shop, 80, 540)
        if (Configuraciones.soundEnabled) g.drawPixmap(
            Assets.buttons,
            20,
            900,
            0,
            0,
            64,
            64
        ) else g.drawPixmap(
            Assets.buttons, 20, 900, 64, 0, 64, 64
        )
    }

    override fun pause() {
        save(game.fileIO)
    }

    override fun resume() {}
    override fun dispose() {}
}