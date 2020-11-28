package com.arunav.kotlin.inheritance

import java.lang.Exception

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
    try {
        customerRepo.getById(10)
    } catch (ex : Exception){
        println(ex.message)
    }

    try {
        employeeRepo.getAll()
    } catch (ex : Exception){
        println(ex.message)
    }

    try {
        employeeRepo.getAddDataById<EmployeeEntity>(22)
    } catch (ex : Exception){
        println(ex.message)
    }
}