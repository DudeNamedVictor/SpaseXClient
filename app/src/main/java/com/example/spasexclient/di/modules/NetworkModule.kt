package com.example.spasexclient.di.modules

import com.example.spasexclient.data.services.FairingsService
import com.example.spasexclient.data.Constants.BASE_URL
import dagger.Module
import dagger.Provides
import okhttp3.Interceptor
import okhttp3.OkHttpClient
import okhttp3.Request
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
class NetworkModule {

    @Provides
    fun provideRetrofit(): Retrofit {
        val logging = HttpLoggingInterceptor()
        val httpClient = OkHttpClient.Builder()

        logging.setLevel(HttpLoggingInterceptor.Level.BODY)
        httpClient.addInterceptor(logging).networkInterceptors().add(Interceptor {
            val requestBuilder: Request.Builder = it.request().newBuilder()
            it.proceed(requestBuilder.build())
        })

        return Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .client(httpClient.build())
            .build()
    }

    @Provides
    @Singleton
    fun provideCatService(retrofit: Retrofit): FairingsService {
        return retrofit.create(FairingsService::class.java)
    }
}