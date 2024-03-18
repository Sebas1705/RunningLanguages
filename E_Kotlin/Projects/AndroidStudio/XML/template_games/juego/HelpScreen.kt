package com.sebss.pass_word.juego

import com.sebss.pass_word.interfaces.Game
import com.sebss.pass_word.interfaces.Input
import com.sebss.pass_word.interfaces.Screen

class HelpScreen(game: Game,private val number: Int) : Screen(game) {

    companion object{
        const val NUMBER_OF_HELPS = 4
    }
    override fun update(deltaTime: Float) {
        val touchEvents = game.input.touchEvents
        game.input.keyEvents
        val len = touchEvents.size
        for (i in 0 until len) {
            val event = touchEvents[i]
            if (event.type == Input.TouchEvent.TOUCH_UP) {
                if (event.x > 256 && event.y > 416) {
                    if(number==NUMBER_OF_HELPS-1) game.setScreen(LoadingScreen(game))
                    else game.setScreen(HelpScreen(game,number+1))
                    if (Configuraciones.soundEnabled) Assets.press.play(1f)
                    return
                }
            }
        }
    }

    override fun present(deltaTime: Float) {
        val g = game.graphics
        g.drawPixmap(Assets.background, 0, 0)
        if(number==3) g.drawPixmap(Assets.helps[number],10, 80)
        else g.drawPixmap(Assets.helps[number], 64, 100)
        g.drawPixmap(Assets.buttons, 256, 416, 0, 64, 64, 64)
    }

    override fun pause() {}
    override fun resume() {}
    override fun dispose() {}
}