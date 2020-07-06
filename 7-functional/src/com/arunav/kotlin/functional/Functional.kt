package com.arunav.kotlin.functional

fun operation(x: Int, y: Int, op: (Int, Int) -> Int): Int {
    return op(x, y)
}

// Overloaded function
fun operation(x: Int, op: (Int) -> Int) {
    println("Input is $x and output is ${op(x)}")
}

// Passing vararg as function parameters
fun route(source: String, destination: String, vararg actions: (String, String) -> String) {
    for (action in actions)
        println(action(source, destination))
}

fun sum(x: Int, y: Int) = x + y

fun main() {
    println(operation(2, 7, ::sum))
    println(operation(5, 10, { x, y -> x * y }))
    operation(2, { x -> x * x })

    route(
        "A",
        "E",
        { src, dest -> "$src -> temp, temp -> $dest" },
        { src, dest -> "$src -> $dest" })
}