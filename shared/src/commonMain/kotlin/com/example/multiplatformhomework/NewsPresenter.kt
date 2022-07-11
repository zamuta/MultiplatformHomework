package com.example.multiplatformhomework

import com.example.multiplatformhomework.threads.ioDispatcher
import com.example.multiplatformhomework.threads.uiDispatcher
import kotlinx.coroutines.*
import org.openapitools.client.apis.*
import org.openapitools.client.models.*

typealias Handler = (Int) -> Unit

class NewsPresenter {
    // itV4cbFUXsuNfzGubDIN2nGnaOPFxs6H0Pl0Cxc0
    // zoF0vLrnZn9v8owS6Ev4xxsOUUG4SWMA62JZvGbG
    // jHOR9GuzkO8cghjEDTHtQGddUhJL9FvMYDx8Gx3s
    val apiToken = "jHOR9GuzkO8cghjEDTHtQGddUhJL9FvMYDx8Gx3s"

    var handler: Handler? = null

    private val job = SupervisorJob()
    private val scope = CoroutineScope(uiDispatcher + job)
    private val api = NewsApi()

    var isLoading = false
        private set
    var page: Int = 0
        private set
    var total: Int = Int.MAX_VALUE
        private set

    var news = mutableListOf<NewsInfo>()
        private set

    fun fetchNext() {
        if (isLoading) return
        isLoading = true

        scope.launch {
            val result =
                withContext(ioDispatcher) {
                try {
                    // В бесплатной версии апишки ограничение на limit 5
                    api.newsAllGet(apiToken = apiToken, limit = 5, page = page + 1, search = "tesla", language = "en")
                } catch (e: Exception) {
                    null
                }
            }
            if (result != null && result.success && result.body() != null) {
                var _meta = result.body().meta
                var _news = result.body().data
                if (_meta != null && _news != null) {
                    page = _meta.page
                    total = _meta.found
                    news.addAll(_news)
                }
            }
            isLoading = false
            if (handler != null) {
                handler?.let {
                    if (result != null) {
                        it(result.status)
                    } else {
                        it(0)
                    }
                }
            }
        }
    }
}
