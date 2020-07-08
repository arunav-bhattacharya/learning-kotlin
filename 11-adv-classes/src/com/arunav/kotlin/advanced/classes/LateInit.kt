package com.arunav.kotlin.advanced.classes

import java.util.ArrayList


fun main() {

    lateinit var repository: Repository

    repository = SQLRepository()

    repository.getAll()
    repository.getById(2)
}

interface Repository {

    fun getById(id: Int)

    fun getAll(): List<Int>
}

class SQLRepository : Repository {
    override fun getById(id: Int) {
        //
    }

    override fun getAll(): List<Int> {
        return emptyList()
    }

}