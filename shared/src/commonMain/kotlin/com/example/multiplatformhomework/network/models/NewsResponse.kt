package com.example.multiplatformhomework.network.models

import kotlinx.serialization.*

@Serializable
data class NewsResponse(
    val meta: Meta? = null,
    val data: kotlin.collections.List<NewsInfo>? = null
)