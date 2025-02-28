package com.hz.example.data.network

import com.hz.example.data.local.User
import retrofit2.http.GET

interface ApiService {
    @GET("users")
    suspend fun getUsers(): List<User>
}