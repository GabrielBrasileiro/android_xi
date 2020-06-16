package com.universodoandroid.androidxi.pokemon.data.remote

import com.universodoandroid.androidxi.pokemon.data.remote.api.PokemonApi
import com.universodoandroid.androidxi.pokemon.data.remote.response.PokemonBodyResponse
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class PokemonRemoteDataSourceImpl @Inject constructor(
    private val apiDataSource: PokemonApi
) : PokemonRemoteDataSource {

    override fun getPokemons(): Flow<PokemonBodyResponse> {
        return flow { emit(apiDataSource.getPokemons()) }
    }
}