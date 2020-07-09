package com.arunav.kotlin.delegates

interface Worker {
    fun work()
    fun timesheets()
    fun takeVacation() {
        println("${this.javaClass.simpleName} enjoying vacation")
    }
}

interface Assistant {

    fun doChores()
    fun timesheets()
}

class KotlinDeveloper : Worker {
    override fun work() {
        println("Building Kotlin Apps")
    }

    override fun timesheets() {
        println("Boring..")
    }
}

class JavaDeveloper : Worker {
    override fun work() {
        println("Building Java Apps")
    }

    override fun timesheets() {
        println("Boring..")
    }
}

class DepartmentAssitant : Assistant{
    override fun doChores() {
        println("Doing regular stuff")
    }
    override fun timesheets() {
        println("Definitely")
    }
}

class Manager(val worker: Worker, val assistant: Assistant) : Worker by worker, Assistant by assistant {
    fun meeting() = println("Meeting with ${worker.javaClass.simpleName}")
    override fun takeVacation() = println("Vacation granted to ${worker.javaClass.simpleName} ")
    override fun timesheets() {
        assistant.timesheets()
        worker.timesheets()
    }
}

fun main() {
    // Manager delegating to Java developer
    var manager = Manager(JavaDeveloper(), DepartmentAssitant())
    manager.work()
    manager.takeVacation()
    manager.meeting()
    manager.timesheets()

    println("------------------------")
    // Manager delegating to Kotlin developer
    manager = Manager(KotlinDeveloper(), DepartmentAssitant())
    manager.work()
    manager.takeVacation()
    manager.meeting()
    manager.timesheets()
}
