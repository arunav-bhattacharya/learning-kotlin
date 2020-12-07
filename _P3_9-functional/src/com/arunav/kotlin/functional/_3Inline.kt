package com.arunav.kotlin.functional

import java.lang.RuntimeException

fun main() {
    val x = 3
    operationInline({ x * 2 }) {
        println("I m the lambda in the inline and value from other operation is $it")
    }

    val invokeThree: (Int) -> Unit = invokeThree(1, { report(it) }, { report(it) }, { report(it) })
    invokeThree.invoke(1) // this will invoke the function returned from invokeThree, which is nothing but action3
}

inline fun operationInline(noinline op1: () -> Int, op2: (x: Int) -> Unit) {
    println("Before call")
    op2(op1())
    println("After call")
}

inline fun invokeThree(
    n: Int,
    action1: (Int) -> Unit,
    noinline action2: (Int) -> Unit,
    crossinline action3: (Int) -> Unit // Because this parameter is marked as crossinline, so we can return it back to the calling function or pass it to another function
): (Int) -> Unit {
    println("enter invokeThree $n")
    action1(n)
    action2(n)
    println("exit invokeThree $n")
    return { _: Int -> action3(n) }
}

fun report(number: Int) {
    val stackTrace = RuntimeException().stackTrace
    println("\nCalled with $number, Stack depth: ${stackTrace.size}")
    stackTrace.take(3).forEach(::println)
}