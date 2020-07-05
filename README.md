# Learning Kotlin

> Kotlin is a statically typed, fluent & elegant programming language that compiles to Java or JavaScript. 
> For a very quick start to Kotlin follow these links -
> - [Basic Syntax](https://kotlinlang.org/docs/reference/basic-syntax.html)
> - [Idioms](https://kotlinlang.org/docs/reference/idioms.html)
> - [Coding Conventions](https://kotlinlang.org/docs/reference/coding-conventions.html)

<br/> 

# **1. Getting Familiar**

IntelliJ or Eclipse already have the Kotlin compiler so don't need to download it separately if we are using any of these IDEs.

<img src="./images/JVM.png"> 

## Basics

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
            print("Welcome ")
            for (name in names)
                print(name + ", ")
            println("to the world of Kotlin !")
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
       o/p Welcome Arunav, Kaushik, Sanjoy, to the world of Kotlin !
    ```

### Variables - `var` & `val`

- Immutable variables are defined as `val` and mutable variables are defined as `var`
- The type is automatically determined by Kotlin if not specified

    ```
        var name="Arunav"
        var age=Int
        age = 20
        name = "Madhuri"
        val address=String
        address = "Phoenix, Arizona"    
    ```  

### Basic Data Types

- In Kotlin everything is an object. 
- The different data types in Kotlin are - **Numbers, Characters, Booleans, Arrays, Unsigned integers, Strings**.
- There is no implicit type conversion. Using helper functions we can do type conversion.  
- There are different literal constants for integral values for -
    - Decimal (123)
    - Long (123L)
    - Hexadecimal (0x0F)
    - Binary (0b00001011)
    - Double (123.5)
    - Float (123.5f)
- We can use underscores in numerical literals to make it more readable
    `val oneMillion = 1_000_000`

- Similar to Java, `Char` and is written inside single quotes on the other hand `String` is written inside double quotes.
- Multi-line `String` can be written inside a pair of 3 double quotes """ 
    ```
        val multiLineString = """
            Hello there, 
            How are you ?
            """
    ```    
- String literals can contain template expressions, i.e. pieces of code that are evaluated and whose results are concatenated into the string. A template expression starts with a dollar sign ($) and consists of either a simple name: 
    ```
        val person = "Name: $name; Age: $age; Address: $address"
    ```     
[Additional Reading](https://kotlinlang.org/docs/reference/basic-types.html)

### Loops & Ranges

- Traditional `for`, `while`, `do..while` loops are supported in Kotlin
- `break` and `continue` also are supported
- We can use ranges inside for loops
    - `..` : Incrementing 
    - `downTo` : Decrementing
    - `step` : no. of steps increment or decrement can happen
    ```
        for (i in 1..10) {
            println(i)
        }
        for (i in 1..10 step 3) {
            println(i)
        }
        for (i in 10 downTo 1 step 2) {
            println(i)
        }
    ```
- We can use label to break out of all the nested loops

### Conditionals 

- In Kotlin, `if` can be used as a statement or an expression. When used as expression it returns a value and hence there is no separate ternary operator.
- Instead of switch statements, we have `when` statements in Kotlin. default case is referred as `else`.
- When `if` and `when` are used as expression, the `else` is mandatory. 

[Additional Reading](https://kotlinlang.org/docs/reference/control-flow.html)  

### Packages 

- By default Kotlin imports a number of packages.
- Depending on target platform, additional packages are imported for JVM and JS.
- The syntax for specifying a package and importing from a package are similar to what we have in Java.
- A source file may start with a package declaration.
- Apart from the default imports, each file may contain its own import directives.
- If there is a name clash, we can disambiguate by using `as` keyword to locally rename the clashing entity.
    ```
        import org.example.Message // Message is accessible
        import org.test.Message as testMessage // testMessage stands for 'org.test.Message'
    ```

[Additional Reading](https://kotlinlang.org/docs/reference/packages.html)

<br/>

 
## Intro to Functions

### Have `fun` in Kotlin

- Functions in Kotlin are prefixed with `fun`
- Some return types in function -
    - `Unit` : This is the default return type. Unit is kind of equivalent to void in other languages. But in kotlin we can check if the value of a variable is `Unit` 
    - `Nothing` : Nothing is a return type when a function returns exception.
- **Single expression** function doesn't need a function block    

### Default & Named Parameters

- We can pass **default** parameters to function arguments
- In case of ambiguity in case of multiple parameters & default value being used in some cases, then the calling part of the function can use **named** parameters.
- Also the ordering of the functions can be in any sequence when using named parameters 

### Unlimited Parameters - `vararg`

- When a function parameter is specified as `vararg` it means it can have unlimited number of parameters.
- In case of passing vararg to another function we can use the **spread operator (\*)**.

[Additional Reading](https://kotlinlang.org/docs/reference/functions.html)

<br/> 

## Classes

- Classes can be defined with or without any {}.
- Classes has properties and not fields. Properties can be defined as `val` or `var`.
- To create instances of classes, we can simply call the Class using the className. There is no `new` keyword in Kotlin.
- **All properties needs to be initialized if they are not passed using constructor**.
- Constructor properties can have **default** or **named** parameters similar to functions.
- We can initialize properties inside an `init{}` block of code inside the class.
- Secondary constructors can be created by using the `constructor` keyword. 
- If the class has a primary constructor, each secondary constructor needs to **delegate to the primary constructor**, either directly or indirectly through another secondary constructor(s) using the `this` keyword.
- `var` is not allowed inside secondary constructors.

[Additional Reading](https://kotlinlang.org/docs/reference/classes.html)

### Custom Getters & Setters

- We can create custom getters and setters inside kotlin classes by using the `get()` and `set()` methods with each properties.
- `field` is a special keyword in Kotlin that is used to set a value to a property.

[Additional Reading](https://kotlinlang.org/docs/reference/properties.html)

### Member functions

- We can define member functions inside classes similar to how we defined functions. 
- It will have access to all the properties inside the class 

### Visibility Modifiers

<img src="./images/visibility.png"> 

### `data` Classes

- In order to reduce verbose code, Kotlin has `data` classes which automatically derives -
    - `equals()` / `hashCode()`
    - `toString()`
    - `copy()`
- Data classes must fulfill the following requirements -
    - The primary constructor needs to have at least one parameter
    - All primary constructor parameters need to be marked as `val` or `var`
    - Data classes cannot be abstract, open, sealed or inner
- We can `override` and provide explicit implementations of `equals()`, `hashCode()` or `toString()` in the data class body, then these functions are not generated, and the explicit implementations are used;
- `copy()` function can be used to copy an object altering some of its properties, but keeping the rest unchanged. 

### Enum Classes

### Objects

- Provides an easy way to create singletons.
- Objects in an expression are initialized immediately, whereas object declarations are lazily instantiated.  

<br/> 

## Inheritance 

### Abstract Classes

### Interfaces

<br/> 

## Nulls

<br/> 

## Some useful tricks

### Type casting 

### Tuples

### Deconstructing values

### Exceptions 

### Constants

### Annotations

<br/> 

## Functional Style

### Higher Order Functions

### Lambda Expressions

### Closures

### Extension Functions 

<br/> 

## Interoperability

### Java in Kotlin

### Working with nulls from Java

### Kotlin in Java

### Top-level functions & properties in Kotlin

### Extension functions from Java

### Interop with Java 7 & 8

<br/> 

## Standard Library

### Kotlin Collections

### Filter, map, flatMap

### Lazy Evaluation with Sequences

### String Extension

<br/> 

## Build Tools

<br/> 
<br/> 


# **2. Some Advanced Concepts**

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
 
