package com.example.starwarsapi.ui.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Button
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.example.starwarsapi.R
import com.example.starwarsapi.modelo.Respuesta
import com.example.starwarsapi.ui.StarWarsUIState

@Composable
fun PantallaListaStarships(
    modifier: Modifier = Modifier,
    starWarsUIState: StarWarsUIState,
    onBotonMostrarPeliculasPulsado: (Int) -> Unit
){
    when(starWarsUIState) {
        is StarWarsUIState.Cargando -> PantallaCargando(modifier = Modifier.fillMaxSize())
        is StarWarsUIState.Error -> PantallaError(modifier = modifier.fillMaxSize())
        is StarWarsUIState.Exito -> PantallaExito(
            modifier = modifier.fillMaxWidth(),
            respuesta = starWarsUIState.respuesta,
            onBotonMostrarPeliculasPulsado = onBotonMostrarPeliculasPulsado
        )
    }
}

@Composable
fun PantallaCargando(
    modifier: Modifier = Modifier
){
    Image(
        modifier = modifier.size(50.dp),
        painter = painterResource(R.drawable.cargando),
        contentDescription = stringResource(R.string.cargando)
    )
}

@Composable
fun PantallaError(
    modifier: Modifier = Modifier
){
    Image(
        modifier = modifier.size(200.dp),
        painter = painterResource(R.drawable.error),
        contentDescription = stringResource(R.string.error_de_conexion)
    )
}

@Composable
fun PantallaExito(
    modifier: Modifier = Modifier,
    respuesta: Respuesta,
    onBotonMostrarPeliculasPulsado: (Int) -> Unit
) {
    LazyColumn(modifier = modifier) {
        items(respuesta.resultado) { starship ->
            Box(
                modifier = Modifier.padding(8.dp)
            ){
                Column(
                    modifier = Modifier.fillMaxWidth()
                ) {
                    Text(
                        text = stringResource(R.string.nombre_del_starship, starship.nombre)
                    )
                    Text(
                        text = stringResource(R.string.longitud, starship.longitud)
                    )
                    Text(
                        text = "Indice: ${respuesta.resultado.indexOf(starship)}"
                    )
                    Row(
                        modifier = Modifier.fillMaxWidth(),
                        horizontalArrangement = Arrangement.Center
                    ) {
                        Button(
                            onClick = { onBotonMostrarPeliculasPulsado(respuesta.resultado.indexOf(starship)) }
                        ) {
                            Text(
                                text = stringResource(R.string.mostrar_peliculas)
                            )
                        }
                    }
                }
            }
        }
    }
}