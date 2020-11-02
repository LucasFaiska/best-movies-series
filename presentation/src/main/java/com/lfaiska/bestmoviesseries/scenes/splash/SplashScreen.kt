package com.lfaiska.bestmoviesseries.scenes.splash

import androidx.compose.foundation.Text
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.preferredSize
import androidx.compose.material.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.ui.tooling.preview.Preview

@Composable
fun SplashScreen() {
    Scaffold {
        Text(text = "Splash Screen")
    }
}

@Preview
@Composable
fun PreviewSplashScreen() {
    SplashScreen()
}