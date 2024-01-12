package com.sebss.pass_word.ui.activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageButton
import com.sebss.pass_word.R
import com.sebss.pass_word.data.AppDatabase
import com.sebss.pass_word.Game
import com.sebss.pass_word.databinding.ActivityDataBinding

class DataActivity : AppCompatActivity() {

    //Components:
    private lateinit var game: Game
    private lateinit var binding: ActivityDataBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDataBinding.inflate(layoutInflater)
        setContentView(binding.root)

        game = Game.getInstance(null)

        binding.toolbar.helpTool.setOnClickListener {
            //Game.changeActivity(this,HelpActivity::class.java,true)
        }
        binding.toolbar.homeTool.setOnClickListener {
            Game.changeActivity(this,MainMenuActivity::class.java,true)
        }

        supportFragmentManager.beginTransaction().add(R.id.containerFrames, game.dataFragment!!).commit()
    }

}