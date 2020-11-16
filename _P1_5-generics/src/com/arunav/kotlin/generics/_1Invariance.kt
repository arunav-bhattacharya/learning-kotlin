package com.arunav.kotlin.generics

fun main() {

    val dog = Dog()
    val cat = Cat()
    identifyAnimal(dog)
    identifyAnimal(cat)

    val animals = mutableListOf(dog, cat)
    identifyAnimals(animals)

    val dog1 = Dog()
    val dogs = mutableListOf(dog, dog1)

//    identifyAnimals(dogs) // ERROR: We cannot pass a MutableList<Dog> to MutableList<Animal>. This is type invariance.
}

abstract class Animal {
    abstract fun sounds()
}

class Dog : Animal() {
    override fun sounds(){
        println("The dog barks")
    }
}

class Cat : Animal() {
    override fun sounds(){
        println("The cat meows")
    }
}

fun identifyAnimal(animal: Animal) {
    animal.sounds()
}

fun identifyAnimals(animals: MutableList<Animal>) {
    for (animal in animals)
        animal.sounds()
}