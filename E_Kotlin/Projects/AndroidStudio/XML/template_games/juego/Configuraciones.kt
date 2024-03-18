package com.sebss.pass_word.juego

import com.sebss.pass_word.interfaces.FileIO
import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.IOException
import java.io.InputStreamReader
import java.io.OutputStreamWriter
import java.lang.Boolean
import kotlin.Int
import kotlin.NumberFormatException
import kotlin.intArrayOf

object Configuraciones {
    @JvmField
    var soundEnabled = true
    @JvmField
    var records = intArrayOf(100, 80, 50, 30, 10)
    @JvmStatic
    fun load(files: FileIO) {
        try {
            BufferedReader(
                InputStreamReader(
                    files.readFile(".policias")
                )
            ).use { `in` ->
                soundEnabled = Boolean.parseBoolean(`in`.readLine())
                for (i in 0..4) {
                    records[i] = `in`.readLine().toInt()
                }
            }
        } catch (e: IOException) {
            // :( Está bien aquí debería ir algo
        } catch (e: NumberFormatException) {
            // :/ Nadie es perfecto
        }
    }

    @JvmStatic
    fun save(files: FileIO) {
        try {
            BufferedWriter(
                OutputStreamWriter(
                    files.writeFile(".policias")
                )
            ).use { out ->
                out.write(Boolean.toString(soundEnabled))
                out.write("\n")
                for (i in 0..4) {
                    out.write(Integer.toString(records[i]))
                    out.write("\n")
                }
            }
        } catch (ignored: IOException) {
        }
    }

    @JvmStatic
    fun addScore(score: Int) {
        for (i in 0..4) {
            if (records[i] < score) {
                for (j in 4 downTo i + 1) records[j] = records[j - 1]
                records[i] = score
                break
            }
        }
    }

}