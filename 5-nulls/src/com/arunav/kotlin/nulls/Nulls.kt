package com.arunav.kotlin.nulls

fun nickName(name: String?) : String? {
    if (name == "William")
        return "Bill"
    return name?.reversed()?.toUpperCase()?:"Joker"
}

fun main() {
    println("Nickname for William is ${nickName("William")}")
    println("Nickname for Arunav is ${nickName("Arunav")}")
    println("Nickname for Arunav is ${nickName(null)}")
}