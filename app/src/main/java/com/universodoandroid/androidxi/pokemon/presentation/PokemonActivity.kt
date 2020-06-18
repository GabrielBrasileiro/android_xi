package com.universodoandroid.androidxi.pokemon.presentation

import android.os.Bundle
import android.view.View
import androidx.activity.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.mvvmredux.ext.onEvent
import com.mvvmredux.ext.onStateChanged
import com.universodoandroid.androidxi.R
import com.universodoandroid.androidxi.databinding.ActivityPokemonBinding
import com.universodoandroid.androidxi.pokemon.presentation.adapter.PokemonsAdapter
import com.universodoandroid.androidxi.pokemon.presentation.model.PokemonPresentation
import com.universodoandroid.androidxi.pokemon.presentation.reducer.PokemonEvent
import com.universodoandroid.androidxi.utils.ActivityBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class PokemonActivity : ActivityBinding<ActivityPokemonBinding>(R.layout.activity_pokemon) {

    private val viewModel: PokemonViewModel by viewModels()
    private val pokemonAdapter by getPokemonsAdapter()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setupStateListener()
        setupActionListener()
        setupAdapter()
    }

    private fun setupStateListener() {
        onStateChanged(viewModel) {
            loadPokemons(it.pokemons)
        }
    }

    private fun setupActionListener() {
        onEvent(viewModel) { event ->
            when (event) {
                is PokemonEvent.ShowLoader -> showLoader(true)
                is PokemonEvent.HideLoader -> showLoader(false)
            }
        }
    }

    private fun setupAdapter() {
        binding.recyclerView.run {
            layoutManager = LinearLayoutManager(this@PokemonActivity)
            adapter = pokemonAdapter
        }
    }

    private fun showLoader(show: Boolean) {
        binding.progressBar.visibility = if (show) View.VISIBLE else View.GONE
    }

    private fun loadPokemons(pokemons: List<PokemonPresentation>) {
        pokemonAdapter.addPokemons(pokemons)
    }

    private fun getPokemonsAdapter(): Lazy<PokemonsAdapter> {
        return lazy {
            PokemonsAdapter().apply {
                stateRestorationPolicy = RecyclerView.Adapter.StateRestorationPolicy.ALLOW
            }
        }
    }
}