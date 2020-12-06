package com.arunav.kotlin.functional

fun main() {

    println("1. Passing lambda as a parameter to a function...")
    var number = 10
    println("Is $number Prime ? ${isPrime(number)}")
    number = 31
    println("Is $number Prime ? ${isPrime1(number)}")
    number = 1
    println("Is $number Prime ? ${isPrime(number)}")

    println("\n2. Receiving lambda as parameter in a function...")
    actionFromOneTo({ println(it) }, 10)

    println("\n3. Using method references....")
    actionFromOneTo(::println, 10)

    println("\n4. Passing different operations as lambdas...")
    // No need to specify the type when using a lambda expression
    println(operate(5, 10, { x, y -> x * y }))

    // Calling the overloaded function
    operate(9, { x -> x * x })

    // If the last parameter is a lambda expression we can move the lambda expression out of the parentheses().
    operate(7) { x -> x * 2 }

    // When there is only one parameter in the lambda expression, we can ignore the parameter specification and `->`
    // and instead refer the parameter inside the method body as `it`.
    operate(3, { it * it / 2 })

    // Just one another and simpler way to invoke the method
    operate(5) { it * it * it }

    // When lambda function is extracted to a variable then the type needs to be specified
    val minusLambda: (Int, Int) -> Int = { x, y -> x - y }
    println(operate(5, 10, minusLambda))

    // Using method references for passing a function as a parameter
    println(operate(2, 7, ::sum))

    println("\n5. Functions returning functions....")
    val names = listOf("Rajesh", "Anjaneya", "Sterling", "Kinderley", "Kevin", "Brad", "Rince", "Arunav")
    println("First Name of length 5=${names.find(predicateOfLength(5))}")
    println("Last Name of length 6=${names.findLast(predicateOfLength(6))}")

    println("\n6. Anonymous functions having multiple return points....")
    // Anonymous functions - has multiple return points
    var input = -1
    operate(input, fun(x): Int {
        if (x < 0)
            return 0
        else
            return Math.sqrt(x.toDouble()).toInt()
    })

    // Same function without anonymous function
    input = 25
    operate(input) {
        if (it < 0) 0
        else Math.sqrt(it.toDouble()).toInt()
    }

    println("\n7. Example of Closure....")
    // Closure
    var factor = 2
    val mutateIt: (Int) -> Int = { x ->
        factor = 3
        x * factor
    }
    //operation(5, mutateIt)
    println("Initial Factor=$factor, mutated output=${mutateIt.invoke(5)}, final factor=$factor")

    println("\n8. Passing functions as a vararg....")
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

}

// Example of passing lambdas as function parameters to higher-order functions
fun isPrime(n: Int) = n == 1 || (n > 1 && (2 until n).none({ i: Int -> n % i == 0 }))

// Re-writing the same example by using the implicit parameter and dropping the brackets around none
fun isPrime1(n: Int) = n == 1 || (n > 1 && (2 until n).none { n % it == 0 })

// Example of function receiving lambdas as a parameter
fun actionFromOneTo(action: (Int) -> Unit, n: Int) = (1..n).forEach { action(it) }

fun operate(x: Int, y: Int, operation: (Int, Int) -> Int): Int {
    return operation(x, y)
}

// Overloaded function
fun operate(x: Int, operation: (Int) -> Int) {
    println("Input is $x and output is ${operation(x)}")
}

// Returning Lambda from a function
fun predicateOfLength(length: Int) = { input: String -> input.length == length }

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

class Database {

    fun commit() {
        println("Does a database commit")
    }
}