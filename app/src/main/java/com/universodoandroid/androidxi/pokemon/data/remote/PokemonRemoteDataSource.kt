package com.universodoandroid.androidxi.pokemon.data.remote

import com.universodoandroid.androidxi.pokemon.data.remote.response.PokemonBodyResponse
import kotlinx.coroutines.flow.Flow

interface PokemonRemoteDataSource {
    fun getPokemons(): Flow<PokemonBodyResponse>
}