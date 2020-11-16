package com.arunav.kotlin.advanced.functions

// Overloaded function
fun operation(x: Int, op: (Int) -> Int) {
    println("Input is $x and output is ${op(x)}")
}

fun main() {
    val input = -1
    operation(input, fun(x): Int {
        if (x < 0)
            return 0
        else
            return Math.sqrt(x.toDouble()).toInt()
    })
}
