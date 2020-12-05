package com.arunav.kotlin.delegates

import kotlin.properties.Delegates.observable
import kotlin.properties.Delegates.vetoable

fun main() {

    // 1. lazy delegate
    val temperature by lazy { getTemperature("PHX") }
    val showTemperature = true

    if (showTemperature && temperature > 20)
        println("Warm")
    else
        println("Nothing to report")

    // 2. observable delegate
    val observable = ObservableExample()

    println("Count=${observable.counter}")
    observable.counter++
    observable.counter--
    observable.counter++
    println("Count=${observable.counter}")

    // 3. vetoable delegate

    val vetoable = VetoableExample()

    println("Count=${vetoable.incrementer}")
    vetoable.incrementer++
    vetoable.incrementer-- // This is rejected, because if this change is applied then new value < old value
    vetoable.incrementer++
    println("Count=${vetoable.incrementer}")
}

class ObservableExample {

    var counter by observable(0) { property, oldValue, newValue ->
        println("Property metadata=$property, Old value=$oldValue, New value=$newValue")
    }
}

class VetoableExample {

    var incrementer by vetoable(0) { _, oldValue, newValue -> newValue > oldValue }
}


fun getTemperature(city: String): Double {
    println("Calling external service to fetch temperature...")
    return 25.0
}

