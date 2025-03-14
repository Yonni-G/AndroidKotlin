package com.example.tp_fil_rouge.navigation




sealed class Screens(val route: String) {

    object Login: Screens("login_screen")
    object ArticlesListe: Screens("articles_liste_screen")
    object Register: Screens("register_screen")
    object ForgottenPassword: Screens("forgotten_password_screen")

}