package com.example.startservice

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Composable
fun ServiceControllScreen(
    onStartClick: () -> Unit,
    onStopClick: () -> Unit
) {
    Box(
        contentAlignment = Alignment.Center,
        modifier = Modifier.fillMaxSize()
    ) {
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            Button(
                onClick = onStartClick,
                modifier = Modifier.padding(16.dp)
            ) {
                Text("Iniciar Serviço")
            }
            Button(
                onClick = onStopClick,
                modifier = Modifier.padding(16.dp)
            ) {
                Text("Finalizar Serviço")
            }
        }
    }
}

@Preview
@Composable
fun See() {
    ServiceControllScreen(onStartClick = {}, onStopClick = {})
}