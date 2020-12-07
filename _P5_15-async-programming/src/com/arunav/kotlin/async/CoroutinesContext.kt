package com.arunav.kotlin.async

import kotlinx.coroutines.*
import java.util.concurrent.Executors

fun main() {
    defaultDispatcher()
    println("---------------------------")
    singleThreadExecutor()
    println("---------------------------")
    fixedThreadPool()
    println("---------------------------")
    switchingThreads()
    println("---------------------------")
    changingContext()
}

// The function that `launch` will be starting will be running on the thread pool provided by CoroutineContext thread
// in the form of Dispatchers.Default
// Dispatchers.Default is used for executing computation intensive task
fun defaultDispatcher() {
    println("Start defaultDispatcher")
    runBlocking {
        launch(Dispatchers.Default) { task1() }
        launch { task2() }

        println("Called task1() and task2() from main")
    }
    println("End defaultDispatcher")
}

// Instead of passing Dispatchers, we can pass a custom thread pool or a separate thread executor for running functions
// inside `launch{}`. The custom thread pool needs to be converted to a CoroutineDispatcher using asCoroutineDispatcher
// and then the management of the thread pool resources is done using the use() method.
// This is using singleThreadExecutor
fun singleThreadExecutor() {
    Executors.newSingleThreadExecutor()
        .asCoroutineDispatcher().use { context ->
            println("Start singleThreadExecutor")
            runBlocking {
                launch(context) { task1() }
                launch { task2() }

                println("Called task1() and task2() from main")
            }
            println("End singleThreadExecutor")
        }
}

// This is using a fixedThreadPool
fun fixedThreadPool() {
    Executors.newFixedThreadPool(Runtime.getRuntime().availableProcessors())
        .asCoroutineDispatcher().use { context ->
            println("Start fixedThreadPool")
            runBlocking {
                launch(context) { task1() }
                launch { task2() }

                println("Called task1() and task2() from main")
            }
            println("End fixedThreadPool")
        }

}

// When we want to launch a function from the context of the current thread, we can provide the second optional parameter
// to the launch function, i.e. CoroutineStart. These are the different enums of CoroutineStart -
//  - `DEFAULT`: To run the coroutine in the current context
//  - `LAZY`: Defer execution until an explicit `start()` is called
//  - `ATOMIC`: Used to run in non-cancellable mode
//  - `UNDISPATCHED`: To run in current context and then switch threads after suspension point

fun switchingThreads() {
    Executors.newFixedThreadPool(Runtime.getRuntime().availableProcessors())
        .asCoroutineDispatcher().use { context ->
            println("Start switchingThreads")
            runBlocking {
                launch(context, CoroutineStart.UNDISPATCHED) { task1() }
                launch { task2() }

                println("Called task1() and task2() from main")
            }
            println("End switchingThreads")
        }
}

// We can run a particular piece of code in a different context by using withContext(). This function accepts a
// CoroutineContext as a parameter. This context will be used to run the particular piece of code which is mentioned
// inside the lambda block
fun changingContext() {
    println("Start changingContext")
    runBlocking (CoroutineName("top runner")) {
        println("Starting in ${Thread.currentThread()}")
        withContext(Dispatchers.Default) { task1() }
        launch (CoroutineName("task2 runner")) { task2() }

        println("Called task1() and task2() from main")
    }
    println("End changingContext")
}
