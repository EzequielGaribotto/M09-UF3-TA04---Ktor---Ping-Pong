package com.example.clients.retrofit

import com.example.models.Message
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST

interface ApiService {
    @POST("/message")
    suspend fun postMessage(@Body message: Message)

    @GET("/message")
    suspend fun getMessage(): Message
}