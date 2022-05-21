package com.example.spasexclient.ui.home

import com.example.spasexclient.data.models.Fairings
import com.example.spasexclient.data.services.FairingsService
import retrofit2.Response

class HomeUseCase(private val service: FairingsService) {

    fun getFairings() : Response<List<Fairings>> {
        return service.getFairings().execute()
    }

}