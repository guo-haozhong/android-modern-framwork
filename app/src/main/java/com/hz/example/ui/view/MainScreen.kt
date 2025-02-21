package com.hz.example.ui.view

import androidx.compose.foundation.layout.Column
import androidx.compose.material.Text

import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.hilt.navigation.compose.hiltViewModel
import com.hz.example.data.remote.ApiService

@Composable
fun MainScreen(viewModel: ApiService = hiltViewModel()) {
    val data by viewModel.data.collectAsState()

    Column {
        data.forEach {
            Text(text = it.name)
        }
    }
}