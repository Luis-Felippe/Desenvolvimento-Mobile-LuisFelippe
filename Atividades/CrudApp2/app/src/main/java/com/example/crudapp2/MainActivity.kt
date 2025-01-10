package com.example.crudapp2

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.activity.viewModels
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Button
import androidx.compose.material3.Divider
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.crudapp2.ui.theme.CrudApp2Theme

class MainActivity : ComponentActivity() {

    private val viewModel : UserViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            CrudApp2Theme {
                UserApp(viewModel)
            }
        }
    }

    @SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
    @OptIn(ExperimentalMaterial3Api::class)
    @Composable
    fun UserApp(viewModel: UserViewModel){
        val usuarios by viewModel.users.observeAsState(emptyList())
        var nome by remember { mutableStateOf("") }
        var idade by remember { mutableStateOf("") }
        var usuariosEditando by remember { mutableStateOf<User?>(null) }
        var mensagemErro by remember { mutableStateOf<String?>(null) }

        Scaffold(
            topBar = {
                TopAppBar(
                    title = { Text("Gerenciamento de usuários") }
                )
            }
        ) {
            Column(
                modifier = Modifier.fillMaxSize()
                    .padding(16.dp)
            ) {
                Text( if(usuariosEditando == null ) "adicionar novo usuário" else "Editando usuario",
                    fontWeight = FontWeight.Bold,
                    fontSize = 20.sp,
                    modifier = Modifier.fillMaxWidth()
                    )

                Spacer(modifier = Modifier.height(8.dp))

                OutlinedTextField(
                    value = idade,
                    onValueChange = {idade = it},
                    label = { Text("idade") },
                    modifier =  Modifier.fillMaxWidth(),
                    keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number)
                )
                Spacer(modifier = Modifier.height(16.dp))

                Button(
                    onClick = {
                        try {
                            if(nome.isNotEmpty() && idade.isNotEmpty()){
                                val idadeInt = idade.toInt()
                                if(usuariosEditando == null){
                                    viewModel.addUser(User(name = nome, age = idadeInt))
                                }
                                else{
                                    viewModel.updateUser(usuariosEditando!!.copy(name = nome, age = idadeInt))
                                    usuariosEditando = null
                                }
                                nome = ""
                                idade = ""
                                mensagemErro = ""
                            }
                        }
                        catch (e: NumberFormatException){
                            mensagemErro = "Idade inválida"
                        }
                    },
                    modifier = Modifier.align(Alignment.CenterHorizontally)
                ) {
                    Text(if(usuariosEditando == null) "Adicionar usuário" else "Salvar alteração")
                }
                mensagemErro?.let{
                    Spacer(modifier = Modifier.height(16.dp))
                    Text(it,
                        color = Color.Red,
                        modifier = Modifier.align(Alignment.CenterHorizontally))
                }
                Spacer(modifier = Modifier.height(16.dp))
                Divider(color = Color.Gray, thickness = 1.dp)
            }
        }

    }

}

