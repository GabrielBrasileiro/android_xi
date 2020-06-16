package com.universodoandroid.androidxi.pokemon.data.di

import com.universodoandroid.androidxi.pokemon.data.remote.PokemonRemoteDataSource
import com.universodoandroid.androidxi.pokemon.data.remote.PokemonRemoteDataSourceImpl
import com.universodoandroid.androidxi.pokemon.data.remote.api.PokemonApi
import com.universodoandroid.androidxi.pokemon.data.repository.PokemonRepositoryImpl
import com.universodoandroid.androidxi.pokemon.domain.repository.PokemonRepository
import com.universodoandroid.androidxi.retrofit.ApiDataSource
import dagger.Binds
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ActivityComponent

@Module
@InstallIn(ActivityComponent::class)
abstract class DataModules {

    @Binds
    abstract fun bindPokemonRepository(pokemonRepository: PokemonRepositoryImpl): PokemonRepository

    @Binds
    abstract fun bindPokemonRemoteData(
        pokemonRemoteDataSource: PokemonRemoteDataSourceImpl
    ): PokemonRemoteDataSource

    @Module
    @InstallIn(ActivityComponent::class)
    object PokemonDataSource {

        @Provides
        fun providesPokemonApiDataSource(apiDataSource: ApiDataSource): PokemonApi {
            return apiDataSource.createService(PokemonApi::class.java)
        }
    }
}