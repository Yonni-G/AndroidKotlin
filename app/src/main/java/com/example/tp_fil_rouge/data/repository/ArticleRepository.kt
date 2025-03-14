package com.example.tp_fil_rouge.data.repository

import com.example.tp_fil_rouge.data.ArticleResponse
import com.example.tp_fil_rouge.data.api.RetrofitInstance

class ArticleRepository {

    // Méthode pour obtenir les articles directement via Retrofit (fonction suspendue)
    suspend fun getArticles(): ArticleResponse {
        return RetrofitInstance.api.getArticles()
    }
}
