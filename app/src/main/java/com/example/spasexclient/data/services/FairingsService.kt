package com.example.spasexclient.data.services

import com.example.spasexclient.data.models.Fairings
import retrofit2.Call
import retrofit2.http.GET

interface FairingsService {
    @GET("launches")
    fun getFairings(): Call<List<Fairings>>
}