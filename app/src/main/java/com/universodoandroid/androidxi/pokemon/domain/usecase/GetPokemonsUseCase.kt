package com.universodoandroid.androidxi.pokemon.domain.usecase

import com.universodoandroid.androidxi.pokemon.domain.entity.PokemonsInfo
import kotlinx.coroutines.flow.Flow

interface GetPokemonsUseCase {
    fun get(): Flow<PokemonsInfo>
}