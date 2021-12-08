package com.devmovil.appTurismo.data

import com.devmovil.appTurismo.list.ListaLugares
import retrofit2.http.GET

interface ApiService {
    @GET("DevMovil-appTurismo/Lugares")
    suspend fun getLugares(): ListaLugares
}