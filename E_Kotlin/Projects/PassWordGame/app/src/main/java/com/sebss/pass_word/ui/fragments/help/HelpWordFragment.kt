package com.sebss.pass_word.ui.fragments.help

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.sebss.pass_word.R
import com.sebss.pass_word.databinding.FragmentHelpWordBinding
import com.sebss.pass_word.domain.Game

class HelpWordFragment : Fragment() {

    private var _binding: FragmentHelpWordBinding? = null
    private val binding get() = _binding!!
    private val game = Game.getInstance(null)
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentHelpWordBinding.inflate(inflater,container,false)

        binding.textWord.text = getText(R.string.textWordHelp)
        binding.textWord2.text = getText(R.string.textWord2Help)
        binding.nextHelp.setOnClickListener {
            if (container != null) game.soundPlayer.playSound(R.raw.button_sound,container.context)
            findNavController().navigate(R.id.action_helpWordFragment_to_helpProfileFragment)
        }

        return binding.root
    }

}