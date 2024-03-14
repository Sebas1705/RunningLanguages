package com.sebss.pass_word.androidimpl

import android.app.Activity
import android.content.res.AssetManager
import android.media.AudioManager
import android.media.SoundPool
import com.sebss.pass_word.interfaces.Audio
import com.sebss.pass_word.interfaces.Music
import com.sebss.pass_word.interfaces.Sound
import java.io.IOException

class AndroidAudio(activity: Activity) : Audio {
    var assets: AssetManager
    private var soundPool: SoundPool

    init {
        activity.volumeControlStream = AudioManager.STREAM_MUSIC
        assets = activity.assets
        soundPool = SoundPool.Builder()
            .setMaxStreams(20)
            .build()
    }

    override fun newMusic(fileName: String): Music {
        return try {
            val assetDescriptor = assets.openFd(fileName)
            AndroidMusic(assetDescriptor)
        } catch (e: IOException) {
            throw RuntimeException("no se ha podido cargar archivo '$fileName'")
        }
    }

    override fun newSound(fileName: String): Sound {
        return try {
            val assetDescriptor = assets.openFd(fileName)
            val soundId = soundPool.load(assetDescriptor, 0)
            AndroidSound(soundPool, soundId)
        } catch (e: IOException) {
            throw RuntimeException("No se ha podido cargar archivo '$fileName'")
        }
    }
}