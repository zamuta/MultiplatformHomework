package com.example.multiplatformhomework.network.models

import kotlinx.serialization.*

@Serializable
data class NewsInfo(
    @Required val uuid: kotlin.String,
    @Required val title: kotlin.String,
    @Required val description: kotlin.String,
    @Required val url: kotlin.String,
    @Required val source: kotlin.String,
    val imageUrl: kotlin.String? = null,
    val language: kotlin.String? = null,
    val publishedAt: kotlin.String? = null,
    val categories: kotlin.collections.List<kotlin.String>? = null
)

