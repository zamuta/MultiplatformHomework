package com.example.multiplatformhomework.threads

import kotlinx.coroutines.CoroutineDispatcher

expect val ioDispatcher: CoroutineDispatcher
expect val uiDispatcher: CoroutineDispatcher