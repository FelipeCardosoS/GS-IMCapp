package com.felipe.gsimc_99062_98456

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.felipe.gsimc_99062_98456.screens.EquipeScreen
import com.felipe.gsimc_99062_98456.screens.ImcScreen
import com.felipe.gsimc_99062_98456.screens.LoginScreen
import com.felipe.gsimc_99062_98456.screens.MenuScreen

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Gs2ImcApp()
        }
    }
}

@Composable
fun Gs2ImcApp() {
    val navController = rememberNavController()

    MaterialTheme {
        Scaffold { innerPadding ->
            NavHost(
                navController = navController,
                startDestination = "login",
                modifier = Modifier.padding(innerPadding)
            ) {
                composable("login") {
                    LoginScreen(navController = navController)
                }
                composable("menu") {
                    MenuScreen(navController = navController)
                }
                composable("imc") {
                    ImcScreen(navController = navController)
                }
                composable("equipe") {
                    EquipeScreen(navController = navController)
                }
            }
        }
    }
}