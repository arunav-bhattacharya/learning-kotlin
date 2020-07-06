package com.arunav.kotlin.inheritance

interface CustomerRepo {
    // Interfaces cannot maintain state, but can have custom getters & setters
    var isEmpty : Boolean
        get() = true
        set(value){
            println("Doing something with the value $value")
        }
    // This is a default implementation
    fun load(obj: Customer){
        println("Loading Customer Data")
    }

    fun getById(id: Int) : Customer
}

class SQLCustomerRepo : CustomerRepo {
    override fun getById(id: Int): Customer {
        println("Fetching customer Id")
        return Customer()
    }
}