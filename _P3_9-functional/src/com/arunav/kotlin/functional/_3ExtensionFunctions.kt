package com.arunav.kotlin.functional

fun main() {
    greet.shout()
}

val greet = "hello"

fun String.shout() = toUpperCase()
