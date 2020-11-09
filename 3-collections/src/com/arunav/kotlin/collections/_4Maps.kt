package com.arunav.kotlin.collections

fun mapExamples() {
    val products = mapOf("PID1" to "Phone", "PID2" to "Watch", "PID3" to "Laptop")
    println(products)
    println(products.size)
}

fun main() {
    mapExamples()
}