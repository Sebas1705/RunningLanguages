package com.sebss.pass_word.ui.activities

import android.annotation.SuppressLint
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.util.Log
import android.widget.RelativeLayout
import androidx.appcompat.app.AppCompatActivity
import com.airbnb.lottie.LottieAnimationView
import com.sebss.pass_word.R
import com.sebss.pass_word.domain.Game
import com.sebss.pass_word.databinding.ActivityGameBinding

class GameActivity : AppCompatActivity() {

    //Components:
    private lateinit var lettersLayout: List<RelativeLayout>
    private lateinit var binding: ActivityGameBinding
    private var game = Game.getInstance(null)

   
    @SuppressLint("SetTextI18n")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityGameBinding.inflate(layoutInflater)
        setContentView(binding.root)
        lettersLayout = game.getAllIdLetters(this)

        lettersLayout[0].setBackgroundResource(R.drawable.transparent)
        val letters = "abcdefghijklmnopqrstuvxyz"
        val preText = if (game.wordsGame[0].name.startsWith(
                letters[0],
                ignoreCase = true
            )
        ) "Empieza: " else "Contiene: "
        Log.d("Word: ", game.wordsGame[0].name)
        binding.questionText.text = "$preText${game.wordsGame[0].definitions.random()}"
        var helpUsed = false
        binding.gamebar.response.setOnClickListener {
            animate(binding.gamebar.response, R.raw.correct_incorrect, R.drawable.response) {
                val i = game.indexWord + 1
                val word = game.wordsGame[i]
                if (game.response(binding.editName.text.toString())) {
                    lettersLayout[i - 1].setBackgroundResource(R.drawable.back_correct_letter)
                    game.soundPlayer.playSound(R.raw.acierto, this)
                } else {
                    lettersLayout[i - 1].setBackgroundResource(R.drawable.back_incorrect_letter)
                    game.soundPlayer.playSound(R.raw.fallo, this)
                }
                if (game.finishGame()) {
                    game.saveActualData()
                    Game.changeActivity(this, MainMenuActivity::class.java, true)
                } else {
                    lettersLayout[game.indexWord].setBackgroundResource(R.drawable.transparent)
                    binding.questionText.text = (if (word.name.startsWith(
                            letters[i],
                            ignoreCase = true
                        )
                    ) "Empieza: " else "Contiene: ") + word.definitions.random()
                    Log.d("Word: ", game.wordsGame[i].name)
                    helpUsed=false
                }
            }
        }
        binding.gamebar.skip.setOnClickListener {
            animate(binding.gamebar.skip, R.raw.skip, R.drawable.skip) {
                if (game.finishGame()) {
                    game.saveActualData()
                    Game.changeActivity(this, MainMenuActivity::class.java, true)
                }else {
                    lettersLayout[game.indexWord].setBackgroundResource(R.drawable.back_letter)
                    game.indexWord++
                    lettersLayout[game.indexWord].setBackgroundResource(R.drawable.transparent)
                    binding.questionText.text = (if (game.wordsGame[game.indexWord].name.startsWith(
                            letters[game.indexWord],
                            ignoreCase = true
                        )
                    ) "Empieza: " else "Contiene: ") + game.wordsGame[game.indexWord].definitions.random()
                    Log.d("Word: ", game.wordsGame[game.indexWord].name)
                    helpUsed = false
                    game.soundPlayer.playSound(R.raw.button_sound, this)
                }
            }
        }
        binding.gamebar.help.setOnClickListener {
            animate(binding.gamebar.help, R.raw.help, R.drawable.help) {
                if(helpUsed){
                    game.soundPlayer.playSound(R.raw.fallo,this)
                }else{
                    binding.questionText.text = (if (game.wordsGame[game.indexWord].name.startsWith(
                            letters[game.indexWord],
                            ignoreCase = true
                        )
                    ) "Empieza: " else "Contiene: ") + game.wordsGame[game.indexWord].definitions.random()
                    helpUsed=true
                }
            }
        }
        binding.toolbar.helpTool.setOnClickListener {
            game.soundPlayer.playSound(R.raw.button_sound, this)
            Game.changeActivity(this,HelpActivity::class.java,true)
        }
        binding.toolbar.homeTool.setOnClickListener {
            game.soundPlayer.playSound(R.raw.button_sound, this)
            Game.changeActivity(this, MainMenuActivity::class.java, true)
        }

    }

    private fun animate(
        lottie: LottieAnimationView,
        animation: Int,
        image: Int,
        more: () -> Unit = {}
    ) {
        lottie.setAnimation(animation)
        lottie.playAnimation()
        val handler = Handler(Looper.getMainLooper())
        handler.postDelayed({
            lottie.setImageResource(image)
            more()
        }, 1000)

    }
}