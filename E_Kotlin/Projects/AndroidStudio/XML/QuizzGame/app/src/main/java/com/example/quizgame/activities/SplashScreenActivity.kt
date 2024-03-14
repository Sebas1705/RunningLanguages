package com.example.quizgame.activities

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.airbnb.lottie.LottieAnimationView
import com.example.quizgame.R
import com.example.quizgame.data.AppDatabase
import com.example.quizgame.quizgame.Game
import kotlinx.coroutines.DelicateCoroutinesApi
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

@SuppressLint("CustomSplashScreen")
class SplashScreenActivity : AppCompatActivity() {

    //Components:
    private lateinit var database: AppDatabase
    private lateinit var game: Game
    private lateinit var animation: LottieAnimationView

    @OptIn(DelicateCoroutinesApi::class)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.splash_screen)

        //Init with ids:
        animation = findViewById(R.id.animation)
        animation.setAnimation("load.json")
        animation.setBackgroundResource(R.drawable.transparent_background)

        //Init Database and game and let it time for coroutines with a delay
        GlobalScope.launch {
            initDatabase()
            game = Game.getInstance(database)
            delay(3000)
            startGame()
        }
    }

    //Private methods:
    private fun initDatabase(){
        database = AppDatabase.getInstance(this)
    }
    private fun startGame() {
        game.changeActivity(this,PlayersSelectActivity::class.java,true,androidx.appcompat.R.anim.abc_slide_in_top,android.R.anim.overshoot_interpolator)
    }
}