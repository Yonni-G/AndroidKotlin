package com.example.tp_fil_rouge

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.material3.Surface
import androidx.navigation.compose.rememberNavController
import com.example.tp_fil_rouge.navigation.NavGraph
import com.example.tp_fil_rouge.ui.theme.TP_FIL_ROUGETheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            TP_FIL_ROUGETheme {
                Surface {
                    // Crée le NavController ici
                    val navController = rememberNavController()

                    // Passe le navController à ton NavGraph
                    NavGraph(navController = navController)
                }
            }
        }
    }
}
