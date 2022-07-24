package com.example.multiplatformhomework.presenters

import com.example.multiplatformhomework.DependencyInjection
import com.example.multiplatformhomework.network.models.*

class NewsPresenter: BasePaginationPresenter<NewsInfo, NewsResponse>() {
    private val api = DependencyInjection.newsApi

    override suspend fun responce(): Result<NewsResponse> {
        // В бесплатной версии апишки ограничение на limit 5
        return api.newsAllGet(limit = 5, page = page + 1)
    }

    override fun prepare(data: NewsResponse): Triple<Int, Int, List<NewsInfo>>? {
        var _meta = data.meta
        var _news = data.data
        if (_meta != null && _news != null) {
            return Triple(_meta.page, _meta.found, _news)
        }
        return null
    }
}
