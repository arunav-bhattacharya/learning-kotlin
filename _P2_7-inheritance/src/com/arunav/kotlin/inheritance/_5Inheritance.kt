package com.arunav.kotlin.inheritance

open class Person() {
    open fun validate() {
        println("Validating in Person")
    }
}

open class Customer : Person {
    // Because we have made the validate() final we cannot override this method in its sub-classes
    final override fun validate() {
        //super.validate()
        println("Validating in Customer")
    }

    constructor() : super() {
        println("Inside Customer constructor")
    }
}

data class SpecialCustomer(var id: Int) : Customer()

fun main() {
    val customer = Customer()
    customer.validate()

    val specialCustomer = SpecialCustomer(1)
    specialCustomer.validate()
}