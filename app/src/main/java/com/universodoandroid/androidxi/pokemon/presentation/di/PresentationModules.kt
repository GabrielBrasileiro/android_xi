package com.universodoandroid.androidxi.pokemon.presentation.di

import com.mvvmredux.core.livedata.SingleLiveEvent
import com.mvvmredux.core.reducer.Reducer
import com.universodoandroid.androidxi.pokemon.domain.entity.PokemonsInfo
import com.universodoandroid.androidxi.pokemon.presentation.mapper.PokemonsPresentationMapper
import com.universodoandroid.androidxi.pokemon.presentation.model.PokemonPresentation
import com.universodoandroid.androidxi.pokemon.presentation.reducer.PokemonData
import com.universodoandroid.androidxi.pokemon.presentation.reducer.PokemonEvent
import com.universodoandroid.androidxi.pokemon.presentation.reducer.PokemonReducer
import com.universodoandroid.androidxi.pokemon.presentation.reducer.PokemonStateEvent
import com.universodoandroid.androidxi.utils.Mapper
import dagger.Binds
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ActivityRetainedComponent

@Module
@InstallIn(ActivityRetainedComponent::class)
abstract class PresentationModules {

    @Binds
    abstract fun bindPokemonPresentationMapper(
        pokemonPresentationMapper: PokemonsPresentationMapper
    ): Mapper<PokemonsInfo, MutableList<PokemonPresentation>>

    @Binds
    abstract fun bindPokemonReducer(
        pokemonReducer: PokemonReducer
    ): Reducer<PokemonData, PokemonStateEvent>

    @Module
    @InstallIn(ActivityRetainedComponent::class)
    object SingleEvent {

        @Provides
        fun providePokemonSingleEvent(): SingleLiveEvent<PokemonEvent> {
            return SingleLiveEvent()
        }
    }
}
