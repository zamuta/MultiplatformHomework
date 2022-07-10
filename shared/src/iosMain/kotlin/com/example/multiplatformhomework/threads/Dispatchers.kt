package com.example.multiplatformhomework.threads

import kotlin.native.concurrent.ThreadLocal
import kotlin.native.concurrent.freeze
import kotlin.coroutines.CoroutineContext
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Runnable
import platform.darwin.dispatch_async
import platform.darwin.dispatch_get_main_queue

actual val ioDispatcher: CoroutineDispatcher = IOSDispatcher
actual val uiDispatcher: CoroutineDispatcher = IOSDispatcher

@ThreadLocal
object IOSDispatcher : CoroutineDispatcher() {
    override fun dispatch(context: CoroutineContext, block: Runnable) {
        dispatch_async(dispatch_get_main_queue()) {
            try {
                block.run().freeze()
            } catch (e: Exception) {
                // Empty
            }
        }
    }
}