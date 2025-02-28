package com.hz.example.ui.view

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.hz.example.data.local.User
import com.hz.example.data.repository.UserRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

class UserViewModel @Inject constructor(
    private val userRepository: UserRepository
) : ViewModel() {

    private val _users = MutableStateFlow<List<User>>(emptyList())
    val users: StateFlow<List<User>> get() = _users

    fun getUsers() {
        viewModelScope.launch {
            userRepository.getUsersFromDb().collect { dbUsers ->
                if (dbUsers.isEmpty()) {
                    val apiUsers = userRepository.getUsersFromApi()
                    _users.value = apiUsers
                    apiUsers.forEach { userRepository.insertUser(it) }
                } else {
                    _users.value = dbUsers
                }
            }
        }
    }


}