package com.arunav.kotlin.collections

fun main(){
    tuples()
}

fun tuples(){

    println(Pair("Tom", "Jerry"))  // Pair of Strings
    println(Triple("Tom", "Dick", "Harry"))  // Triple of Strings
    println(mapOf("Tom" to "Cat", "Jerry" to "Mouse"))  // Map of Pair of Strings

    // Example of using a Pair
    println("Getting temperatures in at airports in Pair")
    val airportCodes = listOf("LAX", "PHX", "SFO", "DEN", "SEA")
    val airportTemperatures = airportCodes.map { code -> code to getTempAtAirport(code) }
    for(pair in airportTemperatures)
        println("Airport: ${pair.first} : Temperature: ${pair.second}")
}

fun getTempAtAirport(code: String): String = "${Math.round(Math.random() * 30) + code.count()} C"
