package com.sebss.pass_word.ui.activities

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.airbnb.lottie.LottieAnimationView
import com.sebss.pass_word.R
import com.sebss.pass_word.domain.Game
import kotlinx.coroutines.DelicateCoroutinesApi
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

@SuppressLint("CustomSplashScreen")
class SplashActivity : AppCompatActivity() {

    private lateinit var lottieCharge: LottieAnimationView

    @OptIn(DelicateCoroutinesApi::class)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)

        lottieCharge = findViewById(R.id.charge)
        lottieCharge.repeatCount = 100
        lottieCharge.playAnimation()
        lottieCharge.setBackgroundResource(R.drawable.transparent)

        //Init Database and game and let it time for coroutines with a delay
        GlobalScope.launch{
            val game = Game.getInstance(this@SplashActivity.applicationContext)
            game.loadLastPlayer()
            delay(3000)
            game.changeActivity(this@SplashActivity, MainMenuActivity::class.java,true)
            finish()
        }
    }
}