package com.example.kotlinfootballappchallenge.network

import com.example.kotlinfootballappchallenge.common.Constants
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class RetrofitInstanceTeam {
    val retrofitInstanceTeam: Retrofit
    get() {
        val loggingIntercepter = HttpLoggingInterceptor()
        val okHttpClient = OkHttpClient.Builder()
            .addInterceptor(loggingIntercepter)
            .build()
        loggingIntercepter.level = HttpLoggingInterceptor.Level.BODY

        return Retrofit.Builder()
            .baseUrl(Constants.BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

}