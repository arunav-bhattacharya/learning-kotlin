package com.arunav.kotlin.advanced.functions

class Request(var query: String, var param: String, var body: String)
class Response(var body: String, var status: ResponseStatus) {
    operator fun invoke(status: ResponseStatus.() -> Unit) {

    }
}

class ResponseStatus(var code: Int, var description: String)
class RouteHandler(var request: Request, var response: Response)

// Defining an extension function on RouteHandler
fun handleRoutes(path: String, func: RouteHandler.() -> Unit): RouteHandler.() -> Unit = func

fun main() {

    handleRoutes("/index.html") {
        if (request.query != "") {
            println("Processing")
            // process request.body
        }

        println("Generating Response..")
        response {
            code = 200
            description = "Processed"

        }
    }
}