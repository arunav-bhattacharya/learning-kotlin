package com.arunav.kotlin.functions

fun hello(): Unit {
    println("I m returning void")
}

fun throwingException(): Nothing {
    throw Exception("I m throwing an exception, as my return type is Nothing")
}

// Multiple arguments
fun sum(x: Int, y: Int): Int {
    println("I m returning an Int")
    return x + y;
}

fun singleLineSum(x: Int, y: Int) = x + y;

// Using default Parameters
fun person(name: String, address: String = "", email: String = "", phone: String) {
    println("Name=$name, Address=$address, Email=$email, Phone=$phone")
}

fun greetPeople(vararg names: String) {
    print("Welcome ")
    // Using the spread operator (*) to pass variable number of arguments
    printNames(*names)
    println("to the world of Kotlin using vararg")
}

fun printNames(vararg names: String) {
    for (name in names)
        print("$name, ")
}


fun main() {
    hello()
    // Multiple arguments
    println("Sum of 5 & 6 = ${sum(5, 6)}")
    println("Sum of 2 & 5 = ${singleLineSum(2, 5)}")
    // Using named parameters
    // When using named parameters the ordering can be different
    person("Arunav", phone = "12455", address = "Phoenix")
    greetPeople("Arunav", "Madhuri", "Sanjoy", "Kaushik")
    throwingException()
}