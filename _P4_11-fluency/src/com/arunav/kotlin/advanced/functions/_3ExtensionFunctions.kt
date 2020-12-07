package com.arunav.kotlin.advanced.functions

fun main() {
    greet.shout()
}

val greet = "hello"

fun String.shout() = toUpperCase()
