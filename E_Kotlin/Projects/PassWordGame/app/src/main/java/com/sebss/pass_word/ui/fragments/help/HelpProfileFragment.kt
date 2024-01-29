package com.sebss.pass_word.ui.fragments.help

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.sebss.pass_word.R
import com.sebss.pass_word.databinding.FragmentHelpProfileBinding
import com.sebss.pass_word.domain.Game

class HelpProfileFragment : Fragment() {
    private var _binding: FragmentHelpProfileBinding? = null
    private val binding get() = _binding!!
    private val game = Game.getInstance(null)
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentHelpProfileBinding.inflate(inflater,container,false)

        binding.textProfile.text = getText(R.string.textProfileHelp)
        binding.nextHelp.setOnClickListener {
            if (container != null) game.soundPlayer.playSound(R.raw.button_sound,container.context)
            findNavController().navigate(R.id.action_helpProfileFragment_to_helpGameFragment)
        }

        return binding.root
    }
}