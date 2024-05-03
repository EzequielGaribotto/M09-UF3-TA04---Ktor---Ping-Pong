package com.example.routes

import com.example.models.Message
import io.ktor.http.*
import io.ktor.server.application.*
import io.ktor.server.request.*
import io.ktor.server.response.*
import io.ktor.server.routing.*

fun Route.messagesRouting() {
    var missatgeEmmagatzemat:Message? = null
    route("/message") {
        post {
            missatgeEmmagatzemat = call.receive<Message>()
            call.respond(HttpStatusCode.Created, missatgeEmmagatzemat!!)
        }
        get {
            missatgeEmmagatzemat?.let {
                call.respond(it)
            } ?: call.respond(HttpStatusCode.NotFound)
        }
    }
}