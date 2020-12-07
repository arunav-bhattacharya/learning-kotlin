package com.arunav.kotlin.functional

fun main() {
    caller()
    println("after return from caller")

    localReturnLambda()
    localReturnAnonymous()
}

fun caller() {
    (1..5).forEach { i ->
        if (i == 4) return // Allowing this return without a label because forEach is an inline function. Will return from the caller function
        invokeWith(i) here@{ //Labeled return
            println("enter for $it")
            if (it == 2) {
                return@here // Return without a label will not be allowed here
            }
            println("exit for $it")  // This statement will not get executed when i = 2
        }
    }
    println("end of caller")
}

fun invokeWith(n: Int, action: (Int) -> Unit) {
    println("enter invokeWith $n")
    action(n)
    println("exit invokeWith $n")
}

fun localReturnLambda(){
    val numbers = 1..100

    numbers.forEach forEachBlock@{
        if(it % 5 == 0)
            return//@forEachBlock
    }
    println("After forEach in lambda")
}

fun localReturnAnonymous(){
    val numbers = 1..100

    numbers.forEach(fun(x) {
        if(x % 5 == 0)
            return
    })
    println("After forEach in anonymous")
}
