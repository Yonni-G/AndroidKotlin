package com.example.tp_fil_rouge.screens

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import coil.compose.AsyncImage
import com.example.tp_fil_rouge.data.Article
import com.example.tp_fil_rouge.ui.theme.MyHeader
import com.example.tp_fil_rouge.ui.theme.MyPage
import com.example.tp_fil_rouge.viewmodel.ArticleViewModel

class ArticlesListeActivity : ComponentActivity() {
    private val viewModel: ArticleViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ArticlesListe(navController = rememberNavController(), viewModel = viewModel)
        }
    }
}

@Composable
fun ArticlesListe(navController: NavController, viewModel: ArticleViewModel = viewModel()) {
    // Utilise collectAsState pour collecter les données depuis le ViewModel
    val articles by viewModel.articles.collectAsState()

    // Lance fetchArticles lorsque la composable est activée
    LaunchedEffect(Unit) {
        viewModel.fetchArticles()
    }

    MyPage {
        Column(modifier = Modifier.fillMaxSize()) {
            MyHeader(title = "Liste des articles", icon = Icons.Filled.Menu)

            // Ajout d'un article
            Button(onClick = {
                viewModel.addArticle()
            }) { Text(text = "Ajouter un article") }

            // 🔹 Utilisation de LazyColumn pour le défilement
            LazyColumn(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(16.dp)
            ) {
                items(articles) { article ->
                    ArticleItem(article = article)
                }
            }
        }
    }
}

@Composable
fun ArticleItem(article: Article) {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(8.dp)
    ) {
        Text(text = article.title, modifier = Modifier.padding(bottom = 4.dp), color = Color.Black)
        Text(text = article.desc, modifier = Modifier.padding(bottom = 4.dp), color = Color.Gray)

        // ✅ Vérifie que l'image est bien chargée
        AsyncImage(
            model = article.imgPath,
            contentDescription = article.title,
            modifier = Modifier
                .fillMaxWidth()
                .height(150.dp)
                .padding(bottom = 8.dp),
            contentScale = ContentScale.Crop
        )
    }
}

@Preview(showBackground = true)
@Composable
fun ArticlesListePreview() {
    ArticlesListe(navController = rememberNavController())
}
