package com.hz.testcompose.data.network

import com.hz.testcompose.data.local.Todo
import retrofit2.http.GET
import retrofit2.http.Path

interface ApiService {
    @GET("todos/1")
    suspend fun getTodo(): Todo

    @GET("todos/{id}")
    suspend fun getTodoById(@Path("id") id: Int): Todo
}