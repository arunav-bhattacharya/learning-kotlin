package com.arunav.kotlin.generics

fun printValues(values: Array<*>) {
    for (value in values)
        println(value)
//    values[0] = values[1]
}


fun main() {
    printValues(arrayOf(1, 2, 3, 4, 5))
}