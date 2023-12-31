package com.sebss.pass_word.androidimpl

import android.media.SoundPool
import com.sebss.pass_word.interfaces.Sound

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