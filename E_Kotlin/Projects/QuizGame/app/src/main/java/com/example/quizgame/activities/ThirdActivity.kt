package com.example.quizgame.activities


import android.media.MediaPlayer
import android.os.Bundle
import android.widget.Button
import android.widget.ImageButton
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import com.airbnb.lottie.LottieAnimationView
import com.example.quizgame.quizgame.Game
import com.example.quizgame.R
import com.example.quizgame.data.AppDatabase
import com.example.quizgame.quizgame.Categories



class ThirdActivity : AppCompatActivity() {

    //Components:
    private lateinit var helpbutton: ImageButton
    private lateinit var toolbar: Toolbar
    private lateinit var goToMainActivity: Button
    private lateinit var playAgain: Button
    private lateinit var textView: TextView
    private lateinit var finalScore: TextView
    private lateinit var lottieAnimationView: LottieAnimationView
    private var mediaPlayer: MediaPlayer? = null
    private var game = Game.getInstance(AppDatabase.getInstance(this))

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_third)

        //Init with ids:
        lottieAnimationView = findViewById(R.id.star)
        finalScore = findViewById(R.id.finalScoreView)
        playAgain = findViewById(R.id.playAgain)
        textView = findViewById(R.id.textView)
        toolbar = findViewById(R.id.toolbar)
        helpbutton = findViewById(R.id.help_button)
        goToMainActivity = findViewById(R.id.goToMainActivity)

        //Uses of components:
        setSupportActionBar(toolbar)
        lottieAnimationView.setBackgroundResource(R.drawable.transparent_background)
        finalScore.text = getString(R.string.Final_Score, game.getScore().toString())
        helpbutton.setOnClickListener { game.changeActivity(this,HelpActivity::class.java,true) }
        if (game.getCategory()==Categories.SURVIVAL) {
            if (game.getScore() >= 216) {
                textView.text = getString(R.string.Perfect_comment)
                lottieAnimationView.setAnimation("clear.json")
            }
            else if (game.getScore() in 150..215) {
                textView.text = getString(R.string.Great_comment)
                lottieAnimationView.setAnimation("star.json")
            }
            else if (game.getScore() in -10..149)  {
                textView.text = getString(R.string.NiceTry_comment)
                lottieAnimationView.setAnimation("fireworks.json")
            }
        }else{
            if (game.getScore() == 15) {
                textView.text = getString(R.string.Perfect_comment)
                lottieAnimationView.setAnimation("clear.json")
            }
            else if (game.getScore() in 7..14) {
                textView.text = getString(R.string.Great_comment)
                lottieAnimationView.setAnimation("star.json")
            }
            else if (game.getScore() in -10..6) {
                textView.text = getString(R.string.NiceTry_comment)
                lottieAnimationView.setAnimation("fireworks.json")
            }
        }
        goToMainActivity.setOnClickListener {
            playSound()
            game.changeActivity(this,MainActivity::class.java,true)
        }
        playAgain.setOnClickListener {
            playSound()
            game.resetScore()
            game.generateQuestions()
            game.changeActivity(this,SecondActivity::class.java,true)
        }
    }
    override fun onDestroy() {
        //Free resources
        mediaPlayer?.release()
        super.onDestroy()
    }

    //Private methods:
    private fun playSound() {
        //Free resources
        mediaPlayer?.release()
        //Create new player with music
        mediaPlayer = MediaPlayer.create(this, R.raw.mario)
        //Start player
        mediaPlayer?.start()
    }
}
