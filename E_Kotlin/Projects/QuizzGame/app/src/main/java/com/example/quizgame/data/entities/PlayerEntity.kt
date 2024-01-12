package com.example.quizgame.data.entities

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "players_table")
data class PlayerEntity(
    @PrimaryKey val name: String,
    var score: Int,
)