package com.arunav.kotlin.advanced.functions

fun outsideFunction(){

    var age = 20
    fun olderAge(){
        age = 20 + 1
        var olderAge = age
        println("Older Age: $olderAge")
    }
    println("Original Age $age")
    olderAge()
    println("Mutated Age $age")
}

fun main() {
    outsideFunction()
}