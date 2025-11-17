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
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import kotlin.math.pow
import java.util.Locale

@Composable
fun ImcScreen(navController: NavController) {

    val (nome, setNome) = remember { mutableStateOf("") }
    val (pesoTexto, setPesoTexto) = remember { mutableStateOf("") }
    val (alturaTexto, setAlturaTexto) = remember { mutableStateOf("") }
    val (resultado, setResultado) = remember { mutableStateOf<String?>(null) }
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
                text = "Calculadora de IMC",
                style = MaterialTheme.typography.headlineMedium
            )

            OutlinedTextField(
                value = nome,
                onValueChange = { setNome(it) },
                label = { Text("Seu nome") },
                singleLine = true
            )

            OutlinedTextField(
                value = pesoTexto,
                onValueChange = { setPesoTexto(it) },
                label = { Text("Seu peso (kg)") },
                singleLine = true
            )

            OutlinedTextField(
                value = alturaTexto,
                onValueChange = { setAlturaTexto(it) },
                label = { Text("Sua altura (m)") },
                singleLine = true
            )

            if (mensagemErro != null) {
                Text(
                    text = mensagemErro!!,
                    color = MaterialTheme.colorScheme.error
                )
            }

            Button(
                onClick = {
                    // aceita vírgula ou ponto
                    val peso = pesoTexto.replace(",", ".")
                        .toDoubleOrNull()
                    val altura = alturaTexto.replace(",", ".")
                        .toDoubleOrNull()

                    if (peso == null || altura == null || altura == 0.0) {
                        setResultado(null)
                        setMensagemErro("Preencha peso e altura corretamente.")
                    } else {
                        val imc = peso / altura.pow(2)
                        val imcFormatado = String.format(
                            Locale.getDefault(),
                            "%.2f",
                            imc
                        )
                        val nomeExibicao = if (nome.isBlank()) "Usuário" else nome
                        setMensagemErro(null)
                        setResultado("Olá, $nomeExibicao! Seu IMC é $imcFormatado.")
                    }
                }
            ) {
                Text("Calcular")
            }

            if (resultado != null) {
                Text(
                    text = resultado!!,
                    style = MaterialTheme.typography.titleMedium
                )
            }

            Spacer(modifier = Modifier.height(8.dp))

            Button(
                onClick = { navController.navigate("menu") }
            ) {
                Text("Voltar para o Menu")
            }
        }
    }
}
