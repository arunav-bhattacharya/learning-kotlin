package com.arunav.kotlin.functional

fun operation(x: Int, y: Int, op: (Int, Int) -> Int): Int {
    return op(x, y)
}

// Overloaded function
fun operation(x: Int, op: (Int) -> Int) {
    println("Input is $x and output is ${op(x)}")
}

// Passing vararg as function parameters
fun route(source: String, destination: String, vararg actions: (String, String) -> String) {
    println("The different routes from $source to $destination are -")
    for (action in actions)
        println(action(source, destination))
}

fun sum(x: Int, y: Int) = x + y

// Example of a higher-order function when we can drop the brackets during function call
fun transaction(db: Database, code: () -> Unit) {
    try {
        code()
    } finally {
        db.commit()
    }
}

fun main() {
    // Using method references for passing a function as a parameter
    println(operation(2, 7, ::sum))

    // No need to specify the type when using a lambda expression
    println(operation(5, 10, { x, y -> x * y }))

    // When lambda function is extracted to a variable then the type needs to be specified
    val minusLambda: (Int, Int) -> Int = { x, y -> x - y }
    println(operation(5, 10, minusLambda))

    // Calling the overloaded function
    operation(2, { x -> x * x })

    // Vararg as a functional parameter
    route(
        "A",
        "E",
        { src, dest -> "$src -> temp, temp -> $dest" },
        { src, dest -> "$src -> $dest" })

    // Using `it` for single functional parameter. No need to explicitly specify the parameter
    operation(3, { it * it })

    // When the last parameter of a function is a function, then when calling the higher-order function
    // the function parameter can be passed outside the parentheses of the function call
    operation(5) { it * it }

    // Another example of calling a higher-order function by dropping the brackets
    val db = Database()

    transaction(db) {
        // Write our db code
    }

    // Anonymous functions - has multiple return points
    val input = -1
    operation(input, fun(x): Int {
        if (x < 0)
            return 0
        else
            return Math.sqrt(x.toDouble()).toInt()
    })

    // Closure
    var factor = 2
    val mutateIt:(Int) -> Int = { x ->
        factor = 3
         x * factor
    }
    //operation(5, mutateIt)
    println("Initial Factor=$factor, mutated output=${mutateIt.invoke(5)}, final factor=$factor")
}

class Database {
    fun commit() {
        println("Does a database commit")
    }
}