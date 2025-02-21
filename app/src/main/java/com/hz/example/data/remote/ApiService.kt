package com.hz.example.data.remote

import com.hz.example.data.model.DataModel
import retrofit2.Response
import retrofit2.http.GET

interface ApiService {
    @GET("endpoint")
    suspend fun getData(): Response<DataModel>
}