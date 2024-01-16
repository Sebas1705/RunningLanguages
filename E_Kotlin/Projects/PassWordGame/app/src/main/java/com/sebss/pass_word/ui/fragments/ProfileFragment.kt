package com.sebss.pass_word.ui.fragments

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import com.sebss.pass_word.R
import com.sebss.pass_word.R.*
import com.sebss.pass_word.ui.activities.MainMenuActivity
import com.sebss.pass_word.domain.Game
import com.sebss.pass_word.databinding.FragmentProfileFragmentsBinding

class ProfileFragment(private val parent: AppCompatActivity) : Fragment() {

    //Components:
    private var _binding: FragmentProfileFragmentsBinding? = null
    private val binding get() = _binding!!
    private lateinit var game: Game


    @SuppressLint("SetTextI18n")
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentProfileFragmentsBinding.inflate(inflater,container,false)
        game = Game.getInstance(null)

        binding.right.setOnClickListener {
            game.soundPlayer.playSound(raw.button_sound,parent)
            binding.icon.setImageResource(game.changeIcon(true))
            game.updatePlayer()
        }
        binding.left.setOnClickListener {
            game.soundPlayer.playSound(raw.button_sound,parent)
            binding.icon.setImageResource(game.changeIcon(false))
            game.updatePlayer()
        }
        binding.deletePlayer.setOnClickListener{
            game.soundPlayer.playSound(R.raw.button_sound,parent)
            game.deletePlayer(game.player!!)
            game.logoutPlayer()
            Game.changeActivity(parent, MainMenuActivity::class.java,true)
        }
        binding.icon.setImageResource(game.player!!.imageIcon)
        binding.name.text = game.player!!.name
        binding.scoreText.text = "Puntuación: "+game.player!!.score
        binding.correctText.text = "Palabras correctas: "+game.player!!.correctCount
        binding.incorrectText.text = "Palabras incorrectas: "+game.player!!.incorrectCount
        binding.numGamesText.text = "Número de partidas: "+game.player!!.gamesCount

        return binding.root
    }

}