package com.villadeleyva.data

class LugaresRepository {
    suspend fun getLugares() = ApiFactory.retrofit.getLugares()
}