package com.arunav.kotlin.collections

fun main() {
    arraysExample()
}

fun arraysExample() {

    // Array of Strings
    val friends = arrayOf("Sanjoy", "Kaushik", "Ayon", "Debanjan")
    println(friends::class)
    println(friends.javaClass)
    println("${friends[0]}, ${friends[1]}, ${friends[2]}, ${friends[3]}")

    // Array of Integers
    val numbers = arrayOf(1, 2, 3, 4, 5, 6)

    // IntArray
    val intNumbers = intArrayOf(1, 2, 3)

    // Different in-built Kotlin functions can be called on array
    println(numbers.size) // Returns the size of the array
    println(numbers.average()) // Average of the values in the array
    println(numbers.sum()) // Sum of the values of the array

    // Using the array constructor
    // Takes in two values - the size as the first parameter and a function that takes the index starting with 0
    // and returns the value to placed at that index
    println(Array(6) { i -> (i + 1) * (i + 1) }.sum())
}

