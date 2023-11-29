package com.example.quizgame.quizgame

abstract class Question (
    open val question: String,
    open var image: Int?,
    open val correctAnswer: Int,
    open val type: String
)