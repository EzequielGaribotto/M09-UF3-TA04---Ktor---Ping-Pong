package com.example

import com.example.models.Message
import com.example.plugins.*
import com.example.routes.messagesRouting
import io.ktor.server.application.*
import io.ktor.server.engine.*
import io.ktor.server.netty.*
import io.ktor.server.routing.*

val messages = mutableListOf<Message>()
fun main() {
    embeddedServer(Netty, port = 8080, host = "0.0.0.0", module = Application::module)
        .start(wait = true)
}

fun Application.module() {
    configureRouting(messages)
    configureSerialization()
}


