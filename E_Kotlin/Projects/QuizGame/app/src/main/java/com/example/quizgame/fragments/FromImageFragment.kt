package com.example.quizgame.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.RadioButton
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.AppCompatButton
import com.example.quizgame.R
import com.example.quizgame.data.AppDatabase
import com.example.quizgame.quizgame.Game
import com.example.quizgame.data.entities.QFromImageEntity

class FromImageFragment(
    private val fromImageQuestion: QFromImageEntity,
    private var activityParent: AppCompatActivity
) : Fragment() {

    //Components:
    private lateinit var questionText: TextView
    private lateinit var questionImage: ImageView
    private lateinit var radioAnswerA: RadioButton
    private lateinit var radioAnswerB: RadioButton
    private lateinit var radioAnswerC: RadioButton
    private lateinit var radioAnswerD: RadioButton
    private lateinit var nextAnswer: AppCompatButton
    private var game = Game.getInstance(AppDatabase.getInstance(this.activityParent))

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_from_image_question, container, false)

        //Init with ids:
        questionText = view.findViewById(R.id.question_text)
        questionImage = view.findViewById(R.id.image_question)
        radioAnswerA = view.findViewById(R.id.radio_answer_A_i)
        radioAnswerB = view.findViewById(R.id.radio_answer_B_i)
        radioAnswerC = view.findViewById(R.id.radio_answer_C_i)
        radioAnswerD = view.findViewById(R.id.radio_answer_D_i)
        nextAnswer = view.findViewById(R.id.next_question_i)

        //Uses of components:
        questionText.text = fromImageQuestion.question
        questionImage.setImageResource(fromImageQuestion.image!!)
        questionImage.setBackgroundColor(R.drawable.transparent_background)
        radioAnswerA.text = fromImageQuestion.answers[0]
        radioAnswerA.setBackgroundResource(R.drawable.radio_form)
        radioAnswerB.text = fromImageQuestion.answers[1]
        radioAnswerB.setBackgroundResource(R.drawable.radio_form)
        radioAnswerC.text = fromImageQuestion.answers[2]
        radioAnswerC.setBackgroundResource(R.drawable.radio_form)
        radioAnswerD.text = fromImageQuestion.answers[3]
        radioAnswerD.setBackgroundResource(R.drawable.radio_form)
        nextAnswer.setOnClickListener {
            if (radioAnswerA.isChecked) game.replyQuestion(
                fromImageQuestion,
                0,
                activityParent
            )
            else if (radioAnswerB.isChecked) game.replyQuestion(
                fromImageQuestion,
                1,
                activityParent
            )
            else if (radioAnswerC.isChecked) game.replyQuestion(
                fromImageQuestion,
                2,
                activityParent
            )
            else if (radioAnswerD.isChecked) game.replyQuestion(
                fromImageQuestion,
                3,
                activityParent
            )
            else Toast.makeText(context, "Seleccione opción!", Toast.LENGTH_SHORT).show()
        }

        return view
    }
}