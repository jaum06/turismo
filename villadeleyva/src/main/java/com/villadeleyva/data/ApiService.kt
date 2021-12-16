package com.villadeleyva.data

import com.villadeleyva.model.Poi
import retrofit2.http.GET

interface ApiService {
    @GET("jaum06/turismo/lugares")
    suspend fun getLugares(): Poi
}