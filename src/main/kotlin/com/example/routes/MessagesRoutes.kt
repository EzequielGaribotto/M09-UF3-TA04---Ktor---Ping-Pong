package com.example.routes

import com.example.models.Message
import com.example.models.Response
import io.ktor.http.*
import io.ktor.server.application.*
import io.ktor.server.request.*
import io.ktor.server.response.*
import io.ktor.server.routing.*

fun Route.messagesRouting(messages:MutableList<Message>) {
    route("/message") {
        post {
            val message = call.receive<Message>()
            messages.add(message)
            call.respond(HttpStatusCode.Created)
        }
        get {
            if (messages.isNotEmpty()) {
                call.respond(HttpStatusCode.OK, messages.removeAt(0))
            } else {
                call.respond(HttpStatusCode.NotFound)
            }
        }
        get("/message") {
            call.respond(Response("Hello, world!", HttpStatusCode.OK))
        }
    }
}