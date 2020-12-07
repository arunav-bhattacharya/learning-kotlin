package com.arunav.kotlin.constructs

val airportCodes = listOf("LAX", "SFO", "PDX", "SEA")

// Creating Pairs of airport codes and temperatures
val temperatures = airportCodes.map { code -> code to getTemperatureAtAirport(code) }

fun getTemperatureAtAirport(code: String): String =
    "${Math.round(Math.random() * 30) + code.count()}"

// Returns a Triple
fun getFullName() = Triple("John", "Quincy", "Adams")

fun main() {
    for (temp in temperatures) {
        println("Airport: ${temp.first}: Temperature: ${temp.second}")
    }

    // Object destructuring
    val (first, middle, last) = getFullName()
    println("First=$first Middle=$middle Last=$last")

    val (f,_, l) = getFullName()
}
