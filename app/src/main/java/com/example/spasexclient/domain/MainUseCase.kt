package com.example.spasexclient.domain

import com.example.spasexclient.data.models.Fairings
import com.example.spasexclient.data.services.FairingsService
import retrofit2.Response

class MainUseCase(private val service: FairingsService) {

    fun getFairings() : Response<List<Fairings>> {
        return service.getFairings().execute()
    }

}