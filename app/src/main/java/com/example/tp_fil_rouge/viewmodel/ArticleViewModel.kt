import androidx.lifecycle.ViewModel
import com.example.tp_fil_rouge.data.Article
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow

class ArticleViewModel(private val repository: ArticleRepository) : ViewModel() {
    // Créer un MutableStateFlow pour la liste des articles
    private val _articles = MutableStateFlow<List<Article>>(emptyList())  // Liste vide au début
    val articles: StateFlow<List<Article>> = _articles  // Exposer la liste en lecture seule

    init { loadArticles() }

    // Simule la récupération des articles
    private fun loadArticles() {

        _articles.value = repository.getArticles()


    }

    fun addArticle() {
        val article = Article("NOUVEAU", "Description 4", "https://picsum.photos/200/300")
        _articles.value += article
    }

}