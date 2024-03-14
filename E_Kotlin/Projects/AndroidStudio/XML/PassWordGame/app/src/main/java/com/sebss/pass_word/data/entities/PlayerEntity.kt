package com.sebss.pass_word.data.entities

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "players_table")
data class PlayerEntity(
    @PrimaryKey val name: String,
    var score: Int,
    var correctCount: Int,
    var incorrectCount: Int,
    var gamesCount: Int,
    var imageIcon: Int
)