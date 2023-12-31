package com.sebss.a3dgraphicsmotor.interfaces

import java.io.IOException
import java.io.InputStream
import java.io.OutputStream

interface FileIO {
    @Throws(IOException::class)
    fun readAsset(fileName: String): InputStream

    @Throws(IOException::class)
    fun readFile(fileName: String): InputStream?

    @Throws(IOException::class)
    fun writeFile(fileName: String): OutputStream
}