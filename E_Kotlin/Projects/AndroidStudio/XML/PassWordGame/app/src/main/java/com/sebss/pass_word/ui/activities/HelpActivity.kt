package com.sebss.pass_word.ui.activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.sebss.pass_word.R
import com.sebss.pass_word.databinding.ActivityHelpBinding
import com.sebss.pass_word.domain.Game

class HelpActivity : AppCompatActivity() {

    private lateinit var binding: ActivityHelpBinding
    private lateinit var  game: Game
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityHelpBinding.inflate(layoutInflater)
        setContentView(binding.root)
        game = Game.getInstance(this)

        binding.toolbar.helpTool.setOnClickListener {
            game.soundPlayer.playSound(R.raw.button_sound, this)
            game.changeActivity(this,HelpActivity::class.java,true)
        }
        binding.toolbar.homeTool.setOnClickListener {
            game.soundPlayer.playSound(R.raw.button_sound, this)
            game.changeActivity(this, MainMenuActivity::class.java, true)
        }
    }
}