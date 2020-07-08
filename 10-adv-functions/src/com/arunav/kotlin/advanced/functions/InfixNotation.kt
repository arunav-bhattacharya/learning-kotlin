package com.arunav.kotlin.advanced.functions

infix fun String.compare(value: String) : Boolean = this == value

fun main() {

    val output = "Hello"

    val isEqual = output compare "Hello"

    println(isEqual)
}