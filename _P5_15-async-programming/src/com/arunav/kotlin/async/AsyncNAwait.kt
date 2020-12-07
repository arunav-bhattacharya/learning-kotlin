package com.arunav.kotlin.async

import kotlinx.coroutines.Deferred
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.async
import kotlinx.coroutines.runBlocking

fun main() {
    asyncNawait()
}

fun asyncNawait() {

    runBlocking {
        val availableCores : Deferred<Int> = async(Dispatchers.Default){
            println("Running inside async() in ${Thread.currentThread()}")
            Runtime.getRuntime().availableProcessors()
        }
        println("Called the function in ${Thread.currentThread()}")
        println("No. of cores = ${availableCores.await()}")
    }
}
