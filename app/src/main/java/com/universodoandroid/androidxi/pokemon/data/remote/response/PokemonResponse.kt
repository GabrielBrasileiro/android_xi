package com.universodoandroid.androidxi.pokemon.data.remote.response

import com.squareup.moshi.Json

data class PokemonResponse(
    @field:Json(name = "name")
    val name: String,

    @field:Json(name = "url")
    val url: String
)