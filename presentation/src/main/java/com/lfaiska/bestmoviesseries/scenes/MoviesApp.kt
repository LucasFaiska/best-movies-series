package com.lfaiska.bestmoviesseries.scenes

import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.ui.tooling.preview.Preview
import com.lfaiska.bestmoviesseries.scenes.splash.SplashScreen

@Composable
fun MoviesApp() {
    MaterialTheme {
        //@TODO
        // Full screen
        // Background Image
        // App name on front
        // Animation?
        SplashScreen()
    }
}

@Preview(showDecoration = true, showBackground = true)
@Composable
fun PreviewMoviesApp() {
    MoviesApp()
}