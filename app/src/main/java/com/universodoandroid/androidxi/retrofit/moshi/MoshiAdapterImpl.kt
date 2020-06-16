package com.universodoandroid.androidxi.retrofit.moshi

import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import retrofit2.converter.moshi.MoshiConverterFactory
import javax.inject.Inject

class MoshiAdapterImpl @Inject constructor(): MoshiAdapter {

    override fun createFactory(): MoshiConverterFactory {
        val moshiBuild = Moshi.Builder()
            .add(KotlinJsonAdapterFactory())
            .build()

        return MoshiConverterFactory.create(moshiBuild)
    }
}