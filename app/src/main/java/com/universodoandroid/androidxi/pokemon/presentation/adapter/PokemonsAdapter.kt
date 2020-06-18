package com.universodoandroid.androidxi.pokemon.presentation.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.universodoandroid.androidxi.databinding.PokemonItemBinding
import com.universodoandroid.androidxi.pokemon.presentation.model.PokemonPresentation

class PokemonsAdapter : RecyclerView.Adapter<PokemonsAdapter.PokemonsAdapterViewHolder>() {

    private var pokemons = arrayListOf<PokemonPresentation>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PokemonsAdapterViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        val binding = PokemonItemBinding.inflate(layoutInflater, parent, false)
        return PokemonsAdapterViewHolder(binding.root)
    }

    override fun onBindViewHolder(holder: PokemonsAdapterViewHolder, position: Int) {
        with(holder.binding) {
            nameTextView.text = pokemons[position].name
        }
    }

    override fun getItemCount(): Int = pokemons.size

    fun addPokemons(_pokemons: List<PokemonPresentation>) {
        pokemons.addAll(_pokemons)
        notifyDataSetChanged()
    }

    inner class PokemonsAdapterViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val binding = PokemonItemBinding.bind(view)
    }
}