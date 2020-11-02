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

fun greet2(names: List<String>) {
    println("Welcome")
    for (name in names)
        println(name)
}

fun variables2() {
    var name = "Arpita"
    println()
    println(name)
    println("Kotlin class=" + name::class)
    println("Underlying Java class=" + name::javaClass)

    var age: Int
    age = 25
    val address: String = "Kolkata, India"
    val person1 = "Name= $name, Age=$age, Address=$address"
    println("\n" + person1)
    name = "Madhuri"
    age = 30
    val person2 = "Name= $name, Age=$age, Address=$address"
    println(person2)
}

fun main() {
    greet(listOf("Arunav", "Kaushik", "Sanjoy"))
    greet2(listOf("Arunav", "Kaushik", "Sanjoy"))
    playingWithVariables()
    variables2()
}