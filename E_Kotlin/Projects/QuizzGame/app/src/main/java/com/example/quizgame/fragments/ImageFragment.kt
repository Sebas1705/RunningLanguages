package com.example.quizgame.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageButton
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.example.quizgame.R
import com.example.quizgame.data.AppDatabase
import com.example.quizgame.quizgame.Game
import com.example.quizgame.data.entities.QImageEntity

class ImageFragment(
    private val questionImage: QImageEntity,
    private var activityParent: AppCompatActivity
) : Fragment() {

    //Components:
    private lateinit var questionText: TextView
    private lateinit var imageAnswerA: ImageButton
    private lateinit var imageAnswerB: ImageButton
    private lateinit var imageAnswerC: ImageButton
    private lateinit var imageAnswerD: ImageButton
    private var game = Game.getInstance(AppDatabase.getInstance(this.activityParent))

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        //Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_image_question, container, false)

        //Init with ids:
        questionText = view.findViewById(R.id.question_images)
        imageAnswerA = view.findViewById(R.id.answer_image_A)
        imageAnswerB = view.findViewById(R.id.answer_image_B)
        imageAnswerC = view.findViewById(R.id.answer_image_C)
        imageAnswerD = view.findViewById(R.id.answer_image_D)

        //Uses of components:
        questionText.text = questionImage.question
        imageAnswerA.setImageResource(questionImage.answers[0])
        imageAnswerA.setBackgroundColor(R.drawable.gradient_images)
        imageAnswerB.setImageResource(questionImage.answers[1])
        imageAnswerB.setBackgroundColor(R.drawable.gradient_images)
        imageAnswerC.setImageResource(questionImage.answers[2])
        imageAnswerC.setBackgroundColor(R.drawable.gradient_images)
        imageAnswerD.setImageResource(questionImage.answers[3])
        imageAnswerD.setBackgroundColor(R.drawable.gradient_images)
        imageAnswerA.setOnClickListener {
            game.replyQuestion(
                questionImage,
                0,
                activityParent
            )
        }
        imageAnswerB.setOnClickListener {
            game.replyQuestion(
                questionImage,
                1,
                activityParent
            )
        }
        imageAnswerC.setOnClickListener {
            game.replyQuestion(
                questionImage,
                2,
                activityParent
            )
        }
        imageAnswerD.setOnClickListener {
            game.replyQuestion(
                questionImage,
                3,
                activityParent
            )
        }

        return view
    }

}