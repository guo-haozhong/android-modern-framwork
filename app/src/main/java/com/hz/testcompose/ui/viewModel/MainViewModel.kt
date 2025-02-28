package com.hz.testcompose.ui.viewModel

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.hz.example.data.local.User
import com.hz.example.data.repository.UserRepository
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

class MainViewModel(private val userRepository: UserRepository = UserRepository()) : ViewModel() {
    private val _userState = mutableStateOf<User?>(null)
    val userState: MutableState<User?> = _userState

    fun loadUser() {
        viewModelScope.launch {
            _userState.value = userRepository.fetchUser()
        }
    }
}