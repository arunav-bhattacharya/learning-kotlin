package com.arunav.kotlin.classes

object Circle{
    var radius = 2
}
fun draw(){
    var rectangle = object {
        val length = 10
        val breadth = 7
    }
    println("Drawing Rectangle of length ${rectangle.length} & breadth ${rectangle.breadth}")
    println("Drawing Circle of radius ${Circle.radius}")
}

fun main() {
    draw()
}