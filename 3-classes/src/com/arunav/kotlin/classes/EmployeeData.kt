package com.arunav.kotlin.classes

data class EmployeeData(var id: Int, var name: String, var email: String) {
    override fun toString(): String {
        return super.toString()
    }
}

fun main() {

    val e1 = EmployeeData(1, "Ram", "ram@gmail.com")
    val e2 = EmployeeData(2, "Shyam", "shyam@gmail.com")

    val e4 = e1 // Copy e1 object to e4
    // Copying from e1, but altering one of the properties
    val e3 = e1.copy(email = "ram2@gmail.com")

    // == compares all the elements in the object
    if (e1 == e4) println("e1 & e4 are equal")
    else println("e1 & e4 are different")

    if (e1 == e3) println("e1 & e3 are equal")
    else println("e1 & e3 are different")

    println(e1)
    println(e2)
    println(e3)
}