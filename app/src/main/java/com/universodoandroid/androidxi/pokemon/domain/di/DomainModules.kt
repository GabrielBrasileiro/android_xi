package com.universodoandroid.androidxi.pokemon.domain.di

import com.universodoandroid.androidxi.pokemon.domain.usecase.GetPokemonsUseCase
import com.universodoandroid.androidxi.pokemon.domain.usecase.GetPokemonsUseCaseImpl
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ActivityComponent

@Module
@InstallIn(ActivityComponent::class)
abstract class DomainModules {

    @Binds
    abstract fun bindPokemonUseCase(getPokemonsUseCase: GetPokemonsUseCaseImpl): GetPokemonsUseCase
}