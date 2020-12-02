package com.arunav.kotlin.functional

fun operate(x: Int, y: Int, operation: (Int, Int) -> Int): Int {
    return operation(x, y)
}

// Overloaded function
fun operate(x: Int, operation: (Int) -> Int) {
    println("Input is $x and output is ${operation(x)}")
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
    // No need to specify the type when using a lambda expression
    println(operate(5, 10, { x, y -> x * y }))

    // Calling the overloaded function
    operate(2, { x -> x * x })

    // If the last parameter is a lambda expression we can move the lambda expression out of the parentheses().
    operate(7) { x -> x * 2 }

    // When there is only one parameter in the lambda expression, we can ignore the parameter specification and `->`
    // and instead refer the parameter inside the method body as `it`.
    operate(3, { it * it })

    // Just one another and simpler way to invoke the method
    operate(5) { it * it }

    // When lambda function is extracted to a variable then the type needs to be specified
    val minusLambda: (Int, Int) -> Int = { x, y -> x - y }
    println(operate(5, 10, minusLambda))

    // Using method references for passing a function as a parameter
    println(operate(2, 7, ::sum))


    // Vararg as a functional parameter
    route(
        "A",
        "E",
        { src, dest -> "$src -> temp, temp -> $dest" },
        { src, dest -> "$src -> $dest" })

    // Another example of calling a higher-order function by dropping the brackets
    val db = Database()

    transaction(db) {
        // Write our db code
    }

    // Anonymous functions - has multiple return points
    val input = -1
    operate(input, fun(x): Int {
        if (x < 0)
            return 0
        else
            return Math.sqrt(x.toDouble()).toInt()
    })

    // Closure
    var factor = 2
    val mutateIt: (Int) -> Int = { x ->
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