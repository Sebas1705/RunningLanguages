package com.sebss.pass_word.androidimpl

import android.content.res.AssetManager
import android.os.Environment
import com.sebss.pass_word.interfaces.FileIO
import java.io.File
import java.io.IOException
import java.io.InputStream
import java.io.OutputStream
import java.nio.file.Files
import java.nio.file.Paths

class AndroidFileIO(var assets: AssetManager) : FileIO {
    private var externalStoragePath: String = (Environment
        .getExternalStorageDirectory().absolutePath
            + File.separator)

    @Throws(IOException::class)
    override fun readAsset(fileName: String): InputStream {
        return assets.open(fileName)
    }

    @Throws(IOException::class)
    override fun readFile(fileName: String): InputStream {
        return Files.newInputStream(Paths.get(externalStoragePath + fileName))
    }

    @Throws(IOException::class)
    override fun writeFile(fileName: String): OutputStream {
        return Files.newOutputStream(Paths.get(externalStoragePath + fileName))
    }
}