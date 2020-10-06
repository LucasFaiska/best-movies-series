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
        Row {
            Box(
                modifier = Modifier.preferredSize(100.dp, 100.dp),
            )
            Box(
                modifier = Modifier.preferredSize(100.dp, 100.dp),
            )
            Box(
                modifier = Modifier.preferredSize(100.dp, 100.dp),
            )
            Text(text = "Splash Screen 1")
        }
    }
}

@Preview
@Composable
fun PreviewSplashScreen() {
    SplashScreen()
}