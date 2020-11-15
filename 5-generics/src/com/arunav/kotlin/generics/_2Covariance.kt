package com.arunav.kotlin.generics

open class Fruit

class Banana : Fruit()

class Orange : Fruit()

fun copyFromTo(from: Array<Fruit>, to: Array<Fruit>) {
    for (idx in from.indices)
        to[idx] = from[idx]
}

fun copyFromTo2(from: Array<out Fruit>, to: Array<Fruit>) {
    for (idx in from.indices) {
        to[idx] = from[idx]
//        from[idx] = Fruit() // This will give a COMPILE ERROR as from Array is defined as an out param
    }
}

fun main() {
    val fruits1 = Array(3) { Fruit() }
    val fruits2 = Array(5) { Fruit() }

    copyFromTo(fruits1, fruits2)
    val bananas = Array(2) { Banana() }

//  copyFromTo(bananas, fruits2)  // COMPILE ERROR: Because of Type invariance

    copyFromTo2(bananas, fruits2)
//  Now it compiled successfully because the from param has an out (similar to extends in generic wildcards in Java),
//  which tells the compiler that the function can only read out of the from parameter. Array<out Fruit> conveys
//  covariance on the Fruit parameteric type. Kotlin will ensure that there is no method call on the `from` param
//  that can modify the Array.
//      The out modifier is called a variance annotation and since it is use to project the type of the generic class
//  `Array<T>`, this is referred to as type projection or use-site covariance.
}