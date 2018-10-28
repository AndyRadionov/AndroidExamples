package andyradionov.github.io.googlenews.data

import andyradionov.github.io.googlenews.data.entities.NewsResponse
import kotlinx.coroutines.experimental.Deferred

/**
 * @author Andrey Radionov
 */
class NewsRepository(private val newsApi: NewsApi) {

    fun fetchNews(query: String): Deferred<NewsResponse> {

        if (query.isEmpty()) {
            return newsApi.getTopNews()
        } else {
            return newsApi.searchNews(query)
        }
    }
}
