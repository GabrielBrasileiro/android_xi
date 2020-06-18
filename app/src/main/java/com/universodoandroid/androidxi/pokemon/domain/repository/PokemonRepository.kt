package com.universodoandroid.androidxi.pokemon.domain.repository

import com.universodoandroid.androidxi.pokemon.domain.entity.PokemonsInfo
import kotlinx.coroutines.flow.Flow

interface PokemonRepository {
    fun getPokemonsInfo(): Flow<PokemonsInfo>
}