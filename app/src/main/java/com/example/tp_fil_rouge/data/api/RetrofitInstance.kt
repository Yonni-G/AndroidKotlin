package com.example.tp_fil_rouge.data.api

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitInstance {
    val api: ArticleApi by lazy {
        Retrofit.Builder()
            .baseUrl("http://10.0.2.2:3000/") // Pour un serveur local sur l’émulateur
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(ArticleApi::class.java)
    }
}
