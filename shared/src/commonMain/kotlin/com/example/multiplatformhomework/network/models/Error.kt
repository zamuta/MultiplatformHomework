package com.example.multiplatformhomework.network.models

import kotlinx.serialization.*

@Serializable
data class Error(
    @Required val message: kotlin.String,
    @Required val code: kotlin.Int
)
