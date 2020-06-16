package com.universodoandroid.androidxi.pokemon.domain.usecase

import com.universodoandroid.androidxi.pokemon.data.remote.response.PokemonBodyResponse
import kotlinx.coroutines.flow.Flow

interface GetPokemonsUseCase {
    fun get(): Flow<PokemonBodyResponse>
}