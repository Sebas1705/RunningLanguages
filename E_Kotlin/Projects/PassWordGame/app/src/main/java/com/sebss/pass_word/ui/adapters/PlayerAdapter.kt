package com.sebss.pass_word.ui.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.sebss.pass_word.R
import com.sebss.pass_word.data.entities.PlayerEntity

class PlayerAdapter(private val playerList: List<PlayerEntity>): RecyclerView.Adapter<PlayerViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PlayerViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        return PlayerViewHolder(layoutInflater.inflate(R.layout.item_player,parent,false))
    }

    override fun getItemCount(): Int = playerList.size


    override fun onBindViewHolder(holder: PlayerViewHolder, position: Int) {
        holder.render(playerList[position],position+1)
    }
}