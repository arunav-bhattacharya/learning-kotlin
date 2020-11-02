package com.arunav.kotlin.basics

fun main() {
    ifConditions()
    whenConditions("Green")
    when2(0)
}

fun when2(number: Int){

    when {
        number > 0 -> println("Positive number")
        number < 0 -> println("Negative number")
        else -> println("Zero")
    }
}

fun whenConditions(str: String) {
    when(str){
        "Red" -> println("The color code is 4")
        "Blue" -> println("The color code is 8")
        else -> println("Couldn't find the color code")
    }
}

fun ifConditions() {
    val a = 30
    val b = 20

    val result = if (a > b){
        "a is greater than b"
    } else {
        "b is greater than a"
    }
    println(result)
}

