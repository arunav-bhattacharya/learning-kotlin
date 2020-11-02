package com.arunav.kotlin.functions

/*
 - Unit -> returning void
 - Nothing -> throwing exception
 - Single line functions can be written as an expression
 - Default parameters can be passed as function arguments
 - When calling a function we can pass named arguments. Arguments can be in any order when using named parameters
 - Function arguments prefixed with `vararg` means variable number of arguments can be passed as parameters
 - Spread(*) operator is used when passing a variable argument to another function accepting variable arguments
*/

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
// Email is used as a default argument that evaluates the an expression
fun person(name: String, address: String = "", email: String = "$name${name.length}@kotlin.lang", phone: String) {
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