package com.sebss.a3dgraphicsmotor.interfaces

import com.sebss.a3dgraphicsmotor.interfaces.Graphics.PixmapFormat

interface Pixmap {
    val width: Int
    val height: Int
    val format: PixmapFormat
    fun dispose()
}