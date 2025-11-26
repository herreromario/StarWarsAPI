package com.example.starwarsapi.ui.screens

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.starwarsapi.R
import com.example.starwarsapi.modelo.Respuesta
import com.example.starwarsapi.ui.StarWarsUIState
import com.example.starwarsapi.ui.StarWarsViewModel

@Composable
fun PantallaListarPeliculas(
    starWarsViewModel: StarWarsViewModel,
    modifier: Modifier = Modifier,
) {
    val nave = starWarsViewModel.naveSeleccionada

    if (nave != null){
        Column(
            modifier = modifier
                .fillMaxSize()
                .padding(horizontal = 16.dp, vertical = 8.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(
                text = stringResource(R.string.peliculas_de_la_nave, nave.nombre),
                style = MaterialTheme.typography.headlineLarge
            )

            LazyColumn(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(vertical = 8.dp)) {
                items(nave.peliculas) { pelicula ->
                    Text(pelicula)
                }
            }
        }
    }
}

