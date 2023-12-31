package com.sebss.a3dgraphicsmotor.androidimpl

import android.media.SoundPool
import com.sebss.a3dgraphicsmotor.interfaces.Sound

class AndroidSound(private var soundPool: SoundPool, private var soundId: Int) : Sound {
    override fun play(volume: Float) {
        soundPool.play(soundId, volume, volume, 0, 0, 1f)
    }

    override fun dispose() {
        soundPool.unload(soundId)
    }

    override fun stop() {
        soundPool.stop(soundId)
    }
}