package com.demo.pokemon.presentation.home

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.demo.pokemon.R
import kotlinx.android.synthetic.main.item_pokemon.view.*

class PokemonAdapter(val userList: List<String>, val callback : PokemonAdapter.Callback): RecyclerView.Adapter<PokemonAdapter.ViewHolder>() {

    interface Callback{
        fun onPokemonSelected(position: Int)
    }
    override fun onBindViewHolder(holder: ViewHolder?, position: Int) {
//        holder?.tvName?.text = userList[position].name
//        holder?.tvUrl?.text = userList[position].url
        holder?.tvName?.text = userList[position]
        holder?.view?.setOnClickListener { callback.onPokemonSelected(position) }
    }

    override fun onCreateViewHolder(parent: ViewGroup?, viewType: Int): ViewHolder {
        val v = LayoutInflater.from(parent?.context).inflate(R.layout.item_pokemon, parent, false)
        return ViewHolder(v);
    }

    override fun getItemCount(): Int {
        return userList.size
    }

    class ViewHolder(itemView: View): RecyclerView.ViewHolder(itemView){
        val view = itemView.cardview
        val tvName = itemView.tvName
        val tvUrl = itemView.tvUrl

    }

}