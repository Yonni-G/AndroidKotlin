package com.example.tp_fil_rouge.data.api

import com.example.tp_fil_rouge.data.ArticleResponse
import retrofit2.http.GET

interface ArticleApi {
    @GET("articles")
    suspend fun getArticles(): ArticleResponse  // Retourne un ArticleResponse
}
