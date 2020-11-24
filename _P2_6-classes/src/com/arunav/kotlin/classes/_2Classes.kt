package com.arunav.kotlin.classes

import kotlin.math.absoluteValue
import kotlin.random.Random

fun main() {
    // Using the Car class
    val car = Car("BMW")
    println("Color of car=${car.color}, Make of Car=${car.make}")

    // Using the Car1 class
    val car1 = Car1(2010, "Black")
    println("Year of make = ${car1.year} and color = ${car1.theColor}")
    car1.theColor = "Blue"
    println("Year of make = ${car1.year} and color = ${car1.theColor}")

    car1.mileage++
    println("Car1=${car1}")
    try {
        car1.color = ""
    } catch (e: java.lang.Exception) {
        println(e.message)
    }
    println("Car1=${car1}")

    val car2 = Car1(2021, "Black")
    println("Car2=${car2}")

    val ssn = SSN("789854545")
    ssn.receiveSSN(ssn)


    // Using the Customer class
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
}

class Car {
    var color = "black"
    val make: String

    // The only constructor in the class
    constructor(make: String) {
        this.make = make
    }
}

class Car1(val year: Int, var theColor: String) {
    var mileage: Int = 100
    var color = theColor
        // We can give any name to the parameter of the setter (value)
        set(value) {
            if (value == "")
                throw Exception("ERROR: Color cannot be blank")
            field = value
        }

    init {
        if (year > 2020) {
            mileage = 0
        }
    }

    override fun toString() = "year=$year, color=$color, mileage=$mileage "
}

class Customer(var id: Int = Random.nextInt().absoluteValue, var name: String) {
    var email: String = ""

    // Initializing the properties
    init {
        name = name.toUpperCase()
    }

    // Using a secondary constructor that is referencing the first one using `this`
    constructor(id: Int = Random.nextInt().absoluteValue, name: String, email: String) : this(id, name) {
        if (email == "") this.email = "$name@example.com"
        else this.email = email
    }
}

fun printCustomer(customer: Customer) {
    println("{Id=${customer.id}, Name=${customer.name}, Email=${customer.email}}")
}


inline class SSN(val id: String) {
    fun receiveSSN(ssn: SSN) {
        println("Received $ssn")
    }
}