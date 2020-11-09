package com.arunav.kotlin.typesafety

fun main() {
    println("** Nullable return type **")
    println(nickName("William"))
    println(nickName("Arunav"))

    println("\n** Nullable param type **")
    println("\nHandled using Safe-call Operator")
    println(nickName2("William"))
    println(nickName2("Arunav"))
    println(nickName2(null))

    println("\nHandled using Safe-call & Elvis Operators")
    println(nickName3("William"))
    println(nickName3("Arunav"))
    println(nickName3(null))

    println("\nHandled using when Expression")
    println(nickName5("William"))
    println(nickName5("Arunav"))
    println(nickName5(null))

    println("\nHandled using Unsafe Assertion Operator")
    println(nickName4("Arunav"))
    println(nickName4(null)) // Will throw a Runtime NullPointerException
}

// With nullable return type (?)
fun nickName(name: String): String? {
    if (name == "William")
        return "Bill"
    return null
}

// With nullable param type, handled using Safe-call operator (?.)
fun nickName2(name: String?): String? {
    if (name == "William")
        return "Bill"
    return name?.reversed()?.toUpperCase()
}

// With nullable param type, handled using Safe-call (?.) and Elvis (?:) operators
fun nickName3(name: String?): String {
    if (name == "William")
        return "Bill"
    return name?.reversed()?.toUpperCase()?:"What's there in a name ?"
}

// With nullable param type, handled using Unsafe Assertion Operator
fun nickName4(name: String?): String {
    if (name == "William")
        return "Bill"
    return name!!.reversed().toUpperCase()
}

// Refactoring handling for nullable param type using when expression
fun nickName5(name: String?) = when(name) {
    "William" -> "Bill"
    null -> "Joker"
    else -> name.reversed().toUpperCase()
}