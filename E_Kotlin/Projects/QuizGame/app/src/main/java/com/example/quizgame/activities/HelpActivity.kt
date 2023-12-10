package com.example.quizgame.activities


import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageButton
import androidx.appcompat.widget.Toolbar
import com.example.quizgame.R

class HelpActivity : AppCompatActivity() {

    //Components:
    private lateinit var helpbutton: ImageButton
    private lateinit var toolbar: Toolbar
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_help)

        //Init with ids:
        helpbutton = findViewById(R.id.help_button)
        toolbar = findViewById(R.id.toolbar)

        //Uses of components:
        setSupportActionBar(toolbar)
        helpbutton.setImageResource(R.drawable.leftarrow)
        helpbutton.setOnClickListener { finish() }
    }
}