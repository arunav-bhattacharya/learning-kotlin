package com.arunav.kotlin.inheritance

interface Remote { fun up()
    fun down()
    fun doubleUp() {
        up()
        up()
    }
}

class TV {
    var volume = 0
}

class TVRemote(val tv: TV) : Remote {
    override fun up() { tv.volume++ }
    override fun down() { tv.volume-- }
}

fun main(){

    val tv = TV()
    val tvRemote = TVRemote(tv)
    tvRemote.doubleUp()
    println("TV volume after doubling up=${tv.volume}")
    tvRemote.down()
    println("TV volume after down=${tv.volume}")


}