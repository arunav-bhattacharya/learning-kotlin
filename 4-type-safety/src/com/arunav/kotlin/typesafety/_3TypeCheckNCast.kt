package com.arunav.kotlin.typesafety

fun main() {
    println("\nType Check")
    typeCheck(1)
    typeCheck("Hello")
    typeCheck(2.5)

    println("\nSmart Cast")
    smartCast(64)
    smartCast("Hello")

    println("\nExplicit Cast")
    explicitCast(64)
    explicitCast(-3)
}

// Using the is operator to do the type check
fun typeCheck(param: Any) {
    when (param) {
        is Int -> println("Input param is an Integer")
        is String -> println("Input param is an String")
        else -> println("Input param is ${param::class}")
    }
}

// Smart casting when the compiler is able to derive the type of param
fun smartCast(param: Any) {
    when (param) {
        is Int -> println("Double of ${param} is ${param.plus(param)}")
        is String -> println("Length of ${param} is ${param.length}")
        else -> println("Can do a lot more things..")
    }
}

// Doing explicit type cast using as? operator
fun explicitCast(number: Int) {
    println("$number multiplied to sq.rt of $number is ${(getSqrt(number) as? Double)?.times(number) ?: getSqrt(number)}")
}

fun getSqrt(number: Int): Any {
    when {
        number >= 0 -> return Math.sqrt(number.toDouble())
        else -> return "not possible"
    }
}
