package com.sebss.a3dgraphicsmotor.interfaces

interface Audio {
    fun newMusic(fileName: String): Music
    fun newSound(fileName: String): Sound
}