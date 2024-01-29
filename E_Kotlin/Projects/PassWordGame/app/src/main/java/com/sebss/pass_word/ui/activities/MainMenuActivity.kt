package com.sebss.pass_word.ui.activities

import android.annotation.SuppressLint
import android.os.Bundle
import android.widget.EditText
import android.widget.ImageButton
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.sebss.pass_word.domain.Game
import com.sebss.pass_word.R
import com.sebss.pass_word.data.entities.PlayerEntity
import com.sebss.pass_word.databinding.ActivityMainmenuBinding
import com.sebss.pass_word.databinding.GamePopupBinding
import com.sebss.pass_word.ui.adapters.PlayerAdapter
import com.sebss.pass_word.ui.fragments.data.DataProfileFragment
import com.sebss.pass_word.ui.fragments.data.DataWordFragment

@SuppressLint("SetTextI18n")
class MainMenuActivity : AppCompatActivity() {

    //Components:
    private lateinit var binding: ActivityMainmenuBinding
    private lateinit var game: Game

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainmenuBinding.inflate(layoutInflater)
        setContentView(binding.root)


        game = Game.getInstance(this)

        binding.loginText.text = if (game.player == null) "Iniciar" else "Cambiar"
        binding.ranking.apply{
            layoutManager = LinearLayoutManager(this@MainMenuActivity)
            adapter = PlayerAdapter(game.getAllPlayers())
        }
        binding.login.setOnClickListener {
            game.soundPlayer.playSound(R.raw.button_sound, this)
            showLogInPopUp()
        }
        binding.play.setOnClickListener {
            game.soundPlayer.playSound(R.raw.button_sound, this)
            showGamePopUp()
        }
        binding.words.setOnClickListener {
            changeWithLog(
                DataActivity::class.java,
                DataWordFragment(this)
            )
        }
        binding.perfil.setOnClickListener {
            changeWithLog(
                DataActivity::class.java,
                DataProfileFragment(this)
            )
        }
        binding.toolbar.helpTool.setOnClickListener {
            game.soundPlayer.playSound(R.raw.button_sound, this)
            game.changeActivity(this,HelpActivity::class.java,true)
        }
        binding.toolbar.homeTool.setOnClickListener {
            game.soundPlayer.playSound(R.raw.button_sound, this)
            game.changeActivity(this, MainMenuActivity::class.java, true)
        }
    }

    private fun <T : AppCompatActivity> changeWithLog(
        activity: Class<out T>,
        dataFragment: Fragment?
    ) {
        if (game.player != null) {
            game.soundPlayer.playSound(R.raw.button_sound, this)
            game.changeActivity(this, activity, true)
            game.dataFragment = dataFragment
        } else {
            game.soundPlayer.playSound(R.raw.fallo, this)
            Toast.makeText(this, "Inicia sesión primero!", Toast.LENGTH_SHORT).show()
        }
    }

    private fun showLogInPopUp() {

        // Create popup
        val popUpView = layoutInflater.inflate(R.layout.login_popup, null)
        val cancelImageButton: ImageButton = popUpView.findViewById(R.id.cancelButton)
        val loginImageButton: ImageButton = popUpView.findViewById(R.id.logButton)
        val createImageButton: ImageButton = popUpView.findViewById(R.id.createButton)
        val textMsg: TextView = popUpView.findViewById(R.id.textMsg)
        val editName: EditText = popUpView.findViewById(R.id.edit_name)
        val popUp = AlertDialog.Builder(this).setView(popUpView).create()

        cancelImageButton.setOnClickListener {
            game.soundPlayer.playSound(R.raw.button_sound, this)
            popUp.dismiss()
        }
        loginImageButton.setOnClickListener {
            game.soundPlayer.playSound(R.raw.button_sound, this)
            if (editName.text.toString() != "") {
                val player = game.searchPlayer(editName.text.toString())
                if (player != null) {
                    textMsg.text = "Bienvenido " + player.name
                    game.loginPlayer(player)
                    binding.loginText.text = "Cambiar"
                    binding.ranking.adapter = PlayerAdapter(game.getAllPlayers())
                    game.soundPlayer.playSound(R.raw.acierto, this)
                    popUp.dismiss()
                } else {
                    textMsg.text = "Usuario no encontrado"
                    game.soundPlayer.playSound(R.raw.fallo, this)
                }
            } else {
                textMsg.text = "Nombre vacío no válido"
                game.soundPlayer.playSound(R.raw.fallo, this)
            }


        }
        createImageButton.setOnClickListener {
            game.soundPlayer.playSound(R.raw.button_sound, this)
            if (editName.text.toString() != "") {
                val player = game.searchPlayer(editName.text.toString())
                if (player != null) {
                    textMsg.text = "Usuario ya existe"
                    game.soundPlayer.playSound(R.raw.fallo, this)
                } else {
                    game.addPlayer(
                        PlayerEntity(
                            editName.text.toString(),
                            0,
                            0,
                            0,
                            0,
                            R.drawable.user0
                        )
                    )
                    textMsg.text = "Usuario creado con exito!"
                    game.soundPlayer.playSound(R.raw.acierto, this)
                }
            } else {
                textMsg.text = "Nombre vacío no válido"
                game.soundPlayer.playSound(R.raw.fallo, this)
            }
        }
        // Show popup
        popUp.show()
    }

    private fun showGamePopUp() {

        // Create popup
        val popUpBinding = GamePopupBinding.inflate(layoutInflater)
        val popUp = AlertDialog.Builder(this).setView(popUpBinding.root).create()

        popUpBinding.cancelButton.setOnClickListener { popUp.dismiss() }
        popUpBinding.confirmButton.setOnClickListener {
            if (game.player != null) {
                game.soundPlayer.playSound(R.raw.button_sound, this)
                when (popUpBinding.modeRadio.checkedRadioButtonId) {
                    R.id.start_option -> {
                        game.generateWordsGame { word, letter ->
                            Game.removeAccents(word.name).startsWith(letter, ignoreCase = true)
                        }
                    }

                    else -> {
                        game.generateWordsGame { word, letter ->
                            Game.removeAccents(word.name).contains(letter, ignoreCase = true)
                        }
                    }
                }
                game.changeActivity(this, GameActivity::class.java, true)
                popUp.dismiss()
            } else {
                game.soundPlayer.playSound(R.raw.fallo, this)
                Toast.makeText(this, "Inicia sesión primero!", Toast.LENGTH_SHORT).show()
            }
        }
        popUp.show()
    }
}