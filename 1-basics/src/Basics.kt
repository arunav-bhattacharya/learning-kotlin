fun greet(names: List<String>){
    print("Welcome ")
    for (name in names)
        print(name + ", ")
    println("to the world of Kotlin !")
}

fun main(){
    greet(listOf("Arunav", "Kaushik", "Sanjoy"))
}