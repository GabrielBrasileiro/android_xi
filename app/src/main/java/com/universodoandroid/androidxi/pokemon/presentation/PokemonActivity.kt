package com.universodoandroid.androidxi.pokemon.presentation

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import androidx.lifecycle.Observer
import com.universodoandroid.androidxi.R
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class PokemonActivity : AppCompatActivity() {

    @Inject lateinit var viewModel: PokemonViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        setupListener()
    }

    private fun setupListener() {
        viewModel.getPokemonsLiveData().observe(this, Observer {
            loadPokemons(it)
        })
    }

    private fun loadPokemons(name: String) {
        val nameTextView = findViewById<TextView>(R.id.name_text_view)
        nameTextView.text = name
    }
}