package com.devmovil.appTurismo.data

class LugaresRepository {

    suspend fun getLugares() = ApiFactory.retrofit.getLugares()
}