package com.sebss.pass_word.data.entities

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "words_table")
data class WordEntity(
    @PrimaryKey val name: String,
    var definitions: List<String>
)