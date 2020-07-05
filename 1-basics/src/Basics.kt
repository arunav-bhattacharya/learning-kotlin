fun greet(names: List<String>){
    print("Hello ")
    for (name in names)
        print(name + ", ")
    println("in the world of Kotlin !")
}

fun main(){
    greet(listOf("Arunav", "Kaushik", "Sanjoy"))
}