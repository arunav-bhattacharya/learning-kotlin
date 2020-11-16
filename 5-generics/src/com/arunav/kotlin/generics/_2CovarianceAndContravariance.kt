package com.arunav.kotlin.generics

class Basket

open class Fruit (val name: String) {
    override fun toString() : String {
        return name
    }
}

class Banana : Fruit("Banana")

class Orange : Fruit("Orange")

fun copyFromTo(from: Array<Fruit>, to: Array<Fruit>) {
    println("\n Copying from type invariant Fruit Array to type invariant Fruit Array..")
    for (idx in from.indices)
        to[idx] = from[idx]
    to.iterator().forEach { fruit -> println(fruit) }
}

fun copyFromTo2(from: Array<out Fruit>, to: Array<Fruit>) {
    println("\n Copying from any type of Fruit Array to type invariant Fruit Array..")
    for (idx in from.indices) {
        to[idx] = from[idx]
//        from[idx] = Fruit() // This will give a COMPILE ERROR as from Array is defined as an out param
    }
    to.iterator().forEach { fruit -> println(fruit) }
}

fun copyFromTo3(from: Array<out Fruit>, to: Array<in Fruit>) {
    println("\n Copying from any type of Fruit Array to Any type of Fruit Array..")
    for (idx in from.indices)
        to[idx] = from[idx]
    to.iterator().forEach { fruit -> println(fruit) }
}


fun main() {
    val basket1 = Array(3) { Fruit("Seedless Fruits") }
    val basket2 = Array(4) { Fruit("Fruits with Seeds") }

//  INVARIANCE
//  ----------

    copyFromTo(basket1, basket2)
    val bananaBasket = Array(2) { Banana() }

//  copyFromTo(bananas, fruits2)  // COMPILE ERROR: Because of Type invariance

//  COVARIANCE
//  ----------

    copyFromTo2(bananaBasket, basket1)
//  Now it compiled successfully because the `from` param has an out (similar to extends in generic wildcards in Java),
//  which tells the compiler that the function can only read out of the from parameter. Array<out Fruit> conveys
//  covariance on the Fruit parameter type. Kotlin compiler will ensure that there is no method call on the `from` param
//  that can modify the Array, because `out` is used on it.
//      The `out` modifier is called a variance annotation and since here it is used to project the type of the generic
//  class `Array<T>`, this is referred to as type projection or use-site covariance.

//  CONTRAVARIANCE
//  --------------

    val emptyBasket = emptyArray<Any>()
    val orangeBasket = Array(2) { Orange() }

//    copyFromTo2(orangeBasket, emptyBasket) // COMPILE ERROR: Because of type invariance

    copyFromTo3(orangeBasket, emptyBasket)
//    Here, we have copied Array<Orange> to Array<Any> using contravariance. The `in` operator in the copy method
//    ensures that Any super classes of Fruit will allowed to be modified inside the method but nothing can be read out
//    of it. Since all classes in Kotlin inherit from Any so, the copyFromTo3() method allowed the mutating operation.
//    However, it will not allow to read out of the `to` array.

}