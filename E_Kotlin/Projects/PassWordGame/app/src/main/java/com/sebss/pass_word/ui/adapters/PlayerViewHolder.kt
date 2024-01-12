package com.sebss.pass_word.ui.adapters

import android.annotation.SuppressLint
import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.widget.LinearLayoutCompat
import androidx.recyclerview.widget.RecyclerView
import com.sebss.pass_word.Game
import com.sebss.pass_word.R
import com.sebss.pass_word.data.entities.PlayerEntity
import com.sebss.pass_word.databinding.ItemPlayerBinding

class PlayerViewHolder(view: View): RecyclerView.ViewHolder(view){

    private val game = Game.getInstance(null)
    private val binding = ItemPlayerBinding.bind(view)

    @SuppressLint("SetTextI18n")
    fun render(player: PlayerEntity,ranking:Int){
        if(game.player!=null&&game.player!!.name==player.name){
            binding.back.setBackgroundResource(R.drawable.back_item_selected)
        }
        binding.icon.setImageResource(player.imageIcon)
        binding.name.text = ranking.toString()+"º: "+player.name
        binding.score.text = "Score: "+player.score.toString()
    }
}