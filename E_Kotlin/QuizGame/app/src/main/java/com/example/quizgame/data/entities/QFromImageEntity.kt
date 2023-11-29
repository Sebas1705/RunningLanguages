package com.example.quizgame.data.entities

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.example.quizgame.quizgame.Question

@Entity(tableName = "qFromImage_table")
data class QFromImageEntity (
    @PrimaryKey override val question: String,
    override var image: Int?,
    override val correctAnswer: Int,
    val answers: List<String>,
    override val type: String,
) : Question(question = question, image = image, correctAnswer = correctAnswer,type = type)