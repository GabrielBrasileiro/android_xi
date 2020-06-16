package com.universodoandroid.androidxi.pokemon.domain.repository

import com.universodoandroid.androidxi.pokemon.data.remote.response.PokemonBodyResponse
import kotlinx.coroutines.flow.Flow

interface PokemonRepository {
    fun getPokemons(): Flow<PokemonBodyResponse>
}