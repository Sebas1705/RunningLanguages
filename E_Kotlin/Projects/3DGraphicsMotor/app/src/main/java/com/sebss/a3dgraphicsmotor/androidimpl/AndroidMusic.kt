package com.sebss.a3dgraphicsmotor.androidimpl

import android.content.res.AssetFileDescriptor
import android.media.MediaPlayer
import android.media.MediaPlayer.OnCompletionListener
import com.sebss.a3dgraphicsmotor.interfaces.Music
import java.io.IOException

class AndroidMusic(assetDescriptor: AssetFileDescriptor) : Music, OnCompletionListener {
    private var mediaPlayer: MediaPlayer = MediaPlayer()
    private var isPrepared = false

    init {
        try {
            mediaPlayer.setDataSource(
                assetDescriptor.fileDescriptor,
                assetDescriptor.startOffset,
                assetDescriptor.length
            )
            mediaPlayer.prepare()
            isPrepared = true
            mediaPlayer.setOnCompletionListener(this)
        } catch (e: Exception) {
            throw RuntimeException("No se ha podido cargar la música")
        }
    }

    override fun dispose() {
        if (mediaPlayer.isPlaying) mediaPlayer.stop()
        mediaPlayer.release()
    }

    override var isLooping: Boolean
        get() = mediaPlayer.isLooping
        set(isLooping) {
            mediaPlayer.isLooping = isLooping
        }
    override val isPlaying: Boolean
        get() = mediaPlayer.isPlaying
    override val isStopped: Boolean
        get() = !isPrepared

    override fun pause() {
        if (mediaPlayer.isPlaying) mediaPlayer.pause()
    }

    override fun play() {
        if (mediaPlayer.isPlaying) return
        try {
            synchronized(this) {
                if (!isPrepared) mediaPlayer.prepare()
                mediaPlayer.start()
            }
        } catch (e: IllegalStateException) {
            e.printStackTrace()
        } catch (e: IOException) {
            e.printStackTrace()
        }
    }

    override fun setVolume(volume: Float) {
        mediaPlayer.setVolume(volume, volume)
    }

    override fun stop() {
        mediaPlayer.stop()
        synchronized(this) { isPrepared = false }
    }

    override fun onCompletion(player: MediaPlayer) {
        synchronized(this) { isPrepared = false }
    }
}