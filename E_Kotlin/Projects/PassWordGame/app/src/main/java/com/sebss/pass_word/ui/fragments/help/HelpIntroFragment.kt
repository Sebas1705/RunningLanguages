package com.sebss.pass_word.ui.fragments.help

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.sebss.pass_word.R
import com.sebss.pass_word.databinding.FragmentHelpIntroBinding
import com.sebss.pass_word.domain.Game

class HelpIntroFragment : Fragment() {

    private var _binding: FragmentHelpIntroBinding? = null
    private val binding get() = _binding!!
    private val game = Game.getInstance(null)
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentHelpIntroBinding.inflate(inflater,container,false)

        binding.textIntro.text = getText(R.string.textIntroHelp)
        binding.textIntro2.text = getText(R.string.textIntro2Help)
        binding.nextHelp.setOnClickListener {
            if (container != null) game.soundPlayer.playSound(R.raw.button_sound,container.context)
            findNavController().navigate(R.id.action_helpIntroFragement_to_helpLogFragment)
        }

        return binding.root
    }
}