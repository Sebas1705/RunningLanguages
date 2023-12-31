package com.sebss.pass_word.interfaces

import com.sebss.pass_word.interfaces.Graphics.PixmapFormat

interface Pixmap {
    val width: Int
    val height: Int
    val format: PixmapFormat
    fun dispose()
}