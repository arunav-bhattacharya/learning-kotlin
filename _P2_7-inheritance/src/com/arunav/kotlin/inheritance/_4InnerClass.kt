package com.arunav.kotlin.inheritance

fun main(){
    val tv = _TV()
    val remote = tv.remote // Accessing the remote property in _TV

    // Initial state
    println("$tv")
    println(remote)

    // Volume Up
    remote.up()
    remote.doubleUp()
    println("After increasing $tv")
    println(remote)

    // Volume down
    remote.down()
    println("After decreasing $tv")
    println(remote)
}

class _TV {
    private var volume = 0

    val remote: Remote
        get() = _TVRemote()

    override fun toString() = "Volume : ${volume}"

    inner class _TVRemote : Remote {
        override fun up() {
            volume++
        }

        override fun down() {
            volume--;
        }

        // Inner class overriding the outer class method. When accessing outer class members,
        // we can use the syntax this@OuterClass
        override fun toString() = "Remote: ${this@_TV.toString()}"
    }
}