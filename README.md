# Learning Kotlin

> Kotlin is a statically typed, fluent, elegant, programming language that compiles to Java or JavaScript. 
>
<br/> 

# **1. Basics**

IntelliJ or Eclipse already have the Kotlin compiler so don't need to download it separately if we are using any of these IDEs.

<img src="./images/JVM.png"> 

## Introduction

### Kotlin Compiler - `kotlinc` 

- `kotlinc` is the Kotlin Compiler. On Mac, Kotlin can be installed using brew which internally installs `kotlinc` by default under `/usr/local/bin/kotlinc` -
    ```
        brew install kotlin
        ~ %which kotlinc
        /usr/local/bin/kotlinc
    ```  

- Once `kotlinc` is installed we can run Kotlin scripts on REPL or we can directly write programs and execute them. We'll take a look at both of them. 
  
### Using Kotlin REPL

- Some examples of using the Kotlin REPL from Terminal -

    ```
        ~ %kotlinc
        Welcome to Kotlin version 1.3.72 (JRE 1.8.0_251-b08)
        Type :help for help, :quit for quit
        >>> 2 + 2
        res0: kotlin.Int = 4
        >>> "Hello" +  "World"
        res1: kotlin.String = HelloWorld
        >>> fun greet(name: String) {println("Hello $name")}
        >>> greet("Arunav")
        Hello Arunav
        >>> fun multiLineGreet(name: String){
        ... println("Hello $name ! Hope you are doing great !")
        ... }
        >>> multiLineGreet("Sanjoy")
        Hello Sanjoy ! Hope you are doing great !
        >>> :quit
        ~ %
    ```

- Kotlin REPL can be run from IntelliJ Kotlin REPL, which provides syntax highlighting and suggestions for ease of use in REPL.

### Compile and run a Kotlin program 
    
- Below is a sample kotlin program `Basics.kt` 
 
    ```
        fun greet(names: List<String>){
            print("Hello ")
            for (name in names)
                print(name + ", ")
            println("in the world of Kotlin !")
        }
        
        fun main(){
            greet(listOf("Arunav", "Kaushik", "Sanjoy"))
        }
    ```
- In order to compile and execute the program as Java bytecode, we need to compile it using `kotlinc-jvm` and then run as  `kotlin` or `java` as shown below -    
    
    ```
       > kotlinc-jvm Basics.kt
       > ls
       o/p BasicsKt.class  META-INF 
       > kotlin Basics
       o/p Hello Arunav, Kaushik, Sanjoy, in the world of Kotlin !
    ```
  
<br/>
 
## Functions

<br/> 

## Classes

<br/> 

## Inheritance 

<br/> 

## Some useful tricks

<br/> 

## Functional Style

<br/> 

## Interoperability

<br/> 

## Standard Library

<br/> 

## Build Tools

<br/> 
<br/> 


# **2. Advanced**

## Functions - A Deeper look
<br/> 

## Class Scenarios
<br/>

## Delegation
<br/> 

## Generics
<br/> 

## Metaprogramming
<br/> 

## Asynchronous Programming
<br/> 
 
