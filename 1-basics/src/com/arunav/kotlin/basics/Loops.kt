package com.arunav.kotlin.basics

fun main() {
    // Incrementing Range
    println("Printing 1 to 10")
    for (i in 1..10) {
        println(i)
    }
    // Incrementing Range with step
    println("Printing 1 to 10 with a step of 3")
    for (i in 1..10 step 3) {
        println(i)
    }
    // Decrementing Range with step
    println("Printing 10 to 1 with a step of 2")
    for (i in 10 downTo 1 step 2) {
        println(i)
    }
}