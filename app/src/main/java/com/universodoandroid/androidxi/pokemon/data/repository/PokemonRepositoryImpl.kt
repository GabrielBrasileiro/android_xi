package com.universodoandroid.androidxi.pokemon.data.repository

import com.universodoandroid.androidxi.pokemon.data.remote.PokemonRemoteDataSource
import com.universodoandroid.androidxi.pokemon.data.remote.response.PokemonBodyResponse
import com.universodoandroid.androidxi.pokemon.domain.repository.PokemonRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class PokemonRepositoryImpl @Inject constructor(
    private val remoteDataSource: PokemonRemoteDataSource
) : PokemonRepository {

    override fun getPokemons(): Flow<PokemonBodyResponse> {
        return remoteDataSource.getPokemons()
    }
}