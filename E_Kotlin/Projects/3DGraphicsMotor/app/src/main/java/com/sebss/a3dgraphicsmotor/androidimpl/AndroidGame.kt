package com.sebss.a3dgraphicsmotor.androidimpl

import android.annotation.SuppressLint
import android.app.Activity
import android.content.res.Configuration
import android.graphics.Bitmap
import android.os.Bundle
import android.os.PowerManager
import android.os.PowerManager.WakeLock
import android.util.DisplayMetrics
import android.view.View
import android.view.WindowManager
import com.sebss.a3dgraphicsmotor.R
import com.sebss.a3dgraphicsmotor.interfaces.Audio
import com.sebss.a3dgraphicsmotor.interfaces.FileIO
import com.sebss.a3dgraphicsmotor.interfaces.Game
import com.sebss.a3dgraphicsmotor.interfaces.Graphics
import com.sebss.a3dgraphicsmotor.interfaces.Input
import com.sebss.a3dgraphicsmotor.interfaces.Screen

abstract class AndroidGame : Activity(), Game {
    private lateinit var renderView: AndroidFastRenderView
    override lateinit var graphics: Graphics
    override lateinit var audio: Audio
    override lateinit var input: Input
    override lateinit var fileIO: FileIO
    override lateinit var currentScreen: Screen
    private lateinit var wakeLock: WakeLock
    @SuppressLint("InvalidWakeLockTag")
    public override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        window.addFlags(WindowManager.LayoutParams.FLAG_KEEP_SCREEN_ON)
        val isLandscape = resources.configuration.orientation == Configuration.ORIENTATION_LANDSCAPE
        val frameBufferWidth = if (isLandscape) 1920 else 320
        val frameBufferHeight = if (isLandscape) 1080 else 480
        val frameBuffer = Bitmap.createBitmap(
            frameBufferWidth,
            frameBufferHeight, Bitmap.Config.ARGB_8888
        )
        val displayMetrics = DisplayMetrics()
        windowManager.defaultDisplay.getMetrics(displayMetrics)
        val scaleX = frameBufferWidth.toFloat() / displayMetrics.widthPixels
        val scaleY = frameBufferHeight.toFloat() / displayMetrics.heightPixels
        renderView = AndroidFastRenderView(this, frameBuffer)
        graphics = AndroidGraphics(assets, frameBuffer)
        fileIO = AndroidFileIO(assets)
        audio = AndroidAudio(this)
        input = AndroidInput(this, renderView, scaleX, scaleY)
        setContentView(renderView)
        val powerManager = getSystemService(POWER_SERVICE) as PowerManager
        wakeLock = powerManager.newWakeLock(PowerManager.PARTIAL_WAKE_LOCK, "GLGame")
    }

    public override fun onResume() {
        super.onResume()
        wakeLock.acquire(10 * 60 * 1000L /*10 minutes*/)
        currentScreen.resume()
        renderView.resume()
    }

    public override fun onPause() {
        super.onPause()
        wakeLock.release()
        renderView.pause()
        currentScreen.pause()
        if (isFinishing) currentScreen.dispose()
    }

    override fun setScreen(screen: Screen) {
        currentScreen.pause()
        currentScreen.dispose()
        screen.resume()
        screen.update(0f)
        currentScreen = screen
    }

}