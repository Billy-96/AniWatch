package com.example.aniwatch.Adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.cardview.widget.CardView
import androidx.recyclerview.widget.RecyclerView
import com.example.aniwatch.Model.AnimeAndManga
import com.example.aniwatch.Model.OnClick
import com.example.aniwatch.R

class MainAdapter(
    private val context: Context,
    private val list: List<AnimeAndManga>,
    private val listener: OnClick
) : RecyclerView.Adapter<MainAdapter.Holder>() {
    inner class Holder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var title = itemView.findViewById<TextView>(R.id.text_maket)
        val card = itemView.findViewById<CardView>(R.id.card_maket)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): Holder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.maket_main, parent, false)
        return Holder(view)
    }

    override fun onBindViewHolder(holder: Holder, position: Int) {
        val anime = list[position]
        holder.title.text = anime.title
        holder.card.setOnClickListener {
            listener.cardClick(anime.url)
        }
    }

    override fun getItemCount(): Int {
        return list.size
    }

}