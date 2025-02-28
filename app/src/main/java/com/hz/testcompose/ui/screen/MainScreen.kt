package com.hz.testcompose.ui.screen

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.hz.testcompose.ui.viewModel.MainViewModel


@Composable
fun MainScreen() {
    val viewModel: MainViewModel = viewModel()

    // 监听ViewModel的状态
    LaunchedEffect(Unit) {
        viewModel.loadUser()
    }

    val user by remember { viewModel.userState }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        if (user != null) {
            Text(text = "Name: ${user!!.name}")
            Text(text = "Age: ${user!!.age}")
        } else {
            CircularProgressIndicator(modifier = Modifier.size(48.dp))
        }
    }
}
