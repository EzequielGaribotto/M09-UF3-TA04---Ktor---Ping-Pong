package com.example.clients.retrofit

import com.example.models.Message
import kotlinx.coroutines.runBlocking
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

fun main() = runBlocking {
    while (true) {
        Thread.sleep(1000)
        val retrofit = Retrofit.Builder()
            .baseUrl("http://localhost:8080")
            .addConverterFactory(GsonConverterFactory.create())
            .build()

        val service = retrofit.create(ApiService::class.java)

        val message = Message("RetroPing!")
        service.postMessage(message)
        println("POST status: Success")

        val response = service.getMessage()
        println("GET message: ${response.content}")
    }
}