package com.universodoandroid.androidxi.pokemon.data.remote.api

import com.universodoandroid.androidxi.pokemon.data.remote.response.PokemonBodyResponse
import retrofit2.http.GET

interface PokemonApi {

    @GET("pokemon?limit?=10")
    suspend fun getPokemons(): PokemonBodyResponse
}