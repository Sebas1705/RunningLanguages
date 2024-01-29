package com.sebss.pass_word.ui.fragments.help

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.sebss.pass_word.R
import com.sebss.pass_word.databinding.FragmentHelpGameBinding
import com.sebss.pass_word.domain.Game

class HelpGameFragment : Fragment() {

    private var _binding: FragmentHelpGameBinding? = null
    private val binding get() = _binding!!
    private val game = Game.getInstance(null)
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentHelpGameBinding.inflate(inflater,container,false)

        binding.textGame.text = getText(R.string.textGameHelp)
        binding.textGame2.text = getText(R.string.textGame2Help)
        binding.textGame3.text = getText(R.string.textGame3Help)
        binding.nextHelp.setOnClickListener {
            if (container != null) game.soundPlayer.playSound(R.raw.button_sound,container.context)
            findNavController().navigate(R.id.action_helpGameFragment_to_helpIntroFragement)
        }

        return binding.root
    }
}