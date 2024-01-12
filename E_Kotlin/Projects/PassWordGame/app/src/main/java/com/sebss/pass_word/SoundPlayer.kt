package com.sebss.pass_word

import android.content.Context
import android.media.MediaPlayer
import android.util.Log

class SoundPlayer (){

    //Components:
    private var mediaPlayer: MediaPlayer? = null

    //Play function:
    fun playSound(resourceId: Int,context: Context) {
        try {
            mediaPlayer?.release()
            mediaPlayer = MediaPlayer.create(context, resourceId)
            mediaPlayer?.start()
        } catch (e: Exception) {
            e.message?.let { Log.d("Sound Error", it) }
        }
    }

}