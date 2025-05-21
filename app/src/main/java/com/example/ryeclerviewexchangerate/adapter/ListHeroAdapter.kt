package com.example.ryeclerviewexchangerate.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.ryeclerviewexchangerate.R
import com.example.ryeclerviewexchangerate.model.Hero

class ListHeroAdapter(
    private val listHero: ArrayList<Hero>,
    private val onItemClick: (Hero) -> Unit
) : RecyclerView.Adapter<ListHeroAdapter.ListViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ListViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_row_hero, parent, false)
        return ListViewHolder(view)
    }

    override fun onBindViewHolder(holder: ListViewHolder, position: Int) {
        val hero = listHero[position]
        holder.imgFlag.setImageResource(hero.flag)
        holder.txtCountry.text = hero.country
        holder.txtBuy.text = String.format("%.3f", hero.buy)
        holder.txtSell.text = String.format("%.3f", hero.sell)

        holder.itemView.setOnClickListener {
            onItemClick(hero)
        }
    }

    override fun getItemCount(): Int = listHero.size

    class ListViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val imgFlag: ImageView = itemView.findViewById(R.id.image_flag)
        val txtCountry: TextView = itemView.findViewById(R.id.text_country)
        val txtBuy: TextView = itemView.findViewById(R.id.text_buy)
        val txtSell: TextView = itemView.findViewById(R.id.text_sell)
    }
}
