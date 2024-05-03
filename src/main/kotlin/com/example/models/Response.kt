package com.example.models

import io.ktor.http.*

data class Response(val message: String, val status: HttpStatusCode)
