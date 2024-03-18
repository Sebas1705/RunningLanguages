package com.sebss.pass_word.ui.fragments.help

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.sebss.pass_word.R
import com.sebss.pass_word.databinding.FragmentHelpLogBinding
import com.sebss.pass_word.domain.Game

class HelpLogFragment : Fragment() {

    private var _binding: FragmentHelpLogBinding? = null
    private val binding get() = _binding!!
    private val game = Game.getInstance(null)
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentHelpLogBinding.inflate(inflater,container,false)

        binding.textLog.text = getText(R.string.textLogHelp)
        binding.nextHelp.setOnClickListener {
            if (container != null) game.soundPlayer.playSound(R.raw.button_sound,container.context)
            findNavController().navigate(R.id.action_helpLogFragment_to_helpWordFragment)
        }

        return binding.root
    }

}