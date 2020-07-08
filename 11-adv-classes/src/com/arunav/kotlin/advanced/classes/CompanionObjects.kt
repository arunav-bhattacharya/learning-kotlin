package com.arunav.kotlin.advanced.classes

class Log private constructor() {

    companion object Factory {
        fun createFileLog(fileName: String): Log = Log(fileName)

        fun getFileLogs(): List<String> {
            return emptyList()
        }
    }

    constructor(fileName: String) : this() {}
}

fun main() {

    Log.createFileLog("file.txt")
    Log.getFileLogs()
}