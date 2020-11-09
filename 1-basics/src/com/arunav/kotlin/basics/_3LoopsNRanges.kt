package com.arunav.kotlin.basics

fun main() {
    loops()
    ranges()
}

fun loops() {
    println(" L O O P S")
    println(" =========")
    val numbers = listOf(1, 5, 12, 41, 4, 45, 6, 23, 662, 21, 45, 4)
    println("Printing all the numbers...")
    for (num in numbers)
        println(num)

    val names = listOf("Tom", "Jerry", "Spike")
    println("Printing names and index positions")
    for (index in names.indices) {
        println("Position of ${names.get(index)} is $index")
    }

    println("Alternatively printing names and index positions")
    for ((index, name) in names.withIndex()) {
        println("Position of $name is $index")
    }
}

fun ranges() {
    println(" R A N G E S")
    println(" ===========")
    val oneToFive: IntRange = 1..5
    println("Printing an IntRange")
    for (i in oneToFive) {
        println(i)
    }

    val aToe: CharRange = 'a'..'e'
    println("Printing a CharRange")
    for (i in aToe) {
        println(i)
    }

    // ClosedRange is Comparable
    println("Checking if a string is in a closed range of strings")
    val seekHelp: ClosedRange<String> = "hell".."help"
    println(seekHelp.contains("helm"))
    println(seekHelp.contains("hello"))
    println(seekHelp.contains("helo"))
    println(seekHelp.contains("hels"))

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

    // Skipping values in ranges
    println("Printing 1 to 6")
    for (i in 1 until 7)
        println(i)

    // Using filters in ranges
    println("Using filter to print ranges")
    for (i in (1..12).filter { it % 3 == 0 || it % 5 == 0 }) {
        println(i) //3, 5, 6, 9, 10, 12
    }
}

