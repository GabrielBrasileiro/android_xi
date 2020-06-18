package com.universodoandroid.androidxi.pokemon.data.mapper

import com.universodoandroid.androidxi.pokemon.data.remote.response.PokemonBodyResponse
import com.universodoandroid.androidxi.pokemon.domain.entity.Pokemon
import com.universodoandroid.androidxi.pokemon.domain.entity.PokemonsInfo
import com.universodoandroid.androidxi.utils.Mapper
import javax.inject.Inject

class PokemonsMapper @Inject constructor() : Mapper<PokemonBodyResponse, PokemonsInfo> {

    override fun map(enter: PokemonBodyResponse): PokemonsInfo {
        val pokemons = enter.results.map { Pokemon(it.name, it.url) }
        return PokemonsInfo(pokemons)
    }
}