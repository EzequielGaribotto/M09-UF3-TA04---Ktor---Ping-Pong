package com.example.plugins

import com.example.models.Message
import com.example.routes.messagesRouting
import io.ktor.server.application.*
import io.ktor.server.routing.*

fun Application.configureRouting(messages:MutableList<Message>) {
    routing {
        messagesRouting(messages)
    }
}
