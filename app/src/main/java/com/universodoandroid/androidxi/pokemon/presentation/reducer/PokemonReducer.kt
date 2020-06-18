package com.universodoandroid.androidxi.pokemon.presentation.reducer

import com.mvvmredux.core.reducer.ReducerScope
import javax.inject.Inject

class PokemonReducer @Inject constructor(): ReducerScope<PokemonData, PokemonStateEvent>(
    initialState = PokemonData()
) {

    override fun updateTo(stateEvent: PokemonStateEvent) = updateState {
        when (stateEvent) {
            is PokemonStateEvent.ShowPokemons -> copy(pokemons = stateEvent.pokemons)
        }
    }
}