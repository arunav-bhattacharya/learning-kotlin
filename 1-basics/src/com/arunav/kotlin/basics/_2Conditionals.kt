package com.arunav.kotlin.basics

/*
* if-else can be used as statements or expressions. When used as expressions, the else is mandatory
* Instead of switch statements, Kotlin has when which again can be used as statements or expressions
* */

fun main() {
    ifConditions()
    whenExample(0)
    whenStatement("Green")
    println(whenExpression("Sunday"))
    println(whenExpression("Wednesday"))
    println(whenExpression("3"))
    println(whenExpression("Friday"))
    println(whenExpression("Munday"))
    println(whenExpression(8))
    println(whenVariableScope())
}

fun ifConditions() {
    val a = 30
    val b = 20

    val result = if (a > b) {
        "a is greater than b"
    } else {
        "b is greater than a"
    }
    println(result)
}

fun whenExample(number: Int) {
    when {
        number > 0 -> println("Positive number")
        number < 0 -> println("Negative number")
        else -> println("Zero")
    }
}

fun whenStatement(str: String) {
    when (str) {
        "Red" -> println("The color code is 4")
        "Blue" -> println("The color code is 8")
        else -> println("Couldn't find the color code")
    }
}

// This example expects Any kind of variable as input
fun whenExpression(dayOfWeek: Any) = when (dayOfWeek) {
    "Saturday", "Sunday" -> "Relax"
    in listOf("Monday", "Tuesday", "Wednesday", "Thursday") -> "Work hard"
    in 2..4 -> "Work hard"
    "Friday" -> "Party"
    is String -> "What?"
    else -> "No clue"
}


fun whenVariableScope(): String = when (val numberOfCores = Runtime.getRuntime().availableProcessors()) {
    1 -> "1 core, packing this one to the museum"
    in 2..16 -> "You have $numberOfCores cores"
    else -> "$numberOfCores cores!, I want your machine"
}
