package com.example.starwarsapi.modelo

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class Starship (
    @SerialName(value = "name")
    val nombre: String,
    @SerialName(value = "length")
    val longitud: String,
    @SerialName(value = "films")
    val peliculas: List<String>
)