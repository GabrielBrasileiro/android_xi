package com.universodoandroid.androidxi.pokemon.presentation.mapper

import com.universodoandroid.androidxi.pokemon.domain.entity.PokemonsInfo
import com.universodoandroid.androidxi.pokemon.presentation.model.PokemonPresentation
import com.universodoandroid.androidxi.utils.Mapper
import javax.inject.Inject

class PokemonsPresentationMapper @Inject constructor() :
    Mapper<PokemonsInfo, MutableList<PokemonPresentation>> {

    override fun map(enter: PokemonsInfo): MutableList<PokemonPresentation> {
        return enter.pokemons.map { PokemonPresentation(it.name) }.toMutableList()
    }
}