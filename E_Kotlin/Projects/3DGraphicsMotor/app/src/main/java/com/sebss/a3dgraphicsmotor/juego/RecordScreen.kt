package com.sebss.a3dgraphicsmotor.juego

import com.sebss.a3dgraphicsmotor.interfaces.Game
import com.sebss.a3dgraphicsmotor.interfaces.Graphics
import com.sebss.a3dgraphicsmotor.interfaces.Input
import com.sebss.a3dgraphicsmotor.interfaces.Screen

class RecordScreen(game: Game) : Screen(game) {
    private var lines = arrayOfNulls<String>(5)

    init {
        for (i in 0..4) {
            lines[i] = "" + (i + 1) + ". " + Configuraciones.records[i]
        }
    }

    override fun update(deltaTime: Float) {
        val touchEvents = game.input.touchEvents
        game.input.keyEvents
        val len = touchEvents.size
        for (i in 0 until len) {
            val event = touchEvents[i]
            if (event.type == Input.TouchEvent.TOUCH_UP) {
                if (event.x < 64 && event.y > 416) {
                    if (Configuraciones.soundEnabled) {
                        Assets.press.play(1f)
                    }
                    game.setScreen(MainMenuScreen(game))
                    return
                }
            }
        }
    }

    override fun present(deltaTime: Float) {
        val g = game.graphics
        g.drawPixmap(Assets.background, 0, 0)
        g.drawPixmap(Assets.play, 64, 20, 0, 44, 196, 42)
        var y = 100
        for (i in 0..4) {
            drawText(g, lines[i], 20, y)
            y += 50
        }
        g.drawPixmap(Assets.buttons, 0, 416, 64, 64, 64, 64)
    }

    fun drawText(g: Graphics, linea: String?, x: Int, y: Int) {
        var xV = x
        val len = linea!!.length
        for (i in 0 until len) {
            val character = linea[i]
            if (character == ' ') {
                xV += 20
                continue
            }
            var srcX: Int
            var srcWidth: Int
            if (character == '.') {
                srcX = 200
                srcWidth = 10
            } else {
                srcX = (character.code - '0'.code) * 20
                srcWidth = 20
            }
            g.drawPixmap(Assets.numbers, xV, y, srcX, 0, srcWidth, 32)
            xV += srcWidth
        }
    }

    override fun pause() {}
    override fun resume() {}
    override fun dispose() {}
}