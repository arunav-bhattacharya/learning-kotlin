package com.arunav.kotlin.async

import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking
import kotlinx.coroutines.yield
import kotlin.coroutines.CoroutineContext

suspend fun task1() {
    println("Starting task1 in ${Thread.currentThread()}")
    // yield() method doesn’t result in any explicit delay,
    // but it will give an opportunity for another pending task to execute.
    yield()
    println("Ending task1 in ${Thread.currentThread()}")
}

suspend fun task2() {
    println("Starting task2 in ${Thread.currentThread()}")
    yield()
    println("Ending task2 in ${Thread.currentThread()}")
}

fun main() {

    println("Start")

    // The runBlocking() function takes a lambda as an argument and executes that within a coroutine.
    runBlocking {
        // 1. launch() function starts a new coroutine to execute the given lambda, like runBlocking() function does,
        // except the invoking code isn’t blocked for the completion of the coroutine.
        // 2. Unlike the runBlocking() function, the launch() function returns a job,
        // which can be used to wait on for completion or to cancel the task.
        launch { task1() }
        launch { task2() }

        println("Called task1() and task2() from main")
    }
    println("End")
}