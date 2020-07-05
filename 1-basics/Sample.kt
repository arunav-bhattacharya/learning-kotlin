fun greet(names: Array<String>){
    println("Hello ")
    for (name in names)
        println(name)
}

fun main(){
    greet(["Arunav", "Sanjoy", "Kaushik"])
}