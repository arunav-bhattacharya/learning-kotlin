package com.arunav.kotlin.advanced.functions


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


fun main() {

    localReturnLambda()
    localReturnAnonymous()
}