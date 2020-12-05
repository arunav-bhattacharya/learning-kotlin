package com.arunav.kotlin.delegates

interface Snappable {
    fun snap(): String
}

class Camera : Snappable {
    override fun snap() = "snapping..."
}

interface Callable {
    fun call(name: String): String
}

interface Video {
    fun video(name: String): String
}

class Phone : Callable {
    override fun call(name: String) = "calling ".plus(name).plus("...")
}

class FaceTime : Callable, Video {
    override fun call(name: String) = "facetiming ".plus(name).plus("...")
    override fun video(name: String) = "facetime video ".plus(name).plus("...")
}

class SmartPhone(
    camera: Camera, // this is a parameter as no val is provided
    private val faceTime: FaceTime = FaceTime(), // this is a property as it is defined as val
    private val callable: Callable = Phone() // this is again a property as it is defined as val
) : Snappable by camera, Video by faceTime, Callable by callable {

    override fun call(name: String) = try {
        callable.call(name)
    } catch (e: RuntimeException) {
        faceTime.call(name)
    }

}

fun main() {
    val smartPhone = SmartPhone(Camera())
    var snappable: Snappable = Camera()
    snappable = smartPhone
}