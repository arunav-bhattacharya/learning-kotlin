package com.arunav.kotlin.async.example

import kotlinx.coroutines.*
import kotlin.system.measureTimeMillis

fun main() {
    syncCall()
    asyncCall()
    launchError()
    launchErrorWithHandler()
}

fun syncCall() {
    println("\nsync call")
    val format = "%-10s%-20s%-10s"
    println(String.format(format, "Code", "Temperature", "Delay"))

    val time = measureTimeMillis {
        val airportCodes = listOf("DAL", "SEA", "DEN", "PDX")

        val airportData: List<Airport> =
            airportCodes.mapNotNull { anAirportCode ->
                Airport.getAirportData(anAirportCode)
            }

        airportData.forEach { airport ->
            println(String.format(format, airport.code, airport.weather.temperature.get(0), airport.delay))
        }
    }
    println("Total timeTaken = $time ms")
}

fun asyncCall() {

    println("\nasync call")
    runBlocking {
        val format = "%-10s%-20s%-10s"
        println(String.format(format, "Code", "Temperature", "Delay"))

        val time = measureTimeMillis {
            val airportCodes = listOf("LAX", "SFO", "PHX", "JFK")

            val airportData: List<Deferred<Airport?>> =
                airportCodes.map { anAirportCode ->
                    async(Dispatchers.IO) { Airport.getAirportData(anAirportCode) }
                }

            airportData.mapNotNull { airportData -> airportData.await() }
                .forEach { airport ->
                    println(String.format(format, airport.code, airport.weather.temperature.get(0), airport.delay))
                }
        }
        println("Total timeTaken = $time ms")
    }
}


// launch returns a Job object that represents the coroutine it starts. We use that Job object to wait for the coroutine
// to either complete successfully or with failure.
// The coroutines that are started with launch doesn't get propagated to the caller, hence the exception thrown from
// the method getAirportData() doesn't get propagated here.
fun launchError() {
    println("\nlaunch Error call")

    runBlocking {
        try {
            val airportCodes = listOf("LAX", "SFP", "DAL", "AU-")

            val jobs: List<Job> = airportCodes.map { airport ->
                launch(Dispatchers.IO + SupervisorJob()) {
                    val airport = Airport.getAirportData(airport)
                    println("Airport Code: ${airport?.code} Delay: ${airport?.delay}")
                }
            }

            jobs.forEach { it.join() }

            // Printing the jobs which got cancelled
            jobs.forEach { println("Cancelled: ${it.isCancelled}") }
        } catch (ex: Exception) {
            println("Error: ${ex.message}")
        }
    }
}

fun launchErrorWithHandler() {

    println("\nlaunch Error with Handler call")

    runBlocking {
        val handler = CoroutineExceptionHandler { context, ex ->
            println("Exception Caught in=${context[CoroutineName]}  Message=${ex.message?.substring(0..28)}")
        }

        try {
            val airportCodes = listOf("LAX", "SFP", "DAL", "AU-")

            val jobs: List<Job> = airportCodes.map { airport ->
                launch(Dispatchers.IO + CoroutineName(airport) + handler + SupervisorJob()) {
                    val airport = Airport.getAirportData(airport)
                    println("Airport Code: ${airport?.code} Delay: ${airport?.delay}")
                }
            }

            jobs.forEach { it.join() }

            // Printing the jobs which got cancelled
            jobs.forEach { println("Cancelled: ${it.isCancelled}") }
        } catch (ex: Exception) {
            println("Error: ${ex.message}")
        }
    }
}

