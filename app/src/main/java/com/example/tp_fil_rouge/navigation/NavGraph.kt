package com.example.tp_fil_rouge.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.tp_fil_rouge.screens.Login
import com.example.tp_fil_rouge.screens.ArticlesListe
import com.example.tp_fil_rouge.screens.Register
import com.example.tp_fil_rouge.screens.ForgottenPassword

@Composable
fun NavGraph(navController: NavHostController) {
    // Ici, on associe le NavController à un NavHost
    NavHost(navController = navController, startDestination = Screens.Login.route) {
        composable(route = Screens.Login.route) {
            Login(navController = navController)
        }
        composable(route = Screens.ArticlesListe.route) {
            ArticlesListe(navController = navController)
        }
        composable(route = Screens.Register.route) {
            Register(navController = navController)
        }
        composable(route = Screens.ForgottenPassword.route) {
            ForgottenPassword(navController = navController)
        }
    }
}
