package com.universodoandroid.androidxi.pokemon.data.repository

import com.universodoandroid.androidxi.pokemon.data.remote.PokemonRemoteDataSource
import com.universodoandroid.androidxi.pokemon.data.remote.response.PokemonBodyResponse
import com.universodoandroid.androidxi.pokemon.domain.entity.PokemonsInfo
import com.universodoandroid.androidxi.pokemon.domain.repository.PokemonRepository
import com.universodoandroid.androidxi.utils.Mapper
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import javax.inject.Inject

class PokemonRepositoryImpl @Inject constructor(
    private val remoteDataSource: PokemonRemoteDataSource,
    private val mapper: Mapper<PokemonBodyResponse, PokemonsInfo>
) : PokemonRepository {

    override fun getPokemonsInfo(): Flow<PokemonsInfo> {
        return remoteDataSource.getPokemons().map { mapper.map(it) }
    }
}