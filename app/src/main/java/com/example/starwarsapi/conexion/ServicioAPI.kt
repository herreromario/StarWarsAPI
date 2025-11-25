package com.example.starwarsapi.conexion

import com.example.starwarsapi.modelo.Respuesta
import com.jakewharton.retrofit2.converter.kotlinx.serialization.asConverterFactory
import kotlinx.serialization.json.Json
import okhttp3.MediaType.Companion.toMediaType
import retrofit2.Retrofit
import retrofit2.http.GET

private const val BASE_URL = "https://swapi.dev/api/"

private val json = Json { ignoreUnknownKeys = true }

private val retrofit = Retrofit.Builder()
    .addConverterFactory(json.asConverterFactory("application/json".toMediaType()))
    .baseUrl(BASE_URL)
    .build()

interface ServicioAPI {
    @GET("starships")
    suspend fun obtenerStarship(): Respuesta
}

object API {
    val servicioRetrofit: ServicioAPI by lazy {
        retrofit.create(ServicioAPI::class.java)
    }
}