package com.sebss.pass_word.ui.adapters

import android.annotation.SuppressLint
import android.view.View
import android.widget.ImageButton
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.sebss.pass_word.R
import com.sebss.pass_word.data.entities.WordEntity
import com.sebss.pass_word.databinding.ItemWordBinding

class WordsViewHolder(view: View): RecyclerView.ViewHolder(view) {

    private val binding = ItemWordBinding.bind(view)

    @SuppressLint("SetTextI18n")
    fun render(word:WordEntity){
        binding.name.text = word.name
        binding.def.text = word.definitions.first()
        binding.left.setOnClickListener {
            val i=word.definitions.indexOf(binding.def.text)
            if (i==0) binding.def.text=word.definitions[word.definitions.size-1]
            else binding.def.text=word.definitions[i-1]
        }
        binding.right.setOnClickListener {
            val i=word.definitions.indexOf(binding.def.text)
            if(i==word.definitions.size-1) binding.def.text=word.definitions[0]
            else binding.def.text=word.definitions[i+1]
        }
    }
}