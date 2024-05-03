package com.example.clients.ktor

import com.example.models.Message
import io.ktor.client.*
import io.ktor.client.engine.cio.*
import io.ktor.client.request.*
import io.ktor.client.statement.*
import io.ktor.http.*
import kotlinx.serialization.json.Json
import kotlinx.coroutines.runBlocking
import kotlinx.serialization.encodeToString

fun main() = runBlocking {
    val client = HttpClient(CIO)
    while (true) {
        Thread.sleep(1000)

        val message = Message("Ping!")
        var response: HttpResponse = client.post("http://localhost:8080/message") {
            url("http://localhost:8080/message")
            contentType(ContentType.Application.Json)
            setBody(Json.encodeToString(message))
        }

        println("Status després del POST: ${response.status}")

        response = client.get("http://localhost:8080/message")
        println("Status després del GET: ${response.status}")

        val msg = Json.decodeFromString<Message>(response.bodyAsText())
        println("MISSATGE: ${msg.content}")
    }
    client.close()
}