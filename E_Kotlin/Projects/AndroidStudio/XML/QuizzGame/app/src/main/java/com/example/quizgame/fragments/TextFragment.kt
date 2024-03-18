package com.example.quizgame.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.RadioButton
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.AppCompatButton
import com.example.quizgame.R
import com.example.quizgame.data.AppDatabase
import com.example.quizgame.quizgame.Game
import com.example.quizgame.data.entities.QTextEntity

class TextFragment(
    private var questionText: QTextEntity,
    private var activityParent: AppCompatActivity
) : Fragment() {

    //Components:
    private lateinit var questiontext: TextView
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
        //Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_text_question, container, false)

        //Init with ids:
        questiontext = view.findViewById(R.id.question_text)
        radioAnswerA = view.findViewById(R.id.radio_answer_A)
        radioAnswerA.setBackgroundResource(R.drawable.radio_form)
        radioAnswerB = view.findViewById(R.id.radio_answer_B)
        radioAnswerB.setBackgroundResource(R.drawable.radio_form)
        radioAnswerC = view.findViewById(R.id.radio_answer_C)
        radioAnswerC.setBackgroundResource(R.drawable.radio_form)
        radioAnswerD = view.findViewById(R.id.radio_answer_D)
        radioAnswerD.setBackgroundResource(R.drawable.radio_form)
        nextAnswer = view.findViewById(R.id.next_question_t)

        //Uses of components:
        questiontext.text = questionText.question
        radioAnswerA.text = questionText.answers[0]
        radioAnswerB.text = questionText.answers[1]
        radioAnswerC.text = questionText.answers[2]
        radioAnswerD.text = questionText.answers[3]
        nextAnswer.setOnClickListener {
            if (radioAnswerA.isChecked) game.replyQuestion(
                questionText,
                0,
                activityParent
            )
            else if (radioAnswerB.isChecked) game.replyQuestion(
                questionText,
                1,
                activityParent
            )
            else if (radioAnswerC.isChecked) game.replyQuestion(
                questionText,
                2,
                activityParent
            )
            else if (radioAnswerD.isChecked) game.replyQuestion(
                questionText,
                3,
                activityParent
            )
            else Toast.makeText(context, "Seleccione opción!", Toast.LENGTH_SHORT).show()
        }

        return view
    }
}