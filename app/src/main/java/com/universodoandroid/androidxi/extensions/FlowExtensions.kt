package com.universodoandroid.androidxi.extensions

import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.flow.flowOn

suspend inline fun <T> Flow<T>.ioToMain(crossinline collector: (T) -> Unit) {
    flowOn(Dispatchers.IO).collect { collector(it) }
}
