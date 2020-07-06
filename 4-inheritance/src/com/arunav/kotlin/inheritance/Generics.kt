package com.arunav.kotlin.inheritance

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
    employeeRepo.getAddDataById<EmployeeEntity>(22)
}
