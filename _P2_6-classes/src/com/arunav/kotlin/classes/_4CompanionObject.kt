package com.arunav.kotlin.classes

fun main() {

    val machineOperator = MachineOperator.create("Car")
    println("Before checkin=$machineOperator")
    machineOperator.checkin()
    println("After checkin=$machineOperator")
    println("Break=${MachineOperator.minimumBreak()}")
    machineOperator.checkout()
    println("After checkout=$machineOperator")
}

class MachineOperator private constructor(val name: String) {

    fun checkin() = checkedIn++
    fun checkout() = checkedIn--

    companion object {
        var checkedIn = 0
        fun minimumBreak() = "15 minutes every 2 hours"

        fun create(name: String): MachineOperator {
            val instance = MachineOperator(name)
            instance.checkin()
            return instance
        }
    }

    override fun toString() = "${checkedIn}"
}