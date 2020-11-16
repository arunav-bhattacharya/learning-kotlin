package com.arunav.kotlin.generics

fun <T : AutoCloseable> useAndClose(input: T) {
    input.close()
}

fun <T> useAndCloseWithAppendable(input: T) where T : AutoCloseable, T : Appendable {
    input.append(" using where")
    input.close()
}

fun main() {
    val example = "Example of generic constraints"
    val writer = java.io.StringWriter()
    writer.append(example)
    useAndClose(writer)
    println(writer)
    useAndCloseWithAppendable(writer)
    println(writer)
}