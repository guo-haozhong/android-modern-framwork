package com.hz.example.data.repository

import com.hz.example.data.local.User
import kotlinx.coroutines.delay


class UserRepository {
    // 模拟网络请求
    suspend fun fetchUser(): User {
        delay( 1000) // 模拟网络延迟
        return User(id=1,name = "John Doe", age = 30)
    }
}
