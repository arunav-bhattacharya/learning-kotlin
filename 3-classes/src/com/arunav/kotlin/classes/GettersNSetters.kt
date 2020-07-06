package com.arunav.kotlin.classes

import java.util.*
import kotlin.math.absoluteValue
import kotlin.random.Random

class Employee(val id: Int = Random.nextInt().absoluteValue, val name: String, val yearOfBirth: Int) {
    var age: Int = 0
        get() = Calendar.getInstance().get(Calendar.YEAR) - yearOfBirth
    var ssn: String = ""
        set(value) {
            field = value
        }

    fun printEmployee() {
        println("id=${id}, name=${name}, yearOfBirth=${yearOfBirth}, age=${age}, ssn=${ssn}")
    }
}

fun main() {
    val e = Employee(name = "Avijit", yearOfBirth = 1986)
    e.ssn = "123-1304-030"
    e.printEmployee()
}

