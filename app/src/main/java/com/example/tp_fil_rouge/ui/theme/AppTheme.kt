package com.example.tp_fil_rouge.ui.theme

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Button
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.tp_fil_rouge.R

@Composable
fun MyPage(content: @Composable () -> Unit) {
    TP_FIL_ROUGETheme {
        Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
            Box(modifier = Modifier.padding(innerPadding)) {
                Image(
                    painter = painterResource(R.drawable.background), // Assure-toi que l'image est bien dans res/drawable
                    contentDescription = null,
                    contentScale = ContentScale.Crop,
                    modifier = Modifier.fillMaxSize()
                )
                Column(
                    modifier = Modifier
                        .fillMaxSize()
                        .padding(16.dp),

                    ) {
                    content()
                }
            }
        }
    }

}

@Composable
fun MyWrapPadding(content: @Composable () -> Unit) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(10.dp)
    ) {
        content()
    }
}

@Composable
fun MyTextField(
    modifier: Modifier = Modifier,
    title: String,
    label: String,
    icon: ImageVector? = null
) {
    TextField(
        value = "",
        onValueChange = {},
        placeholder = {
            Text(text = title)
        },
        modifier = modifier.fillMaxWidth(),
        colors = TextFieldDefaults.colors(
            unfocusedContainerColor = Color(0x66FFFFFF), // Fond semi-transparent bleu-gris
            focusedContainerColor = Color(0xAAFFFFFF), // Bleu plus intense
            unfocusedIndicatorColor = Color.Transparent,
            focusedIndicatorColor = Color.Transparent
        ),
        leadingIcon = if (icon != null) {
            { Icon(imageVector = icon, contentDescription = "Icône $label", tint = Color.White) }
        } else null

    )
}

@Composable
fun MyButton(modifier: Modifier = Modifier, title: String, onClick: () -> Unit) {
    Button(
        onClick = onClick,
        modifier = modifier.fillMaxWidth()
    ) {
        Text(text = title)
    }
}
@Composable
fun MyHeader(title: String, icon: ImageVector? = null) {

    Column(
        modifier = Modifier.fillMaxWidth(), // Utilise un Column pour empiler l'image et le texte
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        if(icon != null) {
            Icon(
                imageVector = icon,
                modifier = Modifier.size(96.dp),
                contentDescription = "",
                tint = Color.White
            )
        }

        Spacer(modifier = Modifier.height(16.dp)) // Ajoute de l'espace entre l'image et le texte

        // Texte avec bordure et fond semi-transparent
        MyWrapPadding {
            Box(
                modifier = Modifier
                    .border(1.dp, Color.Gray) // Applique une bordure autour du texte
                    .padding(8.dp) // Optionnel, pour espacer le texte de la bordure
                    .background(Color.White.copy(alpha = 0.2f)) // Arrière-plan semi-transparent
                    .fillMaxWidth()
            ) {
                Text(
                    text = title,
                    style = TextStyle(
                        fontSize = 24.sp,
                        color = Color.Black
                    ) // Taille et couleur de texte
                )
            }
        }
    }
}
