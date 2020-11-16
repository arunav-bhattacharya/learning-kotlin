package com.arunav.kotlin.typesafety

import java.lang.RuntimeException

fun main (){
    anyExample(1)
    anyExample("Arunav")
    println(nothingExample(4))
    println(nothingExample(-1))
}

fun anyExample(param: Any){
    println("$param is of type ${param::class}")
}

fun nothingExample(number : Int) : Double {
    if (number >= 0)
        return Math.sqrt(number.toDouble())
    else
        throw RuntimeException("Negative or Zero is not allowed")
}
