package com.hz.testcompose.ui.viewModel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.hz.testcompose.data.local.Todo
import com.hz.testcompose.data.repository.MainRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(
    private val repository: MainRepository
) : ViewModel() {
    private val _todoLiveData = MutableStateFlow<Todo?>(null)
    val todoLiveData: StateFlow<Todo?> = _todoLiveData

    fun fetchTodo() {
        viewModelScope.launch {
            //fetch api data
            val todo = repository.fetchTodoFromNetwork()
            //write to db
//            repository.insertTodoinDB(todo)

            _todoLiveData.value = todo
        }
    }

    fun getAllTodos() {
        viewModelScope.launch {
            val todos = repository.getAllTodosFromDB()

        }
    }
}