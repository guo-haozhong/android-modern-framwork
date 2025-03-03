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
fun MainScreen(viewModel: MainViewModel) {
    val todo by viewModel.todoLiveData.collectAsState(initial = null)

    LaunchedEffect(Unit) {
        viewModel.fetchTodo()
    }

    todo?.let {
        Column(
            modifier = Modifier.fillMaxSize(),
            verticalArrangement = Arrangement.Center,

        ) {
            Text(text = "request api result::\n", modifier = Modifier.padding(20.dp,0.dp))
            Text(text = "id: ${it.id}", modifier = Modifier.padding(20.dp,0.dp))
            Text(text = "userId: ${it.userId}", modifier = Modifier.padding(20.dp,0.dp))
            Text(text = "Title: ${it.title}", modifier = Modifier.padding(20.dp,0.dp))
            Text(text = "Completed: ${if (it.completed) "Yes" else "No"}", modifier = Modifier.padding(20.dp,0.dp))
        }
    }
}
