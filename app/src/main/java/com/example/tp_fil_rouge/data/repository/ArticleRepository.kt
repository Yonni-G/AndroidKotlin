import com.example.tp_fil_rouge.data.Article

class ArticleRepository {
    fun getArticles(): List<Article> {
        return listOf(
            Article("Titre 1", "Description 1", "https://picsum.photos/250/300"),
            Article("Titre 2", "Description 2", "https://picsum.photos/210/300"),
            Article("Titre 3", "Description 3", "https://picsum.photos/200/300"),
        )
    }
}
