package com.example.starwarsapi.ui.screens

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.example.starwarsapi.modelo.Respuesta
import com.example.starwarsapi.ui.StarWarsUIState

@Composable
fun PantallaListarPeliculas(
    indiceNave: Int,
    starWarsUIState: StarWarsUIState,
    modifier: Modifier = Modifier,
) {
    Text(
        text = "Peliculas de la nave"
    )
}

@Composable
fun PantallaExitoPeliculas(
    modifier: Modifier = Modifier,
    respuesta: Respuesta
){

}
