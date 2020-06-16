package com.universodoandroid.androidxi.retrofit.di

import com.universodoandroid.androidxi.retrofit.ApiDataSource
import com.universodoandroid.androidxi.retrofit.ApiDataSourceImpl
import com.universodoandroid.androidxi.retrofit.moshi.MoshiAdapter
import com.universodoandroid.androidxi.retrofit.moshi.MoshiAdapterImpl
import com.universodoandroid.androidxi.retrofit.source.BaseUrl
import com.universodoandroid.androidxi.retrofit.source.BaseUrlImpl
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ApplicationComponent

@Module
@InstallIn(ApplicationComponent::class)
abstract class ApiDataSourceModule {

    @Binds
    abstract fun bindApiDataSource(apiDataSourceImpl: ApiDataSourceImpl): ApiDataSource

    @Binds
    abstract fun bindBaseUrl(baseUrlImpl: BaseUrlImpl): BaseUrl

    @Binds
    abstract fun bindMoshi(moshiAdapterImpl: MoshiAdapterImpl): MoshiAdapter
}