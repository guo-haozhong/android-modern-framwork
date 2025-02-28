package com.hz.example.data.repository

import com.hz.example.data.local.User
import com.hz.example.data.local.UserDao
import com.hz.example.data.network.ApiService
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.withContext
import java.lang.Thread.sleep
import javax.inject.Inject


class UserRepository @Inject constructor(
    private val userDao: UserDao,
    private val apiService: ApiService
) {
    fun getUsersFromDb(): Flow<List<User>> {
        return userDao.getAllUsers()
    }

    suspend fun getUsersFromApi(): List<User> {
        return listOf(
            User(id=1, name = "ALice", age = 28),
            User(id=2, name = "Bob", age = 39),
            User(id=3, name = "Charlie", age = 24)
        )
//        return apiService.getUsers()
    }

    suspend fun insertUser(user: User): Long {
        return userDao.insertUser(user)
    }
}