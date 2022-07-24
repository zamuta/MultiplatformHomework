package com.example.multiplatformhomework

import com.example.multiplatformhomework.network.NetworkClient
import com.example.multiplatformhomework.network.NetworkConfig
import com.example.multiplatformhomework.network.apis.*
import kotlin.native.concurrent.ThreadLocal

@ThreadLocal
object DependencyInjection {
    val networkClient: NetworkClient by lazy { NetworkClient() }
    val networkConfig: NetworkConfig by lazy { NetworkConfig.shared }
    val newsApi: NewsApi by lazy { NewsApi(networkClient, networkConfig) }
}