package com.devmovil.appTurismo.list


import com.google.gson.annotations.SerializedName
import java.io.Serializable

data class Lugar(
    @SerializedName("actividades")
    val actividades: String,
    @SerializedName("descripcion")
    val descripcion: String,
    @SerializedName("id")
    val id: String,git
    @SerializedName("nombre")
    val nombre: String,
    @SerializedName("parrafo")
    val parrafo: String,
    @SerializedName("temperatura")
    val temperatura: String,
    @SerializedName("ubicacion")
    val ubicacion: String,
    @SerializedName("urlImagen")
    val urlImagen: String

) : Serializable