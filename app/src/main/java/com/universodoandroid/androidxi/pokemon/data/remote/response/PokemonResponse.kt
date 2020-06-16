package com.universodoandroid.androidxi.pokemon.data.remote.response

import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class PokemonResponse(
    val name: String,
    val url: String
)