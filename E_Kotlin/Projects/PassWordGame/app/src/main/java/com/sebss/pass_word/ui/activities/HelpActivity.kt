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
        game = Game.getInstance(null)

        binding.textIntro.text = getText(R.string.textIntroHelp)
        binding.textIntro2.text = getText(R.string.textIntro2Help)
        binding.textLog.text = getText(R.string.textLogHelp)
        binding.textWord.text = getText(R.string.textWordHelp)
        binding.textWord2.text = getText(R.string.textWord2Help)
        binding.textGame.text = getText(R.string.textGameHelp)
        binding.textGame2.text = getText(R.string.textGame2Help)
        binding.textGame3.text = getText(R.string.textGame3Help)

        binding.toolbar.helpTool.setOnClickListener {
            game.soundPlayer.playSound(R.raw.button_sound, this)
            Game.changeActivity(this,HelpActivity::class.java,true)
        }
        binding.toolbar.homeTool.setOnClickListener {
            game.soundPlayer.playSound(R.raw.button_sound, this)
            Game.changeActivity(this, MainMenuActivity::class.java, true)
        }
    }
}