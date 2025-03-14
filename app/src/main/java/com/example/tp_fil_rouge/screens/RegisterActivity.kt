package com.example.tp_fil_rouge.screens

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Column

import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountBox
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.tp_fil_rouge.navigation.Screens
import com.example.tp_fil_rouge.ui.theme.MyButton
import com.example.tp_fil_rouge.ui.theme.MyHeader
import com.example.tp_fil_rouge.ui.theme.MyPage
import com.example.tp_fil_rouge.ui.theme.MyTextField
import com.example.tp_fil_rouge.ui.theme.MyWrapPadding

class RegisterActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {

        }
    }
}

@Composable
fun Register(navController: NavController) {
    MyPage {
        Column(modifier = Modifier.verticalScroll(rememberScrollState())) {

            MyHeader(title = "Bienvenue sur la page d'inscription", icon = Icons.Default.AccountBox)

            MyWrapPadding {
                MyTextField(
                    title = "Pseudo",
                    label = "pseudo",
                )
            }
            MyWrapPadding {
                MyTextField(
                    title = "Email",
                    label = "email",
                )
            }
            MyWrapPadding {
                MyTextField(
                    title = "Password",
                    label = "password",
                )
            }
            MyWrapPadding {
                MyTextField(
                    title = "Confirmation password",
                    label = "passwor confirmation",
                )
            }
            MyWrapPadding {
                MyTextField(
                    title = "Code postal",
                    label = "code postal",
                )
            }
            MyWrapPadding {
                MyTextField(
                    title = "Ville",
                    label = "ville",
                )
            }
            MyWrapPadding {
                MyTextField(
                    title = "Téléphone",
                    label = "telephone",
                )
            }



            MyWrapPadding {
                MyButton(title = "S'inscrire", onClick = { navController.navigate("articles_liste_screen") })
            }



            Spacer(modifier = Modifier.weight(1f))
            MyWrapPadding {
                Text(
                    text = "En m'enregistrant, j'accepte les CGV",
                    modifier = Modifier.fillMaxWidth(),
                    textAlign = TextAlign.Center
                )
            }

        }

    }
}

@Preview(showBackground = true)
@Composable
fun RegisterPreview() {
    Register(navController = rememberNavController())
}