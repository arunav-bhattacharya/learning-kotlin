package com.arunav.kotlin.collections

fun listExamples() {
    val fruits: List<String> = listOf("Apple", "Banana", "Grape")
    println(fruits) //[Apple, Banana, Grape]

    // Using the `index` operator to fetch from list
    println("${fruits[0]} == ${fruits.get(0)}")

    // Using the `in` operator to check if a value exists in list
    println("Apple" in fruits)
    println(fruits.contains("Apple")) // Same as the line above

    // Using the `+` operator to add elements to a new list, since lists are by-default immutable
    // unless specified as MutableList
    val fruits2 = fruits + "Orange"
    println(fruits)   // [Apple, Banana, Grape]
    println(fruits2)  // [Apple, Banana, Grape, Orange]

    // Using the `-` operator to delete elements from a list. This creates a new list without that particular element.
    // If the element trying to delete is not present then no new list is created
    val fruits3 = fruits2 - "Banana"
    println(fruits2)  // [Apple, Banana, Grape, Orange]
    println(fruits3)  // [Apple, Grape, Orange]

    println(fruits::class)  // class java.util.Arrays$ArrayList

    val mutableFruits: MutableList<String> = mutableListOf("Apple", "Banana", "Oranges")
    println(mutableFruits::class)   // class java.util.ArrayList
    mutableFruits.add("Grapes")
    println(mutableFruits)  // [Apple, Banana, Oranges, Grapes]

}

fun setExamples() {

    val fruits: Set<String> = setOf("Apple", "Banana", "Apple")
    println(fruits) //[Apple, Banana]
}

fun main() {
    listExamples()
    setExamples()
}