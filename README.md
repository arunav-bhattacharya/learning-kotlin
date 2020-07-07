# Learning Kotlin
>
> Kotlin is a statically typed, fluent & elegant programming language that compiles to Java or JavaScript. 
> For a very quick start to Kotlin follow these links -
> - [Basic Syntax](https://kotlinlang.org/docs/reference/basic-syntax.html)
> - [Idioms](https://kotlinlang.org/docs/reference/idioms.html)
> - [Coding Conventions](https://kotlinlang.org/docs/reference/coding-conventions.html)
>
> This document is split into 2 parts - 
>   A. Getting Familiar
>   B. Some advanced concepts 
> 
> My takeaways from Kotlin till now -
>   1. null-safe language - usage of nullable type - safe-call & elvis operators
>   2. No checked exception - Reduces clutter in code
>   3. Using default & named parameters in functions
>   4. Using `data` class accompanied by copy() method 
>   5. Smart casting
>   6. Object destructuring
>   7. Custom getters & setters
>   

<br/> 

# **Part I - Getting Familiar**

> IntelliJ or Eclipse already have the Kotlin compiler so don't need to download it separately if we are using any of these IDEs.

<img src="./images/JVM.png"> 

## 1. Basics

> In this section we will learn about some basic constructs about Kotlin.

### 1.a. Kotlin Compiler - `kotlinc` 

- `kotlinc` is the Kotlin Compiler. On Mac, Kotlin can be installed using brew which internally installs `kotlinc` by default under `/usr/local/bin/kotlinc` -
    ```shell script
        brew install kotlin
        ~ %which kotlinc
        /usr/local/bin/kotlinc
    ```  

- Once `kotlinc` is installed we can run Kotlin scripts on REPL or we can directly write programs and execute them. We'll take a look at both of them. 
  
### 1.b. Using Kotlin REPL

- Some examples of using the Kotlin REPL from Terminal -

    ```shell script
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

### 1.c. Compile and run a Kotlin program 
    
- Below is a sample kotlin program `Basics.kt` 
 
 
    ```kotlin
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
    
    ```shell script
       ~ %kotlinc-jvm Basics.kt
       ~ %ls
       BasicsKt.class  META-INF 
       ~ %kotlin Basics
       Welcome Arunav, Kaushik, Sanjoy, to the world of Kotlin !
    ```

### 1.d. Variables - `var` & `val`

- Immutable variables are defined as `val` and mutable variables are defined as `var`
- The type is automatically determined by Kotlin if not specified


    ```kotlin
        var name="Arunav"
        var age=Int
        age = 20
        name = "Madhuri"
        val address=String
        address = "Phoenix, Arizona"    
    ```  

### 1.e. Basic Data Types

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


    ```kotlin
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

### 1.f. Loops & Ranges

- Traditional `for`, `while`, `do..while` loops are supported in Kotlin
- `break` and `continue` also are supported
- We can use ranges inside for loops
    - `..` : Incrementing 
    - `downTo` : Decrementing
    - `step` : no. of steps increment or decrement can happen
    
    ```kotlin
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

### 1.g. Conditionals 

- In Kotlin, `if` can be used as a statement or an expression. When used as expression it returns a value and hence there is no separate ternary operator.
- Instead of switch statements, we have `when` statements in Kotlin. default case is referred as `else`.
- When `if` and `when` are used as expression, the `else` is mandatory. 


    ```kotlin
        fun whenConditions(str: String) {
            when(str){
                "Red" -> println("The color code is 4")
                "Blue" -> println("The color code is 8")
                else -> println("Couldn't find the color code")
            }
        }
        fun ifConditions() {
            val a = 30
            val b = 20
        
            val result = if (a > b){
                "a is greater than b"
            } else {
                "b is greater than a"
            }
            println(result)
        }
    ```
    
[Additional Reading](https://kotlinlang.org/docs/reference/control-flow.html)  

### 1.h. Packages 

- By default Kotlin imports a number of packages.
- Depending on target platform, additional packages are imported for JVM and JS.
- The syntax for specifying a package and importing from a package are similar to what we have in Java.
- A source file may start with a package declaration.
- Apart from the default imports, each file may contain its own import directives.
- If there is a name clash, we can disambiguate by using `as` keyword to locally rename the clashing entity.


    ```kotlin
        import org.example.Message // Message is accessible
        import org.test.Message as testMessage // testMessage stands for 'org.test.Message'
    ```

[Additional Reading](https://kotlinlang.org/docs/reference/packages.html)

<br/>

 
## 2. Intro to Functions

> In this section, we'll be doing an introduction to functions in Kotlin 

### 2.a. Have `fun` in Kotlin

- Functions in Kotlin are prefixed with `fun`
- Some return types in function -
    - `Unit` : This is the default return type. Unit is kind of equivalent to void in other languages. But in kotlin we can check if the value of a variable is `Unit`.
    - `Nothing` : Nothing is a return type when a function returns exception. `Nothing` is substitutable for any class including `Int`, `Double`, `String`, etc.
- **Single expression** function doesn't need a function block    

### 2.b. Default & Named Parameters

- We can pass **default** parameters to function arguments
- In case of ambiguity in case of multiple parameters & default value being used in some cases, then the calling part of the function can use **named** parameters.
- Also the ordering of the functions can be in any sequence when using named parameters 


    ```kotlin
        fun person(name: String, address: String = "", email: String = "", phone: String) {
            println("Name=$name, Address=$address, Email=$email, Phone=$phone")
        }
    ```
    
### 2.c. Unlimited Parameters - `vararg`

- When a function parameter is specified as `vararg` it means it can have unlimited number of parameters.
- In case of passing vararg to another function we can use the **spread operator (\*)**.


    ```kotlin
        fun greetPeople(vararg names: String) {
            print("Welcome ")
            printNames(*names)
            println("to the world of Kotlin using vararg")
        }
        fun printNames(vararg names: String) {
            for (name in names)
                print("$name, ")
        }
    ```

[Additional Reading](https://kotlinlang.org/docs/reference/functions.html)

<br/> 

## 3. Classes

Kotlin is an object oriented language and it supports all the different features of object-oriented programming.

### 3.a. `class` & `construtor`

> In this section, we'll get started with the OO concepts in Kotlin. 

- Classes can be defined with or without any {}.
- Classes has properties and not fields. Properties can be defined as `val` or `var`.
- To create instances of classes, we can simply call the Class using the className. There is no `new` keyword in Kotlin.
- **All properties needs to be initialized if they are not passed using constructor**.
- Constructor properties can have **default** or **named** parameters similar to functions.
- We can initialize properties inside an `init{}` block of code inside the class.
- Secondary constructors can be created by using the `constructor` keyword. 
- If the class has a primary constructor, each secondary constructor needs to **delegate to the primary constructor**, either directly or indirectly through another secondary constructor(s) using the `this` keyword.
- `var` is not allowed inside secondary constructors.
- We can define member functions inside classes similar to how we defined functions. It will have access to all the properties inside the class.


    ```kotlin
        class Customer(var id: Int = -1, var name: String) {
            var email: String = ""
            init {
                name = name.toUpperCase()
            }
            constructor(id: Int = -1, name: String, email: String) : this(id, name) {
                if (email == "")
                    this.email = "$name@example.com"
                else
                    this.email = email
            }
           fun printCustomer() {
                println("id=${id}, name=${name}, email=${email}")
            }            
        }
    ```

[Additional Reading](https://kotlinlang.org/docs/reference/classes.html)

### 3.b. Custom Getters & Setters

- The full syntax for declaring a property is 
 
    ```kotlin
      var <propertyName>[: <PropertyType>] [= <property_initializer>]
          [<getter>]
          [<setter>]
    ```      
  
- We can create custom getters and setters inside kotlin classes by using the `get()` and `set()` methods with each properties.
- `field` is a special keyword in Kotlin that is used to set a value to a property.


    ```kotlin
        class Employee(val id: Int = Random.nextInt().absoluteValue, val name: String, val yearOfBirth: Int) {
            var age: Int = 0
                get() = Calendar.getInstance().get(Calendar.YEAR) - yearOfBirth
            var ssn: String = ""
                set(value) {
                    field = value
                }
        }
    ```

[Additional Reading](https://kotlinlang.org/docs/reference/properties.html)

### 3.c. Visibility Modifiers

<img src="./images/visibility.png"> 

[Additional Reading](https://kotlinlang.org/docs/reference/visibility-modifiers.html)

### 3.d. `data` Classes

- In order to reduce verbose code, Kotlin has `data` classes which automatically derives -
    - `equals()` / `hashCode()`
    - `toString()`
    - `copy()`
- Data classes must fulfill the following requirements -
    - The primary constructor needs to have at least one parameter
    - All primary constructor parameters need to be marked as `val` or `var`
    - Data classes cannot be abstract, open, sealed or inner
- We can `override` and provide explicit implementations of `equals()`, `hashCode()` or `toString()` in the `data` class body. These functions are not generated then and the explicit implementations are used;
- `copy()` function can be used to copy an object altering some of its properties, but keeping the rest unchanged. 


    ```kotlin
      data class EmployeeData(var id: Int, var name: String, var email: String) {
          override fun toString(): String {
              return super.toString()
          }
      }
      fun main() {
      
          val e1 = EmployeeData(1, "Ram", "ram@gmail.com")
          val e2 = EmployeeData(2, "Shyam", "shyam@gmail.com")
    
          val e3 = e1.copy(email = "ram2@gmail.com")
      }    
    ```

### 3.e. `enum` Classes

- Enum classes are used for creating a bunch of enumerated values. 
- We can customize and iterate over them as well.
- Each `enum` constant is an object. Enum constants are separated with commas.
- Enum constants can override base methods.
- **When enum class has any members, the enum constants must be separated from the member definitions with a semicolon.**


    ```kotlin
        enum class ProtocolState {
            WAITING {
                override fun signal() = TALKING
            },
            TALKING {
                override fun signal() = WAITING
            };
            abstract fun signal(): ProtocolState
        }
    ```
    
### 3.f. Objects

- In Kotlin we can directly create an object without creating a class.
- Provides an easy way to create singletons.
- Objects in an expression are initialized immediately, whereas object declarations are lazily instantiated.  

    ```kotlin
        object Circle{
            var radius = 2
        }
        fun draw(){
            var rectangle = object {
                val length = 10
                val breadth = 7 
            }
            println("Drawing Rectangle of length ${rectangle.length} and breadth ${rectangle.breadth}")
            println("Drawing Circle of radius ${Circle.radius}")
        }
    ```

<br/> 

## 4. Inheritance 

> We'll extend the OO concepts in Kotlin by looking into Inheritance, Interfaces, Abstract classes & Generics.

- Base class in Kotlin is `Any`, similar to `Object` is Java. All classes are inherits from `Any`. 
- By default all classes are `final`. In order to make a class non-final we need to make it `open`.
- Similarly members are also by default final. In order to override in the child class, we need to make the method `open` in the parent class.
- `data` classes can also be inherited in Kotlin.

    ```kotlin
        open class Person() {
            open fun validate() {
                println("Validating in Person")
            }
        }        
        open class Customer : Person {
            final override fun validate() {
                println("Validating in Customer")
            }
            constructor() : super() {
                println("Inside Customer constructor")
            }
        }
        data class SpecialCustomer(var id: Int) : Customer()
    ```
  
### 4.a. Abstract Classes

- Similar to Java

    ```kotlin
        abstract class AbstractEntity {
            // Having a state inside abstract class
            val isActive = true
        
            // Abstract method
            abstract fun load()
        
            // Default method
            fun status(): String {
                return isActive.toString()
            }
        }
        
        class EmployeeEntity : AbstractEntity() {
            override fun load() {
                println("Loading EmployeeEntity..")
            }
        }
    ```

### 4.b. Interfaces

- Similar to Java 8 onwards. 
- Can have default implementations.
- Can define abstract properties but cannot have a state for it.
- However, we can define custom getters and setters on interface properties. But properties inside interfaces doesn't have a backing `field`.

    ```kotlin
        interface CustomerRepo {
            // Interfaces cannot maintain state, but can have custom getters & setters
            var isEmpty : Boolean
                get() = true
                set(value){
                    println("Doing something with the value $value")
                }
            // This is a default implementation
            fun load(obj: Customer){
                println("Loading Customer Data")
            }
        
            fun getById(id: Int) : Customer
        }
    ```

- When a class implements multiple interfaces, say A and B, and both have a method with the same name, say foo(), then Kotlin provides a way for the implementing class to resolve the conflict by specifying the interfaces in Angular brackets <>.

    ```kotlin
        interface A {
            fun foo() { print("A") }
            fun bar()
        }
        interface B {
            fun foo() { print("B") }
            fun bar() { print("bar") }
        }
        class C : A {
            override fun bar() { print("bar") }
        }
        class D : A, B {
            override fun foo() {
                super<A>.foo()
                super<B>.foo()
            }
            override fun bar() {
                super<B>.bar()
            }
        }
    ```

> **Difference between Abstract Classes and Interfaces**:
>   
> In both abstract classes and interfaces, we can define abstract methods as well as provide default implementation of some methods. But below are the major differences between them - 
>   - In abstract classes we can maintain state, but in interfaces we cannot. We can define properties inside an interface, but we cannot maintain value or state inside it.
>   - Secondly we can have a class that implements multiple interfaces, but it can extend only one class. 
>   

[Additional Reading](https://kotlinlang.org/docs/reference/interfaces.html)

### 4.c. Generics

- Similar to Java. Will revisit later in details.

    ```kotlin
        interface Repository<T> {
            fun getById(id: Int): T
            fun getAll(): List<T>
            fun<U> getAddDataById(id: Int) : U
        }
        
        class GenericRepo<T> : Repository<T> {
            override fun getById(id: Int): T {
                println("Getting by id = $id ")
                throw UnsupportedOperationException("Not implemented")
            }
            override fun getAll(): List<T> {
                println("Fetching all")
                throw UnsupportedOperationException("Not implemented")
            }  
            override fun <U> getAddDataById(id: Int): U {
                println("Getting additional data by Id")
                throw UnsupportedOperationException("Not implemented")
            }
        }
        
        fun main() {
            val customerRepo = GenericRepo<Customer>()
            val employeeRepo = GenericRepo<EmployeeEntity>()
            customerRepo.getById(10)
            employeeRepo.getAll()
            employeeRepo.getAddDataById<EmployeeAddData>(22)
        }
    ```

<br/> 

## 5. Nulls

- Kotlin is a null-safe language.
- We cannot return `null` from a function nor pass `null` as an argument in Kotlin.
- Every non-nullable type has a nullable counterpart suffixed by `?`
- In order to return a `null` from a function the return type can be changed to its nullable counterpart by suffixing with `?`.

    ```kotlin
      fun nickName(name: String?) : String? {}
    ```
  
- Kotlin requires method calls on nullable references to be prefixed with either the safe-call operator or the non-null assertion operator.
    - **Safe-call operator (?):** The null-check and call to a method or a property can be done using the Safe call operator in one step. If the reference is null, then the safe-call operator will return null. But when using the **Elvis Operator (?:)**, we can return a default value in case of null.
  
        ```kotlin
          return name?.reversed()?.toUpperCase()?:"Joker"
        ```
      
    - **Non-Null operator (!!) : DO NOT USE THIS OPERATOR.** This operator can be used when we don't want Kotlin to do a null check. 

[Kotlin Docs - Null Safety](https://kotlinlang.org/docs/reference/null-safety.html)    
[Additional Reading](https://learning.oreilly.com/library/view/programming-kotlin/9781680507287/f_0051.xhtml)
    
<br/> 

## 6. Some useful language constructs

> In this section we will take a look at some of the useful language constructs that Kotlin provides, which will help us deepen our understanding of the further sections

### 6.a. Type casting

- We can check whether an object conforms to a given type at runtime by using the `is` operator or its negated form `!is`
- **Smart Casts:**
    - The Kotlin compiler tracks `is`-checks and explicit casts for immuatable values and automatically inserts safe-casts

        ```kotlin
            fun demo(x: Any) {
                if (x is String) {
                    print(x.length) // x is automatically cast to String
                }
            }
        ```
    
    - The compiler is smart enough to know a cast to be safe if a negative check leads to a return

        ```kotlin
            if (x !is String) return            
            print(x.length) // x is automatically cast to String
        ```
              
    - or in the right-hand side of `&&` and `||`

        ```kotlin
            // x is automatically cast to string on the right-hand side of `||`
            if (x !is String || x.length == 0) return
        ```
      
    - Such smart casts work for when-expressions and while-loops as well
    
        ```kotlin
            when (x) {
                is Int -> print(x + 1)
                is String -> print(x.length + 1)
                is IntArray -> print(x.sum())
            }
        ```  
      
- **Safe (nullable) cast operator:**
    - Illegal casting throws an exception. Such casting is called unsafe cast. Unsafe cast is done in Kotlin using the **infix operator `as`**.
    - To avoid unsafe cast we can use safe cast using **as?** that returns `null` on failure

        ```kotlin
          val x: String? = y as String?
        ```
      
[Additional Reading](https://kotlinlang.org/docs/reference/typecasts.html)

### 6.b. Tuples - `Pair` & `Triple`

- Kotlin provides two specific types: `Pair` for a tuple of size two and `Triple` for a size of three to quickly create two or three objects as a collection

    ```kotlin
          println(Pair("Tom", "Jerry"))
    ```
- Both `Pair` and `Triple` are immutable and are useful to create a grouping of two and three values, respectively.
- For creating more than three immutable values, then `data` class is the option.

[Additional Reading](https://learning.oreilly.com/library/view/programming-kotlin/9781680507287/f_0043.xhtml#sec.pair)

### 6.c. Destructuring

- Destructuring is to extract values into variables from an existing object.
- The destructuring in Kotlin is based on the position of properties. In JavaScript object destructuring is based on name of properties. 
- We can skip properties while destructuring by putting underscores`(_)`

    ```kotlin
        fun getFullName() = Triple("John", "Quincy", "Adams")
        val (first, middle, last) = getFullName()
        val (f,_, l) = getFullName()    
    ```

[Additional Reading](https://kotlinlang.org/docs/reference/multi-declarations.html)

### 6.d. Exceptions 

- All exception classes in Kotlin are descendants of the class `Throwable`.
- Kotlin does not have checked exceptions.
- Every exception has a message, stack trace and an optional cause.
- Sample exception block

    ```kotlin
        try {
            // some code
        }
        catch (e: SomeException) {
            // handler
        }
        finally {
            // optional finally block
        }
    ```
  
- `try` is an expression, i.e., it can return a value
- The returned value of a try-expression is either the last expression in the `try` block or the last expression in the `catch` block (or blocks). Contents of the `finally` block do not affect the result of the expression.
- `throw` is an expression in Kotlin that returns a special type `Nothing`.

    ```kotlin
        fun fail(message: String): Nothing {
            throw IllegalArgumentException(message)
        }
        val s = person.name ?: fail("Name required")
        println(s)     // 's' is known to be initialized at this point
    ```
  
[Additional Reading](https://kotlinlang.org/docs/reference/exceptions.html)

<br/> 

## 7. Functional Style

> We'll get functional in this section. Learn about some key concepts how Kotlin supports functional programming.

### 7.a. Higher Order Functions

- A higher order function is a function that can takes a function as an argument, or return a function.  
- In Kotlin, method references are denoted as `::` and lambda expressions are expressed with "->", similar to Java.
- We can pass a method reference or a lambda expression to a function that accepts a function as an argument.


### 7.b. Lambda Expressions

- For single parameter in a lambda expression, we don't have to explicitly define the parameter in the lambda expression. Instead we can refer to the parameter as `it` in the body of the expression. Let's see an example -

    ```kotlin
        someFunc(3, {x -> x*x})
        someFunc(3, {it * it})
    ```
  
- **Dropping the brackets** when calling higher-order function:  
     - When the last or the only parameter of a function is a function, then when calling the higher-order function, the function parameter can be passed outside the parentheses of the function call

    ```kotlin
        operation(5) { it * it }
    ```

- In lambdas as well we can use object destructuring


### 7.c. Anonymous Functions

- We can pass functions with no names as a parameter to higher-order functions. These are called anonymous functions.
- The difference with a lambda function and anonymous function is that in anonymous functions we can have multiple return points, but lambdas have just one.

    ```kotlin
        operation(7, fun(x): Int {
            if (x < 0)
                return 0
            else
                return Math.sqrt(x.toDouble()).toInt()
        })
    ```

### 7.d. Closures

- A lambda expression or anonymous function (as well as a local function and an object expression) can access its closure, i.e. the variables declared in the outer scope, also known as *lexical scoping*. 
- The variables captured in the closure can be modified in the lambda. Such a lambda is called closure.

> **Note**
>
> Keep closure as pure functions to avoid confusion and to minimize errors

[Additional Reading](https://kotlinlang.org/docs/reference/lambdas.html)

### 7.e. Extension Functions

- Extension function allows extending functionality of class without inheriting from it.
- Scope of exception functions is packages. In order to use outside the package, we need to import the package with the extension function.
- Member function takes precedence over extension function when both have same names and definition.
- Extensions are resolved **statically**. By defining an extension, we do not insert new members into a class, but merely make new functions callable with the dot-notation on variables of this type.

[Additional Reading](https://kotlinlang.org/docs/reference/extensions.html)

<br/> 

## 8. Interoperability

> Kotlin is 100% interoperable with Java. Its 2 way - Java to Kotlin and Kotlin to Java as well.

### 8.a. Java in Kotlin

[Additional Reading](https://kotlinlang.org/docs/reference/java-interop.html)

### 8.b. Working with nulls from Java

- Java nullable types become Platform types in Kotlin

### 8.c. Kotlin in Java

- Properties in Kotlin will automatically be converted to corresponding get() and set() methods when the same is used inside a Java class.
- **`@JvmField`**: For properties defined inside Kotlin code to be accessible from Java, this annotation in Kotlin code will help discover the property in Java code
- **`@JvmOverloads`**: For default parameters defined in Kotlin methods, Java won't have direct access to the overloaded method without specifying value for the default parameter. With `@JvmOverloads` annotation on the Kotlin method, Java class will now have access to the overloaded method without that particular default parameter. 
- **`@JvmName`**: Kotlin provides us with a feature of having a different name to a particular method when a method is referenced inside a Java code by using the `@JvmName` annotation.
- **`@Throws`**: When an exception is thrown from a method in Kotlin, the same needs to be annotated with `@Throws` in order for the Java class to handle it.

[Additional Reading](https://kotlinlang.org/docs/reference/java-to-kotlin-interop.html)


### 8.d. Top-level functions & properties in Kotlin

- Top level functions when compiled by default generates a bytecode file with name <filename>Kt.class. 
- In order to reference these functions inside Java we can simply call the function as <filename>Kt.functionName().
- In order to change the name of the default class name we can use the annotation at the top of the Kotlin file -

    ```kotlin
      @file:JvmName("MyKotlinClass")
    ```
  
- Top level properties can again be accessed by default using get() and set() methods inside Java.
- In case we want to access the property as a field name in Java class, then the same needs to be prefixed using `const` in the Kotlin file.

### 8.e. Extension functions from Java

- Extension functions can be accessed from Java using the Kotlin-className.functionName() similar to accessing a static method in Java.

<br/> 

## 9. Standard Library

### 9.a. Kotlin Std Library & Collections

<img src="./images/collections.png"/>

- Kotlin has a very small standard library (~800Kb).
- Kotlin does not have its own collections. What it has is some interfaces on top of Java collections - 
    - Mutable 
    - Immutable
- Collections are 
    - List
    - Array (including equivalent primitive type)
    - Set
    - Map
    - HashMap
    - HashSet, etc...
    
- Use Kotlin helper functions when working with Collections. It automatically determines which class to call. For example when defining an empty list using `emptyList<>()`, it uses `kotlin.collections.EmptyList`, whereas when defining using `Arrays.asList()` it uses `java.util.Arrays$ArrayList`

[Additional Reading](https://kotlinlang.org/docs/reference/collections-overview.html)
    
### 9.b. Collection Common Operations

- Common operations are available for both read-only and mutable collections. Common operations fall into these groups:
    - [Transformations](https://kotlinlang.org/docs/reference/collection-transformations.html)
    - [Filtering](https://kotlinlang.org/docs/reference/collection-filtering.html)
    - [plus and minus operators](https://kotlinlang.org/docs/reference/collection-plus-minus.html)
    - [Grouping](https://kotlinlang.org/docs/reference/collection-grouping.html)
    - [Retrieving collection parts](https://kotlinlang.org/docs/reference/collection-parts.html)
    - [Retrieving single elements](https://kotlinlang.org/docs/reference/collection-elements.html)
    - [Ordering](https://kotlinlang.org/docs/reference/collection-ordering.html)
    - [Aggregate operations](https://kotlinlang.org/docs/reference/collection-aggregate.html)
    - [Write Operations](https://kotlinlang.org/docs/reference/collection-write.html)
    - [List Operations](https://kotlinlang.org/docs/reference/list-operations.html)
    - [Set Operations](https://kotlinlang.org/docs/reference/set-operations.html)
    - [Map Operations](https://kotlinlang.org/docs/reference/map-operations.html)
    
- Some of the more frequently used operations are - 
    - `forEach`
    - `map`
    - `filter`
    - `reduce`
    - `flatMap`
    - `take`, etc...

[Additional Reading](https://kotlinlang.org/docs/reference/collection-operations.html)

### Sequences - Lazy Evaluation

- Sequences are equivalent to Java Streams
- Parallel sequences is not available on Kotlin
- Using sequences for evaluating collections lazily -
    - `asSequence()`
    - `generateSequence()`
    - `lazy()`, etc...

[Additional Reading](https://kotlinlang.org/docs/reference/sequences.html)

### String Extensions

- A bunch of String manipulation functions are available in Kotlin. Check it out here - 
    [Kotlin String Functions](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/)

- Some utility functions to checkout -
    - `run()` 
    - `with()`
    - `apply()`
    - `let()`, etc...
    
[Additional Reading](https://kotlinlang.org/docs/tutorials/kotlin-for-py/functional-programming.html#nice-utility-functions)

<br/> 

## 10. Build Tools

- We can use standard build tools like Ant, Maven, Gradle, etc to build Kotlin projects.

<br/> 
<br/> 


# **Part II -  Some Advanced Concepts**

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
 
