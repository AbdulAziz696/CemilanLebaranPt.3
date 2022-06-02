package com.aziz.cemilanlebaranpt3

import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory

object RetrovitKue {
    private val client: OkHttpClient = OkHttpClient.Builder().build()

    private val retrofit: Retrofit = Retrofit.Builder()
        .baseUrl("https://kue-khas-lebaran-9fd0e-default-rtdb.firebaseio.com/")
        .addConverterFactory(MoshiConverterFactory.create())
        .client(client)
        .build()

    fun <T> buildService(service: Class<T>) : T {
        return retrofit.create(service)
    }
}

