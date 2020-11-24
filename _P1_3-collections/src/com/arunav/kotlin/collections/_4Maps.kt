package com.arunav.kotlin.collections

fun main() {
    mapExamples()
}

fun mapExamples() {
    val products = mapOf("PID1" to "Phone", "PID2" to "Watch", "PID3" to "Laptop")
    println(products)
    println(products.size)

    println(products.containsKey("PID1")) //true
    println(products.containsValue("Tablet")) //false
    println(products.containsValue("Watch")) //true
    println(products.contains("PID2")) //true - Checks if the key is present in the map
    println("PID3" in products) //true - Checks if the key is present in the map

    val unknownProduct: String? = products.get("PID4")  // Using the get() method to fetch a value from map
    println("unknownProduct=$unknownProduct")

    val someProduct: String? = products["PID1"]  // Using the index operator [] to fetch a value from map

    // Iterating
    for (product in products)
        println("${product.key} --> ${product.value}")

    for ((pid, product) in products)
        println("$pid --> $product")
}
