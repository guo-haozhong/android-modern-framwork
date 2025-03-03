package com.hz.testcompose.data.network

import com.hz.testcompose.data.local.Todo
import retrofit2.http.GET

interface ApiService {
    @GET("todos/1")
    suspend fun getTodo(): Todo
}