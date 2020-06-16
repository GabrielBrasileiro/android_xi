package com.universodoandroid.androidxi.retrofit.moshi

import retrofit2.converter.moshi.MoshiConverterFactory

interface MoshiAdapter {
    fun createFactory(): MoshiConverterFactory
}