package com.arunav.kotlin.stdlib

fun main() {

    val numbers = 1..10

    // Immutable List
    val cities = listOf("Kolkata", "Delhi", "Mumbai", "Chennai")

    // Mutable List
    val mutableCities = mutableListOf("NY", "London")
    mutableCities.add("Dubai")

    // Hashmap
    val hashMap = hashMapOf(Pair("Spain", "Madrid"), Pair("Paris", "France"))

    // ArrayOf helper functions
    val booleans = booleanArrayOf(true, false, true)
    val characters = charArrayOf('A', 'B', 'z')
}