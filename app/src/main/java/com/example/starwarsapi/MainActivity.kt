package com.example.starwarsapi

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import com.example.starwarsapi.ui.screens.StarWarsApp
import com.example.starwarsapi.ui.theme.StarWarsAPITheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            StarWarsAPITheme {
                StarWarsApp()
            }
        }
    }
}
