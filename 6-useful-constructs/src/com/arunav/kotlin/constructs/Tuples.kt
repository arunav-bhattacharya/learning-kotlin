package com.arunav.kotlin.constructs

val airportCodes = listOf("LAX", "SFO", "PDX", "SEA")

val temperatures =
    airportCodes.map { code -> code to getTemperatureAtAirport(code) }

fun getTemperatureAtAirport(code: String): String =
    "${Math.round(Math.random() * 30) + code.count()}"

fun main() {
    for (temp in temperatures) {
        println("Airport: ${temp.first}: Temperature: ${temp.second}")
    }
}
