package com.arunav.kotlin.classes

fun main() {

    draw()

    val aRunnable = createRunnable()
    aRunnable.run()

    val aRunnableWithClosable = createRunnableWithClosable()
    aRunnableWithClosable.run()

    println("No. of processors = ${Util.numberOfProcessors()}")
}

fun draw() {
    // This is treated as an object expression
    val rectangle = object {
        val length = 10
        val breadth = 7
    }
    println("Drawing Rectangle of length ${rectangle.length} & breadth ${rectangle.breadth}")
    println("Drawing Circle of radius ${Circle.radius}")
}

// This is treated as an object declaration or singleton
object Circle {
    var radius = 2
}

fun createRunnable(): Runnable = Runnable { println("I m running") }

fun createRunnableWithClosable(): Runnable = object : Runnable, AutoCloseable {
    override fun run() {
        println("I m running")
        close()
    }

    override fun close() {
        println("I m closing")
    }
}

object Util {
    fun numberOfProcessors() = Runtime.getRuntime().availableProcessors()
}
