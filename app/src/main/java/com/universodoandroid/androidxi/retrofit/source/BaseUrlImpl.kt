package com.universodoandroid.androidxi.retrofit.source

import com.universodoandroid.androidxi.BuildConfig
import javax.inject.Inject

class BaseUrlImpl @Inject constructor(): BaseUrl {

    override fun get(): String {
        return BuildConfig.BASE_URL
    }
}