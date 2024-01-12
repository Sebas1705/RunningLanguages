package com.sebss.pass_word.ui.fragments

import android.annotation.SuppressLint
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.EditText
import android.widget.ImageButton
import android.widget.TextView
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.AppCompatButton
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.airbnb.lottie.LottieAnimationView
import com.sebss.pass_word.R
import com.sebss.pass_word.data.AppDatabase
import com.sebss.pass_word.data.entities.WordEntity
import com.sebss.pass_word.Game
import com.sebss.pass_word.databinding.FragmentProfileFragmentsBinding
import com.sebss.pass_word.databinding.FragmentWordsFragmentsBinding
import com.sebss.pass_word.ui.adapters.WordsAdapter

class WordsFragment(private val parent: AppCompatActivity) : Fragment() {

    //Components:
    private lateinit var listDefsEdits: List<EditText>
    private var _binding: FragmentWordsFragmentsBinding? = null
    private val binding get() = _binding!!
    private lateinit var game: Game
    @SuppressLint("SetTextI18n")
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentWordsFragmentsBinding.inflate(inflater, container, false)
        game = Game.getInstance(null)

        binding.wordbar.search.setOnClickListener {
            val word = game.searchWord(binding.name.text.toString())
            if (word != null) {
                binding.logText.text = "Encontrada!"
                binding.name.setText(word.name)
                for (i in 0..4) listDefsEdits[i].setText(word.definitions[i])
                game.soundPlayer.playSound(R.raw.acierto, parent)
            } else {
                binding.logText.text = "No encontrada!"
                for (i in 0..4) listDefsEdits[i].setText("Default")
                game.soundPlayer.playSound(R.raw.fallo, parent)
            }
        }
        binding.wordbar.edit.setOnClickListener {
            if (binding.name.text.toString() == "") {
                binding.logText.text = "Nombre no vacío!"
                game.soundPlayer.playSound(R.raw.fallo, parent)
            } else {
                val word = WordEntity(
                    binding.name.text.toString(),
                    listOf(
                        listDefsEdits[0].text.toString(),
                        listDefsEdits[1].text.toString(),
                        listDefsEdits[2].text.toString(),
                        listDefsEdits[3].text.toString(),
                        listDefsEdits[4].text.toString(),
                    )
                )
                if (game.searchWord(word.name) != null) {
                    game.updateWord(word)
                    binding.logText.text = "Actualizada ${word.name}!"
                } else {
                    game.addWord(word)
                    binding.logText.text = "Creada ${word.name}!"
                }
                game.soundPlayer.playSound(R.raw.acierto, parent)
            }
        }
        binding.wordbar.delete.setOnClickListener {
            val word = game.searchWord(binding.name.text.toString())
            if (word != null) {
                game.deleteWord(word)
                game.soundPlayer.playSound(R.raw.acierto, parent)
                binding.logText.text = "${word.name} borrada con éxito!"
            } else {
                game.soundPlayer.playSound(R.raw.fallo, parent)
                binding.logText.text = "${binding.name.text} no existe!"
            }
        }
        binding.dictionaryButton.setOnClickListener {
            Log.d("Press", "pPP")
            showDictionaryPopUp()
            Log.d("Press", "pPP")
        }
        return binding.root
    }
    private fun showDictionaryPopUp() {

        // Create popup
        val popUpView = layoutInflater.inflate(R.layout.diccionary_popup, null)
        val cancelImageButton = popUpView.findViewById<ImageButton>(R.id.cancelButton)
        val recyclerView = popUpView.findViewById<RecyclerView>(R.id.recycler)
        val popUp = AlertDialog.Builder(this.requireContext()).setView(popUpView).create()

        cancelImageButton.setOnClickListener { popUp.dismiss() }
        recyclerView.layoutManager = LinearLayoutManager(parent)
        recyclerView.adapter = WordsAdapter(game.getAllWords())

        // Show popup
        popUp.show()
    }


}