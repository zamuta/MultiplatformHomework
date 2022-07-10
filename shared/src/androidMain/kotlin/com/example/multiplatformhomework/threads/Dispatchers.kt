package com.example.multiplatformhomework.threads

import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers

actual val ioDispatcher: CoroutineDispatcher = Dispatchers.IO
actual val uiDispatcher: CoroutineDispatcher = Dispatchers.Main