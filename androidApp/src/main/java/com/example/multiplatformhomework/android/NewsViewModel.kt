package com.example.multiplatformhomework.android

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.multiplatformhomework.presenters.NewsPresenter
import dagger.hilt.android.lifecycle.HiltViewModel
import com.example.multiplatformhomework.network.models.*
import javax.inject.Inject

@HiltViewModel
class NewsViewModel @Inject constructor() : ViewModel() {
    private val presenter: NewsPresenter
    init {
        val presenter = NewsPresenter()
        presenter.handler = {
            news.value = listOf() // Хак для вызова события обсервера
            news.value = presenter.items
        }
        this.presenter = presenter
    }

    val isLoading: Boolean
        get() { return this.presenter.isLoading }
    val page: Int
        get() { return this.presenter.page }
    val total: Int
        get() { return this.presenter.total }

    val news = MutableLiveData<List<NewsInfo>>()
    init {
        news.value = listOf()
    }

    fun fetchNext() {
        presenter.fetchNext()
    }
}
