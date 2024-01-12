package com.example.quizgame.data.entities

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.example.quizgame.quizgame.Question

@Entity(tableName = "qImage_table")
data class QImageEntity (
    @PrimaryKey override val question: String,
    override val correctAnswer: Int,
    val answers: List<Int>,
    override val type: String
) : Question(question = question, image = null, correctAnswer = correctAnswer, type = type)
