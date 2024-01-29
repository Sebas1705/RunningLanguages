package com.sebss.pass_word.ui.activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.sebss.pass_word.R
import com.sebss.pass_word.domain.Game
import com.sebss.pass_word.databinding.ActivityDataBinding

class DataActivity : AppCompatActivity() {

    //Components:
    private lateinit var game: Game
    private lateinit var binding: ActivityDataBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDataBinding.inflate(layoutInflater)
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

        supportFragmentManager.beginTransaction().add(R.id.containerFrames, game.dataFragment!!).commit()
    }

}