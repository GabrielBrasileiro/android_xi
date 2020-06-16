package com.universodoandroid.androidxi.pokemon.presentation

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.universodoandroid.androidxi.pokemon.domain.usecase.GetPokemonsUseCase
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.flow.flowOn
import kotlinx.coroutines.launch
import java.lang.Exception
import javax.inject.Inject

class PokemonViewModel @Inject constructor(
    private val getPokemonsUseCase: GetPokemonsUseCase
) : ViewModel() {

    private val pokemonsMutableLiveData = MutableLiveData<String>()

    fun getPokemonsLiveData() = pokemonsMutableLiveData

    init {
        loadPokemons()
    }

    private fun loadPokemons() {
        viewModelScope.launch {
            try {
                getPokemonsUseCase.get()
                    .flowOn(Dispatchers.IO)
                    .collect {
                        print(it)
                    }
            } catch (e: Exception) {
                print(e)
            }
        }
    }
}