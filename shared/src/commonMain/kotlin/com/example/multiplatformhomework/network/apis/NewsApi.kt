package com.example.multiplatformhomework.network.apis

import com.example.multiplatformhomework.network.NetworkClient
import com.example.multiplatformhomework.network.NetworkConfig
import com.example.multiplatformhomework.network.models.*

class NewsApi constructor(
    private val networkClient: NetworkClient,
    private val networkConfig: NetworkConfig
) {
    suspend fun newsAllGet(limit: Int, page: Int): Result<NewsResponse> {
        val path = "${networkConfig.apiUrl}/news/all?api_token=${networkConfig.apiToken}&language=en&page=${page}&limit=${limit}"
        return networkClient.getData<NewsResponse>(path)
    }
}