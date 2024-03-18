package com.sebss.pass_word.juego

import android.graphics.Color
import com.sebss.pass_word.interfaces.Game
import com.sebss.pass_word.interfaces.Graphics
import com.sebss.pass_word.interfaces.Input
import com.sebss.pass_word.interfaces.Pixmap
import com.sebss.pass_word.interfaces.Screen
import com.sebss.pass_word.juego.Configuraciones.addScore
import com.sebss.pass_word.juego.Configuraciones.save

class GameScreen(game: Game) : Screen(game) {
    enum class GameState {
        READY, RUNNING, PAUSED, ENDGAME
    }

    private var state = GameState.READY
    private var world: World = World()
    private var lastPoints = 0
    private var points = "0"

    override fun update(deltaTime: Float) {
        val touchEvents = game.input.touchEvents
        game.input.keyEvents
        if (state == GameState.READY) updateReady(touchEvents)
        if (state == GameState.RUNNING) updateRunning(touchEvents, deltaTime)
        if (state == GameState.PAUSED) updatePaused(touchEvents)
        if (state == GameState.ENDGAME) updateGameOver(touchEvents)
    }

    private fun updateReady(touchEvents: List<Input.TouchEvent?>?) {
        if (touchEvents!!.isNotEmpty()) state = GameState.RUNNING
    }

    private fun updateRunning(touchEvents: List<Input.TouchEvent?>?, deltaTime: Float) {
        val len = touchEvents!!.size
        for (i in 0 until len) {
            val event = touchEvents[i]
            if (event!!.type == Input.TouchEvent.TOUCH_UP) {
                if (event.x < 64 && event.y < 64) {
                    if (Configuraciones.soundEnabled) {
                        Assets.press.play(1f)
                    }
                    state = GameState.PAUSED
                    return
                }
            }
            if (event.type == Input.TouchEvent.TOUCH_DOWN) {
                if (event.x < 64 && event.y > 416) {
                    world.car.turnLeft()
                }
                if (event.x > 256 && event.y > 416) {
                    world.car.turnRight()
                }
            }
        }
        world.update(deltaTime)
        if (world.gameEnd) {
            if (Configuraciones.soundEnabled) {
                Assets.defeat.play(1f)
            }
            state = GameState.ENDGAME
        }
        if (lastPoints != world.points) {
            lastPoints = world.points
            points = "" + lastPoints
            if (Configuraciones.soundEnabled) {
                Assets.atack.play(1f)
            }
        }
    }

    private fun updatePaused(touchEvents: List<Input.TouchEvent?>?) {
        val len = touchEvents!!.size
        for (i in 0 until len) {
            val event = touchEvents[i]
            world.stopTimerAccelerate()
            if (event!!.type == Input.TouchEvent.TOUCH_UP) {
                if (event.x in 81..240) {
                    if (event.y in 101..148) {
                        if (Configuraciones.soundEnabled) {
                            Assets.press.play(1f)
                        }
                        state = GameState.RUNNING
                        world.continueTimerAccelerate()
                        return
                    }
                    if (event.y in 149..195) {
                        if (Configuraciones.soundEnabled) {
                            Assets.press.play(1f)
                            Assets.ambient.stop()
                        }
                        world.resetTickVelocity()
                        world.stopTimerAccelerate()
                        game.setScreen(MainMenuScreen(game))
                        return
                    }
                }
            }
        }
    }

    private fun updateGameOver(touchEvents: List<Input.TouchEvent?>?) {
        val len = touchEvents!!.size
        for (i in 0 until len) {
            val event = touchEvents[i]
            if (event!!.type == Input.TouchEvent.TOUCH_UP) {
                if (event.x in 128..192 && event.y >= 200 && event.y <= 264) {
                    if (Configuraciones.soundEnabled)
                        Assets.press.play(1f)
                    Assets.ambient.stop()
                }
                world.resetTickVelocity()
                world.stopTimerAccelerate()
                game.setScreen(MainMenuScreen(game))
                return
            }
        }
    }

