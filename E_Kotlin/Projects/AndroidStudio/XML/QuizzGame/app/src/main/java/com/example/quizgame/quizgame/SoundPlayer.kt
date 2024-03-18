package com.example.quizgame.quizgame

import android.content.Context
import android.media.MediaPlayer
class SoundPlayer (private val context: Context){

    //Components:
    private var mediaPlayer: MediaPlayer? = null

    //Play function:
    fun playSound(resourceId: Int) {
        try {
            mediaPlayer?.release()
            mediaPlayer = MediaPlayer.create(context, resourceId)
            mediaPlayer?.start()
        } catch (e: Exception) {
            e.printStackTrace()
        }
    }

}