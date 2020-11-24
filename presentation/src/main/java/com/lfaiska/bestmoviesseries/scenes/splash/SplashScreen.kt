package com.lfaiska.bestmoviesseries.scenes.splash

import androidx.compose.foundation.Image
import androidx.compose.foundation.Text
import androidx.compose.foundation.layout.*
import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.unit.dp
import androidx.ui.tooling.preview.Preview
import com.lfaiska.bestmoviesseries.R

@Composable
fun SplashScreen() {
    // Criar theme
    // Background
    // Colors
    // Mudar cor imagem
    // App name on front?
    // Animation?
    MaterialTheme {
        Column(
            modifier = Modifier.fillMaxSize(),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally,
        ) {
            val image = vectorResource(id = R.drawable.ic_two_photograms)

            val imageModifier = Modifier
                .preferredHeight(250.dp)
                .fillMaxWidth()

            Image(image, modifier = imageModifier)
            // Criar estilo pra essa fonte
            Text("Best Movies and Series App")
        }
    }
}

@Preview(showDecoration = true, showBackground = true)
@Composable
fun PreviewSplashScreen() {
    SplashScreen()
}