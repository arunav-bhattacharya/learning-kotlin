package com.arunav.kotlin.constructs

open class Person{

}

class Employee : Person(){
    fun vacationDays() : Int{
        return 20;
    }
}

class Contractor : Person(){

}

// Doing the smart cast
fun hasVacations(obj : Person){
    if (obj is Employee)
        println("Employee has ${obj.vacationDays()} vacation days") // Smart casted as kotlin compiler determined the type as Employee
    else
        println("Does not have vacation")
}

fun anotherSmartCastExample(){
    var msg : String? = null
    msg="Hello"
    println(msg.length) // Smart casted as msg value has been set in the previous line
}

fun main() {
    val employee = Employee()
    val contractor = Contractor()
    println(hasVacations(employee))
    println(hasVacations(contractor))
}