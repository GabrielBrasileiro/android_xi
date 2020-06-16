package com.universodoandroid.androidxi.pokemon.data.remote.response

import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class PokemonBodyResponse(
    val count: Int,
    val next: String,
    val previous: String,
    val results: List<PokemonResponse>
)