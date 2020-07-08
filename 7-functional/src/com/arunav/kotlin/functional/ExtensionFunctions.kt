package com.arunav.kotlin.functional

val greet = "hello"

fun String.shout() = toUpperCase()


fun main() {

    greet.shout()
}