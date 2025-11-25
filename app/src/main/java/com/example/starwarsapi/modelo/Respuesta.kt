package com.example.starwarsapi.modelo

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class Respuesta (
    @SerialName(value = "results")
    val resultado: List<Starship>
)