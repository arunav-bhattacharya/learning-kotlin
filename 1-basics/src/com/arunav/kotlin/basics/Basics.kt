package com.arunav.kotlin.basics

fun greet(names: List<String>) {
    print("Welcome ")
    for (name in names)
        print(name + ", ")
    println("to the world of Kotlin !")
}

fun playingWithVariables() {
    var name = "Arunav"
    var age: Int
    age = 20
    name = "Madhuri"
    val address: String
    address = "Phoenix, Arizona"
    val person = "Name: $name; Age: $age; Address: $address"
    print("Person details are {$person} and length of address is ${address.length}"  )
    val multiLineString = """
            Hello there, 
            How are you ?
            """
    print(multiLineString)
}

fun main() {
    greet(listOf("Arunav", "Kaushik", "Sanjoy"))
    playingWithVariables()
}

