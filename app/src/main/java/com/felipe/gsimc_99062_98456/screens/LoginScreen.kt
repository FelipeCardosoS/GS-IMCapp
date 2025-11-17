package com.felipe.gsimc_99062_98456.screens

import androidx.compose.foundation.layout.*
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController

@Composable
fun LoginScreen(navController: NavController) {

    val usuarioCorreto = "admin"
    val senhaCorreta = "123456"

    val (usuario, setUsuario) = remember { mutableStateOf("") }
    val (senha, setSenha) = remember { mutableStateOf("") }
    val (mensagemErro, setMensagemErro) = remember { mutableStateOf<String?>(null) }

    Box(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        contentAlignment = Alignment.Center
    ) {

        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.spacedBy(12.dp)
        ) {
            Text(
                text = "Login",
                style = MaterialTheme.typography.headlineMedium
            )

            OutlinedTextField(
                value = usuario,
                onValueChange = { setUsuario(it) },
                label = { Text("Usuário") },
                singleLine = true
            )

            OutlinedTextField(
                value = senha,
                onValueChange = { setSenha(it) },
                label = { Text("Senha") },
                singleLine = true,
                visualTransformation = PasswordVisualTransformation()
            )

            if (mensagemErro != null) {
                Text(
                    text = mensagemErro!!,
                    color = MaterialTheme.colorScheme.error
                )
            }

            Button(
                onClick = {
                    if (usuario == usuarioCorreto && senha == senhaCorreta) {
                        setMensagemErro(null)
                        navController.navigate("menu") {
                            popUpTo("login") { inclusive = true }
                        }
                    } else {
                        setMensagemErro("Usuário inválido")
                    }
                }
            ) {
                Text("Entrar")
            }
        }
    }
}
