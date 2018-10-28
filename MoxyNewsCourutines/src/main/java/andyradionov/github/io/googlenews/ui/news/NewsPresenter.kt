package andyradionov.github.io.googlenews.ui.news

import andyradionov.github.io.googlenews.data.NewsRepository
import andyradionov.github.io.googlenews.data.entities.NewsResponse
import com.arellomobile.mvp.InjectViewState
import com.arellomobile.mvp.MvpPresenter
import kotlinx.coroutines.experimental.Deferred
import kotlinx.coroutines.experimental.Dispatchers
import kotlinx.coroutines.experimental.GlobalScope
import kotlinx.coroutines.experimental.launch

/**
 * @author Andrey Radionov
 */
@InjectViewState
class NewsPresenter(private val newsRepository: NewsRepository) :
        MvpPresenter<NewsView>() {

    private var subscription: Deferred<NewsResponse>? = null

    fun fetchNews(query: String) {
        unsubscribe()

        GlobalScope.launch(Dispatchers.Main) {
            subscription = newsRepository.fetchNews(query)
            val response = subscription?.await()
            response?.let {
                if (response.articles.isNotEmpty()) {
                    viewState.showNews(response.articles)
                } else {
                    viewState.showError()
                }
            }
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        unsubscribe()
    }

    fun unsubscribe() {
        subscription?.cancel()
    }
}