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
fun MenuScreen(navController: NavController) {

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
                text = "Menu",
                style = MaterialTheme.typography.headlineMedium
            )

            Button(
                onClick = { navController.navigate("imc") }
            ) {
                Text("Cálculo de IMC")
            }

            Button(
                onClick = { navController.navigate("equipe") }
            ) {
                Text("Equipe")
            }

            Button(
                onClick = {
                    navController.navigate("login") {
                        popUpTo("login") { inclusive = true }
                    }
                }
            ) {
                Text("Voltar para Login")
            }
        }
    }
}
