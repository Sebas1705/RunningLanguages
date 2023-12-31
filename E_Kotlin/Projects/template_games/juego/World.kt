package com.sebss.pass_word.juego

import java.util.Random
import java.util.Timer
import java.util.TimerTask
import kotlin.math.ceil

class World {

    @JvmField
    var car: PoliceCar = PoliceCar()

    @JvmField
    var entities = ArrayList<Entity>()

    @JvmField
    var gameEnd = false

    @JvmField
    var points = 0
    private var accelerationTimer: Timer
    private var boxes = Array(WORLD_WIDTH) { BooleanArray(WORLD_HEIGHT) }
    private var random = Random()
    private var tickTime = 0f

    init {
        spawnEntities()
        accelerationTimer = Timer()
        accelerationTimer.scheduleAtFixedRate(object : TimerTask() {
            override fun run() {
                accelerateGame()
            }
        }, ACCELERATION_INTER.toLong(), ACCELERATION_INTER.toLong())
    }

    private fun spawnEntities() {
        for (x in 0 until WORLD_WIDTH) {
            for (y in 0 until WORLD_HEIGHT) {
                boxes[x][y] = false
            }
        }
        entities.clear()
        val len = car.parts.size
        for (i in 0 until len) {
            val parte = car.parts[i]
            boxes[parte.x][parte.y] = true
        }
        var delinquentX = random.nextInt(WORLD_WIDTH)
        var delinquentY = random.nextInt(WORLD_HEIGHT)
        while (boxes[delinquentX][delinquentY]) {
            delinquentX += 1
            if (delinquentX >= WORLD_WIDTH) {
                delinquentX = 0
                delinquentY += 1
                if (delinquentY >= WORLD_HEIGHT) {
                    delinquentY = 0
                }
            }
        }
        boxes[delinquentX][delinquentY] = true
        entities.add(Delinquent(delinquentX, delinquentY, random.nextInt(3)))
        val maxEntities = ceil(
            random.nextInt(MAX_ENTITIES * (1 - car.parts.size / (WORLD_HEIGHT * WORLD_WIDTH)))
                .toDouble()
        ).toInt()
        for (i in 0 until maxEntities) {
            var entityX = random.nextInt(WORLD_WIDTH)
            var entityY = random.nextInt(WORLD_HEIGHT)
            while (boxes[entityX][entityY]) {
                entityX = (entityX + random.nextInt(WORLD_WIDTH)) % WORLD_WIDTH
                entityY = (entityY + random.nextInt(WORLD_HEIGHT)) % WORLD_HEIGHT
            }
            boxes[entityX][entityY] = true
            entities.add(
                if (random.nextInt(2) == 0) Truck(entityX, entityY) else Civil(
                    entityX,
                    entityY,
                    random.nextInt(3)
                )
            )
        }
    }

    fun update(deltaTime: Float) {
        if (gameEnd) return
        tickTime += deltaTime
        while (tickTime > tick) {
            tickTime -= tick
            car.go()
            val crash = checkCrashed()
            if (crash == -1) {
                gameEnd = true
                return
            } else if (crash == 1) {
                spawnEntities()
            }
        }
    }

    private fun checkCrashed(): Int {
        val len = car.parts.size
        val car = car.parts[0]
        for (i in 1 until len) {
            val parte = this.car.parts[i]
            if (parte.x == car.x && parte.y == car.y) return -1
        }
        for (entity in entities) {
            if (entity.x == car.x && entity.y == car.y) {
                return when (entity) {
                    is Civil -> {
                        when (entity.tipo) {
                            Civil.NINO -> {
                                stopTimerAccelerate()
                                resetTickVelocity()
                                if (points > CHILD_PENALTY) points -= CHILD_PENALTY else points = 0
                                -1
                            }

                            Civil.YAYA -> {
                                stopTimerAccelerate()
                                resetTickVelocity()
                                if (points > YAYA_PENALTY) points -= YAYA_PENALTY else points = 0
                                -1
                            }

                            else -> {
                                if (points > CANI_PENALTY) points -= CANI_PENALTY else points = 0
                                1
                            }
                        }
                    }

                    is Truck -> {
                        Assets.truckAccident.play(1f)
                        for (i in 0 until (this.car.parts.size - 1).coerceAtMost(TRUCK_PENALTY))
                            this.car.parts.removeAt(this.car.parts.size - 1)
                        1
                    }

                    else -> {
                        points += POINTS_INCREMENT
                        this.car.catchDelinquent()
                        if (this.car.parts.size == WORLD_WIDTH * WORLD_HEIGHT) return -1
                        if (points % 100 == 0 && tick - TICK_DECREMENT > 0) tick -= TICK_DECREMENT
                        1
                    }
                }
            }
        }
        return 0
    }

    private fun accelerateGame() {
        try {
            if (tick - 0.1f >= 0.2f) {
                tick -= 0.1f
            } else {
                tick = 0.2f
            }
        } catch (e: Exception) {
            e.printStackTrace()
        }
    }

    fun resetTickVelocity() {
        tick = FIRST_TICK
    }

    fun stopTimerAccelerate() {
        try {
            accelerationTimer.cancel()
        } catch (e: Exception) {
            e.printStackTrace()
        }
    }

    fun continueTimerAccelerate() {
        accelerationTimer = Timer()
        accelerationTimer.scheduleAtFixedRate(object : TimerTask() {
            override fun run() {
                accelerateGame()
            }
        }, ACCELERATION_INTER.toLong(), ACCELERATION_INTER.toLong())
    }

    companion object {
        const val WORLD_WIDTH = 48
        const val WORLD_HEIGHT = 13
        const val POINTS_INCREMENT = 10
        const val FIRST_TICK = 0.5f
        const val TICK_DECREMENT = 0.05f
        const val MAX_ENTITIES = 6
        const val YAYA_PENALTY = 50
        const val CHILD_PENALTY = 100
        const val CANI_PENALTY = 10
        const val TRUCK_PENALTY = 3
        private const val ACCELERATION_INTER = 30 * 1000 // 30 segundos en milisegundos
        var tick = FIRST_TICK
    }
}