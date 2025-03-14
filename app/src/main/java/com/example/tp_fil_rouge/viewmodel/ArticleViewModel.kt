package com.example.tp_fil_rouge.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.tp_fil_rouge.data.Article
import com.example.tp_fil_rouge.data.repository.ArticleRepository
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

class ArticleViewModel : ViewModel() {
    // Utilisation de StateFlow au lieu de LiveData
    private val _articles = MutableStateFlow<List<Article>>(emptyList())
    val articles: StateFlow<List<Article>> = _articles

    private val repository = ArticleRepository()

    init {
        fetchArticles()
    }

    // Fonction pour récupérer les articles depuis l'API
    fun fetchArticles() {
        // Lancement de la coroutine pour appeler la fonction suspendue
        viewModelScope.launch {
            try {
                // Appel à la méthode suspendue
                val response = repository.getArticles()

                // Vérifie la réponse et met à jour les articles
                if (response.code == "200") {
                    _articles.value = response.data
                } else {
                    println("Erreur: ${response.message}")
                }
            } catch (e: Exception) {
                e.printStackTrace()
                // Gestion de l'exception si une erreur se produit
            }
        }
    }

    // Exemple de fonction pour ajouter un article (si nécessaire)
    fun addArticle() {
        // Implémentation de l'ajout d'article si besoin
    }
}
