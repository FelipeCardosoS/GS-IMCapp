package com.felipe.gsimc_99062_98456.screens

import androidx.compose.foundation.layout.*
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController

@Composable
fun EquipeScreen(navController: NavController) {

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
                text = "Equipe",
                style = MaterialTheme.typography.headlineMedium
            )

            // SUBSTITUA PELOS NOMES E RMs REAIS
            Text("Integrantes:")
            Text("Felipe Cardoso - RM 99062")
            Text("Carlos Augusto - RM 98456")

            Spacer(modifier = Modifier.height(16.dp))

            Button(
                onClick = { navController.navigate("menu") }
            ) {
                Text("Voltar para o Menu")
            }
        }
    }
}
