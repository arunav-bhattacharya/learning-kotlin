package com.arunav.kotlin.inheritance

abstract class AbstractEntity {
    // Having a state inside abstract class
    val isActive = true

    // Abstract method
    abstract fun load()

    // Default method
    fun status(): String {
        return isActive.toString()
    }
}

class EmployeeEntity : AbstractEntity() {
    override fun load() {
        println("Loading EmployeeEntity..")
    }
}

fun main() {
    val customerEntity = EmployeeEntity()
    customerEntity.load()
    customerEntity.status()
}