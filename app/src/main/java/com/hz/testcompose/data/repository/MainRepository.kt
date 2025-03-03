package com.hz.testcompose.data.repository

import com.hz.testcompose.data.local.Todo
import com.hz.testcompose.data.local.TodoDao
import com.hz.testcompose.data.network.ApiService
import javax.inject.Inject


class MainRepository @Inject constructor(
    private val apiService: ApiService,
    private val todoDao: TodoDao
){
    suspend fun fetchTodoFromNetwork(): Todo {
        return apiService.getTodo()
    }

    suspend fun insertTodoinDB(todo: Todo){
        todoDao.insert(todo)
    }

    suspend fun getAllTodosFromDB():List<Todo>{
        return todoDao.getAllTodos()
    }
}
