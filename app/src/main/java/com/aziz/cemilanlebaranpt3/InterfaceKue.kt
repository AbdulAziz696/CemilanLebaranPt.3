package com.aziz.cemilanlebaranpt3

import retrofit2.Response
import retrofit2.http.GET

interface InterfaceKue {
    @GET("Data/kuekering.json")
    suspend fun getDataKuker(): Response<List<KuekeringItem>>



    @GET("Data/kuebasah.json")
    suspend fun getDataKubas(): Response<List<KuebasahItem>>
}



