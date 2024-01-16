package com.sebss.pass_word.ui.adapters

import android.annotation.SuppressLint
import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.sebss.pass_word.domain.Game
import com.sebss.pass_word.R
import com.sebss.pass_word.data.entities.PlayerEntity
import com.sebss.pass_word.databinding.ItemPlayerBinding

class PlayerViewHolder(view: View): RecyclerView.ViewHolder(view){

    private val game = Game.getInstance(null)
    private val binding = ItemPlayerBinding.bind(view)


    fun render(player: PlayerEntity,ranking:Int){
        if(game.player!=null&&game.player!!.name==player.name) binding.name.text = "${ranking}º: Tú(${player.name})"
        else binding.name.text = "${ranking}º: ${player.name}"
        binding.icon.setImageResource(player.imageIcon)
        binding.score.text = "Score: "+player.score.toString()
    }
}