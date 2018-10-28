package andyradionov.github.io.googlenews.data

import andyradionov.github.io.googlenews.app.SEARCH_NEWS_REQUEST
import andyradionov.github.io.googlenews.app.TOP_NEWS_REQUEST
import andyradionov.github.io.googlenews.data.entities.NewsResponse
import io.reactivex.Observable
import kotlinx.coroutines.experimental.Deferred
import retrofit2.http.GET
import retrofit2.http.Query

/**
 * @author Andrey Radionov
 */
interface NewsApi {

    @GET(TOP_NEWS_REQUEST)
    fun getTopNews(): Deferred<NewsResponse>

    @GET(SEARCH_NEWS_REQUEST)
    fun searchNews(@Query("q") query: String): Deferred<NewsResponse>

}