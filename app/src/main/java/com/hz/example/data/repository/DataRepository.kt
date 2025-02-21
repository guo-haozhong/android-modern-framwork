package com.hz.example.data.repository

import com.hz.example.data.local.DataDao
import com.hz.example.data.model.DataModel
import com.hz.example.data.remote.ApiService
import javax.inject.Inject

class DataRepository @Inject constructor(
    private val apiService: ApiService,
    private val dataDao: DataDao
) {

    suspend fun fetchData(): List<DataModel> {
        val response = apiService.getData()
        if (response.isSuccessful) {
            response.body()?.let {
                dataDao.insertData(it)
            }
        }
        return dataDao.getData()
    }
}