package com.sebss.a3dgraphicsmotor.androidimpl

import android.content.res.AssetManager
import android.graphics.Bitmap
import android.graphics.BitmapFactory
import android.graphics.Canvas
import android.graphics.Paint
import android.graphics.Rect
import com.sebss.a3dgraphicsmotor.interfaces.Graphics
import com.sebss.a3dgraphicsmotor.interfaces.Graphics.PixmapFormat
import com.sebss.a3dgraphicsmotor.interfaces.Pixmap
import java.io.IOException
import java.io.InputStream

class AndroidGraphics(var assets: AssetManager, private var frameBuffer: Bitmap) : Graphics {
    private var canvas = Canvas(frameBuffer)
    private var paint = Paint()
    private var srcRect = Rect()
    private var dstRect = Rect()

    override fun newPixmap(fileName: String, format: PixmapFormat): Pixmap {
        var formatv = format
        val config: Bitmap.Config =
            if (formatv === PixmapFormat.RGB565) Bitmap.Config.RGB_565 else if (formatv === PixmapFormat.ARGB4444) Bitmap.Config.ARGB_4444 else Bitmap.Config.ARGB_8888
        val options = BitmapFactory.Options()
        options.inPreferredConfig = config
        var `in`: InputStream? = null
        val bitmap: Bitmap?
        try {
            `in` = assets.open(fileName)
            bitmap = BitmapFactory.decodeStream(`in`)
            if (bitmap == null) throw RuntimeException(
                "No se ha podido cargar bitmap desde asset '"
                        + fileName + "'"
            )
        } catch (e: IOException) {
            throw RuntimeException(
                "No se ha podido cargar bitmap desde asset '"
                        + fileName + "'"
            )
        } finally {
            if (`in` != null) {
                try {
                    `in`.close()
                } catch (ignored: IOException) {
                }
            }
        }
        formatv =
            if (bitmap!!.config == Bitmap.Config.RGB_565) PixmapFormat.RGB565 else if (bitmap.config == Bitmap.Config.ARGB_4444) PixmapFormat.ARGB4444 else PixmapFormat.ARGB8888
        return AndroidPixmap(bitmap, formatv)
    }

    override fun clear(color: Int) {
        canvas.drawRGB(
            color and 0xff0000 shr 16, color and 0xff00 shr 8,
            color and 0xff
        )
    }

    override fun drawPixel(x: Int, y: Int, color: Int) {
        paint.color = color
        canvas.drawPoint(x.toFloat(), y.toFloat(), paint)
    }

    override fun drawLine(x: Int, y: Int, x2: Int, y2: Int, color: Int) {
        paint.color = color
        canvas.drawLine(x.toFloat(), y.toFloat(), x2.toFloat(), y2.toFloat(), paint)
    }

    override fun drawRect(x: Int, y: Int, width: Int, height: Int, color: Int) {
        paint.color = color
        paint.style = Paint.Style.FILL
        canvas.drawRect(
            x.toFloat(),
            y.toFloat(),
            (x + width - 1).toFloat(),
            (y + width - 1).toFloat(),
            paint
        )
    }

    override fun drawPixmap(
        pixmap: Pixmap, x: Int, y: Int, srcX: Int, srcY: Int,
        srcWidth: Int, srcHeight: Int
    ) {
        srcRect.left = srcX
        srcRect.top = srcY
        srcRect.right = srcX + srcWidth - 1
        srcRect.bottom = srcY + srcHeight - 1
        dstRect.left = x
        dstRect.top = y
        dstRect.right = x + srcWidth - 1
        dstRect.bottom = y + srcHeight - 1
        canvas.drawBitmap(
            (pixmap as AndroidPixmap?)!!.bitmap, srcRect, dstRect,
            null
        )
    }

    override fun drawPixmap(pixmap: Pixmap, x: Int, y: Int) {
        canvas.drawBitmap((pixmap as AndroidPixmap?)!!.bitmap, x.toFloat(), y.toFloat(), null)
    }

    override val width: Int
        get() = frameBuffer.width
    override val height: Int
        get() = frameBuffer.height
}