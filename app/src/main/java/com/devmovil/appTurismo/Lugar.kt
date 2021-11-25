package com.devmovil.appTurismo


import com.google.gson.annotations.SerializedName

data class Lugar(
    @SerializedName("descripcion")
    val descripcion: String,
    @SerializedName("id")
    val id: String,
    @SerializedName("nombre")
    val nombre: String,
    @SerializedName("urlImagen")
    val urlImagen: String
)