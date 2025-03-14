package com.example.tp_fil_rouge.screens

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.foundation.layout.Column

import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.sharp.Email
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

class ForgottenPasswordActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {

        }
    }
}

@Composable
fun ForgottenPassword(navController: NavController) {
    MyPage {
        Column {
            Spacer(modifier = Modifier.weight(1f))
            MyHeader(title = "Récupération du mot de passe")

            MyWrapPadding {
                MyTextField(
                    title = "Email",
                    label = "email",
                    icon = Icons.Sharp.Email
                )
            }

            MyWrapPadding {
                MyButton(title = "Envoyer le lien de récupération", onClick = {
                    navController.navigate(
                        "forgotten_password_screen"
                    )
                })
            }



            Spacer(modifier = Modifier.weight(1f))
            MyWrapPadding {
                Text(
                    text = "N'oublie pas ton mot de passe la prochaine fois ! Dude !",
                    modifier = Modifier.fillMaxWidth(),
                    textAlign = TextAlign.Center
                )
            }

        }

    }
}

@Preview(showBackground = true)
@Composable
fun ForgottenPasswordPreview() {
    ForgottenPassword(navController = rememberNavController())
}