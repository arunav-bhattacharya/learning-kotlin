package com.arunav.kotlin.advanced.functions

import java.time.LocalDateTime

// Making lambda an extension function
fun greet(name: String, func: String.(String) -> Unit){
    "Welcome to DSL".func(name)
}


 val numbers = 1..10


val ago = "ago"
val from_now ="from now"

infix fun Int.years(tense: String){
    when(tense){
        ago -> println("Bright smile")
        from_now -> println("Sleepless nights")
        else -> println("Lot to learn still in married life")
    }
}

fun main() {

    greet("Arunav") {
        println("$this $it")
    }

    // Executing DSLs using infix
    4.years(ago)
    2 years from_now

    // Executing DSL
    "kotlin" meeting {
        start at 12..50
    }

    "java" meeting {
        start after 14..10
    }
}

infix fun String.meeting(code: Meeting.() -> Unit){
    Meeting(this).code();
}

class Meeting(val name: String) {
    val start = this

    infix fun at(time: IntRange){
        println("$name meeting starts at $time")
    }

    infix fun after(time: IntRange){
        println("$name meeting starts after $time")
    }
}

