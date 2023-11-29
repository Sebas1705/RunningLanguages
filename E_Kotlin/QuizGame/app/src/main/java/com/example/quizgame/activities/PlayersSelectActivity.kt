package com.example.quizgame.activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.EditText
import android.widget.ImageButton
import android.widget.TextView
import androidx.appcompat.widget.Toolbar
import com.example.quizgame.R
import com.example.quizgame.data.AppDatabase
import com.example.quizgame.data.entities.PlayerEntity
import com.example.quizgame.quizgame.Game

class PlayersSelectActivity : AppCompatActivity() {

    //Components:
    private lateinit var toolbar: Toolbar
    private lateinit var helpbutton: ImageButton
    private lateinit var searchbutton: ImageButton
    private lateinit var startbutton: ImageButton
    private lateinit var addbutton: ImageButton
    private lateinit var deletebutton: ImageButton
    private lateinit var editname: EditText
    private lateinit var infotext: TextView
    private var game:Game = Game.getInstance(AppDatabase.getInstance(this))
    private var actualPlayer: PlayerEntity? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_players_select)

        //Init with ids:
        toolbar = findViewById(R.id.toolbar)
        helpbutton = findViewById(R.id.help_button)
        searchbutton = findViewById(R.id.search_button)
        startbutton = findViewById(R.id.start_button)
        addbutton = findViewById(R.id.add_button)
        deletebutton = findViewById(R.id.delete_button)
        editname = findViewById(R.id.edit_name)
        infotext = findViewById(R.id.info_text)

        //Uses of components:
        setSupportActionBar(toolbar)
        editname.setBackgroundResource(R.drawable.transparent_background)
        infotext.setBackgroundResource(R.drawable.transparent_background)
        helpbutton.setOnClickListener { game.changeActivity(this,HelpActivity::class.java,false) }
        searchbutton.setOnClickListener {
            if(editname.text.toString() != "") {
                actualPlayer = game.searchPlayer(editname.text.toString())
                if(actualPlayer == null) infotext.text = getString(R.string.titleInfo_sp)
                else infotext.text = getString(R.string.player_found)
            }else infotext.text = getString(R.string.not_null_name)
        }
        startbutton.setOnClickListener {
            if(actualPlayer==null)
                if(editname.text.toString()=="") infotext.text = getString(R.string.not_null_name)
                else {
                    actualPlayer = game.searchPlayer(editname.text.toString())
                    if(actualPlayer == null) infotext.text = getString(R.string.titleInfo_sp)
                    else {
                        game.logInPlayer(actualPlayer!!)
                        game.changeActivity(this,MainActivity::class.java,false)
                    }
                }
            else{
                game.logInPlayer(actualPlayer!!)
                game.changeActivity(this,MainActivity::class.java,false)
            }
        }
        addbutton.setOnClickListener {
            if(editname.text.toString() != "") {
                val player = game.searchPlayer(editname.text.toString())
                if (player == null) {
                    val newPlayer = PlayerEntity(editname.text.toString(), 0)
                    game.addPlayer(newPlayer)
                    infotext.text = getString(R.string.player_create)
                    actualPlayer = newPlayer
                } else infotext.text = getString(R.string.player_exist_delete_or_init)
            }else infotext.text = getString(R.string.not_null_name)
        }
        deletebutton.setOnClickListener {
            if(editname.text.toString() != "") {
                val player = game.searchPlayer(editname.text.toString())
                if (player != null) {
                    game.deletePlayer(player)
                    infotext.text = getString(R.string.player_delete)
                    actualPlayer = null
                } else infotext.text = getString(R.string.titleInfo_sp)
            }else infotext.text = getString(R.string.not_null_name)
        }
    }
}