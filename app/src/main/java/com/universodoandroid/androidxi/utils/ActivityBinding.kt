package com.universodoandroid.androidxi.utils

import android.os.Bundle
import androidx.annotation.LayoutRes
import androidx.appcompat.app.AppCompatActivity
import androidx.viewbinding.ViewBinding
import com.universodoandroid.androidxi.databinding.ActivityPokemonBinding.inflate


open class ActivityBinding<V : ViewBinding>(@LayoutRes res: Int) : AppCompatActivity(res) {

    protected lateinit var binding: V
        private set

    @Suppress("UNCHECKED_CAST")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = inflate(layoutInflater) as V
        setContentView(binding.root)
    }
}