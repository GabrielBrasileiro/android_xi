package com.universodoandroid.androidxi.pokemon.data.di

import com.universodoandroid.androidxi.pokemon.data.mapper.PokemonsMapper
import com.universodoandroid.androidxi.pokemon.data.remote.PokemonRemoteDataSource
import com.universodoandroid.androidxi.pokemon.data.remote.PokemonRemoteDataSourceImpl
import com.universodoandroid.androidxi.pokemon.data.remote.api.PokemonApi
import com.universodoandroid.androidxi.pokemon.data.remote.response.PokemonBodyResponse
import com.universodoandroid.androidxi.pokemon.data.repository.PokemonRepositoryImpl
import com.universodoandroid.androidxi.pokemon.domain.entity.PokemonsInfo
import com.universodoandroid.androidxi.pokemon.domain.repository.PokemonRepository
import com.universodoandroid.androidxi.retrofit.ApiDataSource
import com.universodoandroid.androidxi.utils.Mapper
import dagger.Binds
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ActivityRetainedComponent

@Module
@InstallIn(ActivityRetainedComponent::class)
abstract class DataModules {

    @Binds
    abstract fun bindPokemonRepository(pokemonRepository: PokemonRepositoryImpl): PokemonRepository

    @Binds
    abstract fun bindPokemonRemoteData(
        pokemonRemoteDataSource: PokemonRemoteDataSourceImpl
    ): PokemonRemoteDataSource

    @Binds
    abstract fun bindPokemonsMapper(
        pokemonsMapper: PokemonsMapper
    ): Mapper<PokemonBodyResponse, PokemonsInfo>

    @Module
    @InstallIn(ActivityRetainedComponent::class)
    object PokemonDataSource {

        @Provides
        fun providesPokemonApiDataSource(apiDataSource: ApiDataSource): PokemonApi {
            return apiDataSource.createService(PokemonApi::class.java)
        }
    }
}
