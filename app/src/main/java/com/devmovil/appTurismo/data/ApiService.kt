package com.devmovil.appTurismo.data

import com.devmovil.appTurismo.model.ListaLugares
import retrofit2.http.GET

interface ApiService {
    @GET("Gabriel1085/DevMovil-appTurismo/Lugares")
    suspend fun getLugares(): ListaLugares
}