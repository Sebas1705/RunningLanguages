package com.example.quizgame.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import com.example.quizgame.R

class ErrorFragment(private val errorText : String) : Fragment() {

    //Components:
    private lateinit var text: TextView

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_error, container, false)

        //Init with ids:
        text = view.findViewById(R.id.error_text)

        //Uses of components:
        text.text = errorText

        return view
    }

}