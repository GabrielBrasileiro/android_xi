package com.universodoandroid.androidxi.retrofit

interface ApiDataSource {
    fun <S> createService(serviceClass: Class<S>): S
}