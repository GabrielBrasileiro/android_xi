package com.universodoandroid.androidxi.pokemon.presentation.reducer

import com.mvvmredux.core.stateevent.StateEvent
import com.universodoandroid.androidxi.pokemon.presentation.model.PokemonPresentation

sealed class PokemonStateEvent : StateEvent {

    data class ShowPokemons(
        val pokemons: List<PokemonPresentation>
    ) : PokemonStateEvent()
}