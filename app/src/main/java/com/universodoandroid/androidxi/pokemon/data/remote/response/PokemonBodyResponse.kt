package com.universodoandroid.androidxi.pokemon.data.remote.response

import com.squareup.moshi.Json

data class PokemonBodyResponse(
    @field:Json(name = "count")
    val count: Int,

    @field:Json(name = "next")
    val next: String?,

    @field:Json(name = "previous")
    val previous: String?,

    @field:Json(name = "results")
    val results: List<PokemonResponse>
)