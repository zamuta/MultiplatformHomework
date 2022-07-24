package com.example.multiplatformhomework.presenters

import com.example.multiplatformhomework.network.models.NewsInfo
import com.example.multiplatformhomework.network.models.NewsResponse
import com.example.multiplatformhomework.threads.*
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.SupervisorJob
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

typealias Handler = (Boolean) -> Unit

abstract class BasePaginationPresenter<IT, RT> {
    var handler: Handler? = null

    private val job = SupervisorJob()
    private val scope = CoroutineScope(uiDispatcher + job)

    var isLoading = false
        private set
    var page: Int = 0
        private set
    var total: Int = Int.MAX_VALUE
        private set

    var items = mutableListOf<IT>()
        private set

    internal abstract suspend fun responce(): Result<RT>
    internal abstract fun prepare(data: RT): Triple<Int, Int, List<IT>>?

    fun fetchNext() {
        if (isLoading) return
        isLoading = true

        scope.launch {
            val result =
                withContext(ioDispatcher) {
                    try {
                        responce()
                    } catch (e: Exception) {
                        null
                    }
                }
            if (result != null && result.isSuccess) {
                result.getOrNull()?.let {
                    val triple = prepare(it)
                    if (triple != null) {
                        page = triple.first
                        total = triple.second
                        items.addAll(triple.third)
                    }
                }
            }
            isLoading = false
            if (handler != null) {
                handler?.let {
                    if (result != null) {
                        it(result.isSuccess)
                    } else {
                        it(false)
                    }
                }
            }
        }
    }
}
