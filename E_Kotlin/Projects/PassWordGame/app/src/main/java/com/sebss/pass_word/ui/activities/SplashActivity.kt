package com.sebss.pass_word.ui.activities

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.airbnb.lottie.LottieAnimationView
import com.sebss.pass_word.R
import com.sebss.pass_word.data.entities.PlayerEntity
import com.sebss.pass_word.domain.Game
import kotlinx.coroutines.DelicateCoroutinesApi
import kotlinx.coroutines.GlobalScope
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

        //Init Database and game and let it time for coroutines with a delay
        GlobalScope.launch {
            val game = Game.getInstance(this@SplashActivity.applicationContext)
            game.addPlayer(PlayerEntity("Sebas",100,100,0,100,R.drawable.user1))
            game.addPlayer(PlayerEntity("Sebss",100,100,0,100,R.drawable.user1))
            game.addPlayer(PlayerEntity("Ssbas",100,100,0,100,R.drawable.user1))
            game.loadLastPlayer()
            Game.changeActivity(this@SplashActivity, MainMenuActivity::class.java,true)
        }
        finish()
    }
}