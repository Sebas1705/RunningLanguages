package com.example.quizgame.activities

import android.os.Bundle
import android.widget.ImageButton
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import com.example.quizgame.quizgame.Game
import com.example.quizgame.R
import com.example.quizgame.data.AppDatabase

class SecondActivity : AppCompatActivity() {

    //Components:
    private lateinit var toolbar: Toolbar
    private lateinit var pointText: TextView
    private lateinit var helpbutton: ImageButton
    private val game = Game.getInstance(AppDatabase.getInstance(this))

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_second)

        //Init with ids:
        toolbar = findViewById(R.id.toolbar)
        pointText = findViewById(R.id.point_text)
        helpbutton = findViewById(R.id.help_button)

        //Uses of components:
        pointText.text = getString(R.string.points_bargame,"0")
        setSupportActionBar(toolbar)
        game.updateHeartLayout(this)
        helpbutton.setOnClickListener { game.changeActivity(this,HelpActivity::class.java,true) }

        //Init first question fragment:
        val fragment = game.generateRandomQuestionFragment(this)
        supportFragmentManager.beginTransaction().add(R.id.containerQuestions,fragment).commit()
    }
    override fun onStart() {
        super.onStart()
        game.startBackgroundMusic(this)
    }
    override fun onStop() {
        super.onStop()
        game.stopBackgroundMusic()
    }
}