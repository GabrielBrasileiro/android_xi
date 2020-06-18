package com.universodoandroid.androidxi.pokemon.presentation.reducer

import com.mvvmredux.core.state.State
import com.universodoandroid.androidxi.pokemon.presentation.model.PokemonPresentation

data class PokemonData(
    val pokemons: List<PokemonPresentation> = listOf()
) : State