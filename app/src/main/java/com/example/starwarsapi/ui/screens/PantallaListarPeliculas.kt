package com.example.starwarsapi.ui.screens

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.example.starwarsapi.ui.StarWarsUIState

@Composable
fun PantallaListarPeliculas(
    modifier: Modifier = Modifier,
    starWarsUIState: StarWarsUIState
) {
    Text(
        text = "Peliculas de la nave"
    )
}