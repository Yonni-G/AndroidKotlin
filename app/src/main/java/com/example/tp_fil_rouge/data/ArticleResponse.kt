package com.example.tp_fil_rouge.data

data class ArticleResponse(
    val code: String,  // code de la réponse
    val message: String, // message de réponse
    val data: List<Article> // Liste des articles
)
