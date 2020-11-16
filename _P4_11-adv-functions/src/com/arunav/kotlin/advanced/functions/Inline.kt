package com.arunav.kotlin.advanced.functions

inline fun operationInline(noinline op1: () -> Int, op2: (x: Int) -> Unit) {
    println("Before call")
    op2(op1())
    println("After call")
}

fun main() {

    val x = 3
    operationInline({ x * 2 }) {
        println("I m the lambda in the inline and value from other operation is $it")
    }
}
