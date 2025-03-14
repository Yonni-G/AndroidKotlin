package com.example.tp_fil_rouge.screens

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountCircle
import androidx.compose.material.icons.rounded.Email
import androidx.compose.material.icons.rounded.Lock
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Shadow
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.tp_fil_rouge.R
import com.example.tp_fil_rouge.navigation.Screens
import com.example.tp_fil_rouge.ui.theme.MyButton
import com.example.tp_fil_rouge.ui.theme.MyHeader
import com.example.tp_fil_rouge.ui.theme.MyPage
import com.example.tp_fil_rouge.ui.theme.MyTextField
import com.example.tp_fil_rouge.ui.theme.MyWrapPadding

class LoginActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {

        }
    }
}

@Composable
fun Login(navController: NavController) {

    MyPage {
        Column {

            MyHeader(
                title = "Soyez assuré d'être seul lorsque vous remplissez ce formulaire",
                icon = Icons.Default.AccountCircle
            )
            MyWrapPadding {
                MyTextField(
                    title = stringResource(R.string.app_field_email_hint),
                    label = "email",
                    icon = Icons.Rounded.Email
                )
            }
            MyWrapPadding {
                MyTextField(
                    title = stringResource(R.string.app_field_password_hint),
                    label = "password",
                    icon = Icons.Rounded.Lock
                )
            }
            MyWrapPadding {
                MyButton(
                    title = stringResource(R.string.app_btn_connection),
                    onClick = { navController.navigate("login_screen") })
            }
            MyWrapPadding {
                Text(
                    text = stringResource(R.string.app_msg_password_forgotten),
                    style = TextStyle(
                        shadow = Shadow(
                            color = Color(0xFFFFFFFF),
                            offset = Offset(0f, 0f),
                            blurRadius = 5f
                        )
                    )
                )
            }


            Spacer(modifier = Modifier.weight(1f))
            MyWrapPadding {
                Text(
                    text = stringResource(R.string.app_msg_ask_have_account),
                    modifier = Modifier.fillMaxWidth(),
                    textAlign = TextAlign.Center,
                    fontStyle = FontStyle.Italic
                )
            }
            MyWrapPadding {
                MyButton(title = stringResource(R.string.app_btn_create_account), onClick = { navController.navigate("register_screen") })
            }
        }

    }
}

@Preview(showBackground = true)
@Composable
fun LoginPreview() {
    Login(navController = rememberNavController())
}