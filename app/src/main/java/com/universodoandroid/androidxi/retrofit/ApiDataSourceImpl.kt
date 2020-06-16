package com.universodoandroid.androidxi.retrofit

import com.universodoandroid.androidxi.retrofit.moshi.MoshiAdapter
import com.universodoandroid.androidxi.retrofit.source.BaseUrl
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ApplicationComponent
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import java.util.concurrent.TimeUnit
import javax.inject.Inject

@Module
@InstallIn(ApplicationComponent::class)
class ApiDataSourceImpl @Inject constructor(
    private val baseUrlImpl: BaseUrl,
    private val moshiAdapterImpl: MoshiAdapter
) : ApiDataSource {

    private val timeOut: Long = 30

    override fun <S> createService(serviceClass: Class<S>): S {
        val logging = HttpLoggingInterceptor()
        logging.level = HttpLoggingInterceptor.Level.BODY

        val httpClient = OkHttpClient.Builder()
        httpClient.addInterceptor(logging)
        httpClient.connectTimeout(timeOut, TimeUnit.SECONDS)
        httpClient.readTimeout(timeOut, TimeUnit.SECONDS)

        val retrofit = Retrofit.Builder()
            .baseUrl(baseUrlImpl.get())
            .client(httpClient.build())
            .addConverterFactory(moshiAdapterImpl.createFactory())
            .build()

        return retrofit.create(serviceClass)
    }
}