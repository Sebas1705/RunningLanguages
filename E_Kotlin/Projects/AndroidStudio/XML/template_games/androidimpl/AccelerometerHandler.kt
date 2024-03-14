package com.sebss.pass_word.androidimpl

import android.content.Context
import android.hardware.Sensor
import android.hardware.SensorEvent
import android.hardware.SensorEventListener
import android.hardware.SensorManager

class AccelerometerHandler(context: Context) : SensorEventListener {
    @JvmField
    var accelX = 0f

    @JvmField
    var accelY = 0f

    @JvmField
    var accelZ = 0f

    init {
        val manager = context
            .getSystemService(Context.SENSOR_SERVICE) as SensorManager
        if (manager.getSensorList(Sensor.TYPE_ACCELEROMETER).size != 0) {
            val accelerometer = manager.getSensorList(
                Sensor.TYPE_ACCELEROMETER
            )[0]
            manager.registerListener(
                this, accelerometer,
                SensorManager.SENSOR_DELAY_GAME
            )
        }
    }

    override fun onAccuracyChanged(sensor: Sensor, accuracy: Int) {
        // No hace nada
    }

    override fun onSensorChanged(event: SensorEvent) {
        accelX = event.values[0]
        accelY = event.values[1]
        accelZ = event.values[2]
    }
}