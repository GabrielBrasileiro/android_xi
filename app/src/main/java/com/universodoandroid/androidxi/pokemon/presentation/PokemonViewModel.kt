package com.universodoandroid.androidxi.pokemon.presentation

import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.viewModelScope
import com.mvvmredux.core.BaseViewModel
import com.mvvmredux.core.livedata.SingleLiveEvent
import com.mvvmredux.core.reducer.Reducer
import com.universodoandroid.androidxi.extensions.ioToMain
import com.universodoandroid.androidxi.pokemon.domain.entity.PokemonsInfo
import com.universodoandroid.androidxi.pokemon.domain.usecase.GetPokemonsUseCase
import com.universodoandroid.androidxi.pokemon.presentation.model.PokemonPresentation
import com.universodoandroid.androidxi.pokemon.presentation.reducer.PokemonData
import com.universodoandroid.androidxi.pokemon.presentation.reducer.PokemonEvent
import com.universodoandroid.androidxi.pokemon.presentation.reducer.PokemonStateEvent
import com.universodoandroid.androidxi.utils.Mapper
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.launch
import javax.inject.Inject

class PokemonViewModel @ViewModelInject constructor(
    private val getPokemonsUseCase: GetPokemonsUseCase,
    private val mapper: Mapper<PokemonsInfo, MutableList<PokemonPresentation>>,
    reducer: Reducer<PokemonData, PokemonStateEvent>,
    event: SingleLiveEvent<PokemonEvent>
) : BaseViewModel<PokemonData, PokemonEvent, PokemonStateEvent>(event, reducer) {

    init {
        loadPokemons()
    }

    private fun loadPokemons() {
        sendEvent(PokemonEvent.ShowLoader)
        viewModelScope.launch {
            try {
                getPokemonsUseCase.get().map {
                    mapper.map(it)
                }.ioToMain {
                    updateTo(PokemonStateEvent.ShowPokemons(it))
                }
            } catch (e: Exception) {
                print(e)
            } finally {
                sendEvent(PokemonEvent.HideLoader)
            }
        }
    }
}