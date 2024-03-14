package com.sebss.pass_word.androidimpl

import android.graphics.Bitmap
import com.sebss.pass_word.interfaces.Graphics.PixmapFormat
import com.sebss.pass_word.interfaces.Pixmap

class AndroidPixmap(var bitmap: Bitmap, override var format: PixmapFormat) : Pixmap {

    override val width: Int
        get() = bitmap.width
    override val height: Int
        get() = bitmap.height

    override fun dispose() {
        bitmap.recycle()
    }
}