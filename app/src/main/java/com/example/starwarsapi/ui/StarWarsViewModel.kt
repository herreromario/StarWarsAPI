package com.example.starwarsapi.ui

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.starwarsapi.conexion.API
import com.example.starwarsapi.modelo.Respuesta
import kotlinx.coroutines.launch
import okio.IOException
import retrofit2.HttpException

sealed interface StarWarsUIState {
    data class Exito(val respuesta: Respuesta): StarWarsUIState
    object Error : StarWarsUIState
    object Cargando : StarWarsUIState
}

class StarWarsViewModel : ViewModel() {
    var starWarsUIState: StarWarsUIState by mutableStateOf(StarWarsUIState.Cargando)
        private set

    init {
        obtenerStarship()
    }

    fun obtenerStarship() {
        viewModelScope.launch {
            starWarsUIState = StarWarsUIState.Cargando
            starWarsUIState = try {
                val listaStarships = API.servicioRetrofit.obtenerStarship()
                StarWarsUIState.Exito(listaStarships)
            } catch (e: IOException){
                StarWarsUIState.Error
            } catch (e: HttpException){
                StarWarsUIState.Error
            }
        }
    }
}