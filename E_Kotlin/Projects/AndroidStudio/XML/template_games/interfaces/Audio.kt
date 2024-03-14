package com.sebss.pass_word.interfaces

interface Audio {
    fun newMusic(fileName: String): Music
    fun newSound(fileName: String): Sound
}