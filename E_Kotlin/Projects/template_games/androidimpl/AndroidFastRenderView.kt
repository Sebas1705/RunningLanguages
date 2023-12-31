package com.sebss.pass_word.androidimpl

import android.annotation.SuppressLint
import android.graphics.Bitmap
import android.graphics.Rect
import android.view.SurfaceHolder
import android.view.SurfaceView

@SuppressLint("ViewConstructor")
class AndroidFastRenderView(var juego: AndroidGame, private var framebuffer: Bitmap) : SurfaceView(juego), Runnable {
    private var renderThread: Thread? = null
    private var holder: SurfaceHolder = getHolder()

    @Volatile
    var running = false

    fun resume() {
        running = true
        renderThread = Thread(this)
        renderThread!!.start()
    }

    override fun run() {
        val dstRect = Rect()
        var startTime = System.nanoTime()
        while (running) {
            if (!holder.surface.isValid) continue
            val deltaTime = (System.nanoTime() - startTime) / 1000000000.0f
            startTime = System.nanoTime()
            juego.currentScreen.update(deltaTime)
            juego.currentScreen.present(deltaTime)
            val canvas = holder.lockCanvas()
            canvas.getClipBounds(dstRect)
            canvas.drawBitmap(framebuffer, null, dstRect, null)
            holder.unlockCanvasAndPost(canvas)
        }
    }

    fun pause() {
        running = false
        while (true) {
            try {
                renderThread!!.join()
                break
            } catch (e: InterruptedException) {
                // retry
            }
        }
    }
}