    override fun present(deltaTime: Float) {
        val g = game.graphics
        g.drawPixmap(Assets.background, 0, 0)
        drawWorld(world)
        if (state == GameState.READY) drawReadyUI()
        if (state == GameState.RUNNING) drawRunningUI()
        if (state == GameState.PAUSED) drawPausedUI()
        if (state == GameState.ENDGAME) drawGameOverUI()
        drawText(g, points, g.width / 2 - points.length * 20 / 2, g.height - 42)
    }

    private fun drawWorld(world: World) {
        val g = game.graphics
        val car = world.car
        val headCar = car.parts[0]
        var stainPixmap: Pixmap?
        val delinquent = world.entities[0] as Delinquent
        stainPixmap =
            if (delinquent.type == Delinquent.THIEF) Assets.thief else if (delinquent.type == Delinquent.HACKER) Assets.hacker else Assets.gangster
        var x = delinquent.x * 32
        var y = delinquent.y * 32
        g.drawPixmap(stainPixmap, x, y)
        for (i in 1 until world.entities.size) {
            val entity = world.entities[i]
            if (entity is Civil) {
                stainPixmap =
                    if (entity.tipo == Civil.YAYA) Assets.yaya else if (entity.tipo == Civil.NINO) Assets.child else Assets.cani
                x = entity.x * 32
                y = entity.y * 32
                g.drawPixmap(stainPixmap, x, y)
            } else {
                val truck = entity as Truck
                stainPixmap = Assets.truck
                x = truck.x * 32
                y = truck.y * 32
                g.drawPixmap(stainPixmap, x, y)
            }
        }
        val len = car.parts.size
        for (i in 1 until len) {
            val part = car.parts[i]
            x = part.x * 32 
            y = part.y * 32
            g.drawPixmap(Assets.prisioner, x, y)
        }
        var headPixmap: Pixmap = Assets.carUp
        when (car.direction) {
            PoliceCar.LEFT -> headPixmap = Assets.carDown
            PoliceCar.DOWN -> headPixmap = Assets.carLeft
            PoliceCar.RIGHT -> headPixmap = Assets.carRight
        }
        x = headCar.x * 32 + 16
        y = headCar.y * 32 + 16
        g.drawPixmap(headPixmap, x - headPixmap.width / 2, y - headPixmap.height / 2)
    }

    private fun drawReadyUI() {
        val g = game.graphics
        g.drawPixmap(Assets.ready, 47, 100)
        g.drawLine(0, 416, 480, 416, Color.BLACK)
    }

    private fun drawRunningUI() {
        val g = game.graphics
        g.drawPixmap(Assets.buttons, 0, 0, 64, 128, 64, 64)
        g.drawLine(0, 416, 480, 416, Color.BLACK)
        g.drawPixmap(Assets.buttons, 0, 416, 64, 64, 64, 64)
        g.drawPixmap(Assets.buttons, 256, 416, 0, 64, 64, 64)
    }

    private fun drawPausedUI() {
        val g = game.graphics
        g.drawPixmap(Assets.pausedmenu, 80, 100)
        g.drawLine(0, 416, 480, 416, Color.BLACK)
    }

    private fun drawGameOverUI() {
        val g = game.graphics
        g.drawPixmap(Assets.endgame, 62, 100)
        g.drawPixmap(Assets.buttons, 128, 200, 0, 128, 64, 64)
        g.drawLine(0, 416, 480, 416, Color.BLACK)
    }

    fun drawText(g: Graphics, line: String, x: Int, y: Int) {
        var x = x
        val len = line.length
        for (i in 0 until len) {
            val character = line[i]
            if (character == ' ') {
                x += 20
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
            g.drawPixmap(Assets.numbers, x, y, srcX, 0, srcWidth, 32)
            x += srcWidth
        }
    }

    override fun pause() {
        if (state == GameState.RUNNING) state = GameState.PAUSED
        if (world.gameEnd) {
            addScore(world.points)
            save(game.fileIO)
        }
    }

    override fun resume() {}
    override fun dispose() {}
}