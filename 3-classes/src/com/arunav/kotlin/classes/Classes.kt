package com.arunav.kotlin.classes

import kotlin.math.absoluteValue
import kotlin.random.Random

class Customer(var id: Int = Random.nextInt().absoluteValue, var name: String) {
    var email: String = ""

    // Initializing the properties
    init {
        name = name.toUpperCase()
    }

    // Using a secondary constructor that is referencing the first one using `this`
    constructor(id: Int = Random.nextInt().absoluteValue, name: String, email: String) : this(id, name) {
        if (email == "")
            this.email = "$name@example.com"
        else
            this.email = email
    }
}

class Car {
    var color = "black"
    var make: String

    // The only constructor in the class
    constructor(make: String) {
        this.make = make
    }
}

fun main() {
    val c1 = Customer(name = "Younis")
    val c2 = Customer(id = 2, name = "Souvik")
    val c3 = Customer(3, name = "Dipan")
    val c4 = Customer(4, "Beth", "")
    val c5 = Customer(name = "John", email = "John@example.com")

    printCustomer(c1)
    printCustomer(c2)
    printCustomer(c3)
    printCustomer(c4)
    printCustomer(c5)

    val car = Car("BMW")
    println("${car.color}, ${car.make}")
}


fun printCustomer(customer: Customer) {
    println("{Id=${customer.id}, Name=${customer.name}, Email=${customer.email}}")
}