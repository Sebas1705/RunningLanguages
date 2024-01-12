package com.sebss.pass_word.ui.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.sebss.pass_word.R
import com.sebss.pass_word.data.entities.WordEntity

class WordsAdapter(private val wordsList: List<WordEntity>): RecyclerView.Adapter<WordsViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): WordsViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        return WordsViewHolder(layoutInflater.inflate(R.layout.item_word,parent,false))
    }

    override fun getItemCount(): Int = wordsList.size


    override fun onBindViewHolder(holder: WordsViewHolder, position: Int) {
        holder.render(wordsList[position])
    }
}