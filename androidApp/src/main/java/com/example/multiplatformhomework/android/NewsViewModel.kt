package com.example.multiplatformhomework.android

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.multiplatformhomework.NewsPresenter
import dagger.hilt.android.lifecycle.HiltViewModel
import org.openapitools.client.models.NewsInfo
import javax.inject.Inject

@HiltViewModel
class NewsViewModel @Inject constructor() : ViewModel() {
    private val presenter: NewsPresenter
    init {
        val presenter = NewsPresenter()
        presenter.handler = {
            mNews.value = presenter.news
        }
        this.presenter = presenter
    }

    val isLoading: Boolean
        get() { return this.presenter.isLoading }
    val page: Int
        get() { return this.presenter.page }
    val total: Int
        get() { return this.presenter.total }

    private val mNews = MutableLiveData<List<NewsInfo>>()
    val news: LiveData<List<NewsInfo>>
        get() = mNews
    init {
        mNews.value = listOf()
    }

    fun fetchNext() {
        presenter.fetchNext()
    }
}
