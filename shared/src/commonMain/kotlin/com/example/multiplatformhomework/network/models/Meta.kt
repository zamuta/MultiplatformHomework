package com.example.multiplatformhomework.network.models

import kotlinx.serialization.*

@Serializable
data class Meta(
    @Required val found: kotlin.Int,
    @Required val returned: kotlin.Int,
    @Required val limit: kotlin.Int,
    @Required val page: kotlin.Int
)
