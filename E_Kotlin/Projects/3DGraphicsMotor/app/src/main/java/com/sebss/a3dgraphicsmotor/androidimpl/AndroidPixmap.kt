package com.sebss.a3dgraphicsmotor.androidimpl

import android.graphics.Bitmap
import com.sebss.a3dgraphicsmotor.interfaces.Graphics.PixmapFormat
import com.sebss.a3dgraphicsmotor.interfaces.Pixmap

class AndroidPixmap(var bitmap: Bitmap, override var format: PixmapFormat) : Pixmap {

    override val width: Int
        get() = bitmap.width
    override val height: Int
        get() = bitmap.height

    override fun dispose() {
        bitmap.recycle()
    }
}