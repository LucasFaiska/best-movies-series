package com.lfaiska.bestmoviesseries.scenes.home

import androidx.compose.foundation.Text
import androidx.compose.foundation.layout.*
import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.ui.tooling.preview.Preview

@Composable
fun HomeScreen() {
    MaterialTheme {
        Column(
            modifier = Modifier.fillMaxSize(),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally,
        ) {
            Text("Home")
        }
    }
}

@Preview(showDecoration = true, showBackground = true)
@Composable
fun PreviewHomeScreen() {
    HomeScreen()
}