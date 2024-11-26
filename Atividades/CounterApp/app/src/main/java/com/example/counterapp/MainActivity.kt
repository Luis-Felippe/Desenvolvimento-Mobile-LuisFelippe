package com.example.counterapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonColors
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextFieldColors
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.counterapp.ui.theme.Baquigroundi
import com.example.counterapp.ui.theme.CounterAppTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            CounterAppTheme {
                Surface(
                    modifier = Modifier.fillMaxSize()
                ) {
                    CounterApp()
                }


            }

        }
    }
}


    @Composable
    fun CounterApp() {


        var result by remember { mutableStateOf(0.0) }
        var input by remember { mutableStateOf("") }

        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier
                .fillMaxSize()
                .background(Color.Black)
                .padding(16.dp),
            verticalArrangement = Arrangement.Center
        ) {
            Text(
                text = "Resultado: $result",
                color = Color.White,
                fontSize = 24.sp,
                modifier = Modifier.padding(8.dp)
            )

            OutlinedTextField(
                value = input,
                onValueChange = { input = it },
                label = { Text("Digite um número", color = Color.White) },
                modifier = Modifier.fillMaxWidth(),
                colors = OutlinedTextFieldDefaults.colors(unfocusedTextColor = Color.White,
                    focusedTextColor = Color.White)
            )

            Spacer(modifier = Modifier.height(16.dp))


            Row(
                horizontalArrangement = Arrangement.spacedBy(8.dp),
                modifier = Modifier.fillMaxWidth()
            ) {
                Button(
                    onClick = {
                        result += input.toDoubleOrNull()
                            ?: 0.0
                        input = ""
                    },
                    colors = ButtonDefaults.buttonColors(containerColor = Baquigroundi),
                    modifier = Modifier.weight(1f)
                ) {
                    Text("Incrementar", color = Color.White)
                }

                Button(
                    onClick = {
                        result -= input.toDoubleOrNull() ?: 0.0
                        input = ""
                    },
                    colors = ButtonDefaults.buttonColors(containerColor = Baquigroundi),
                    modifier = Modifier.weight(1f)
                ) {
                    Text("Decrementar", color = Color.White)
                }
            }


            Row(
                horizontalArrangement = Arrangement.spacedBy(8.dp),
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = 8.dp)
            ) {
                Button(
                    onClick = {
                        result *= input.toDoubleOrNull()
                            ?: 1.0
                        input = ""
                    },
                    colors = ButtonDefaults.buttonColors(containerColor = Baquigroundi),
                    modifier = Modifier.weight(1f)
                ) {
                    Text("Multiplicar", color = Color.White)
                }

                Button(
                    onClick = {
                        val value = input.toDoubleOrNull() ?: 1.0
                        if (value != 0.0) {
                            result /= value
                        }
                        input = ""
                    },
                    colors = ButtonDefaults.buttonColors(containerColor = Baquigroundi),
                    modifier = Modifier.weight(1f)
                ) {
                    Text("Dividir", color = Color.White)
                }
            }

            Spacer(modifier = Modifier.height(16.dp))


            Button(
                onClick = {
                    result = 0.0
                    input = ""
                },
                colors = ButtonDefaults.buttonColors(containerColor = Baquigroundi),
                modifier = Modifier.fillMaxWidth() //
            ) {
                Text("Limpar", color = Color.White)
            }
        }

    }


    @Preview(showBackground = true)
    @Composable
    fun CounterAppPreview() {
        CounterAppTheme {
            CounterApp()
        }
    }
