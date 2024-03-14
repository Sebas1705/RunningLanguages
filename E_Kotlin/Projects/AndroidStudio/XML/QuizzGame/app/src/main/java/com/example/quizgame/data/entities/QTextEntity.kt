package com.example.quizgame.data.entities

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.example.quizgame.quizgame.Question

@Entity(tableName = "qText_table")
data class QTextEntity (
    @PrimaryKey override val question: String,
    override val correctAnswer: Int,
    val answers: List<String>,
    override val type: String,
) : Question(question = question, image = null, correctAnswer = correctAnswer, type = type)
