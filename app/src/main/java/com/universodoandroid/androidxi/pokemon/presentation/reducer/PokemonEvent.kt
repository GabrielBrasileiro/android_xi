package com.universodoandroid.androidxi.pokemon.presentation.reducer

import com.mvvmredux.core.event.Event

sealed class PokemonEvent : Event {

    object ShowLoader: PokemonEvent()
    object HideLoader: PokemonEvent()
}