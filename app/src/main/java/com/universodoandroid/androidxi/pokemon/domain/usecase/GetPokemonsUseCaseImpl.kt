package com.universodoandroid.androidxi.pokemon.domain.usecase

import com.universodoandroid.androidxi.pokemon.data.remote.response.PokemonBodyResponse
import com.universodoandroid.androidxi.pokemon.domain.repository.PokemonRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class GetPokemonsUseCaseImpl @Inject constructor(
    private val pokemonsRepository: PokemonRepository
): GetPokemonsUseCase {

    override fun get(): Flow<PokemonBodyResponse> {
        return pokemonsRepository.getPokemons()
    }
}