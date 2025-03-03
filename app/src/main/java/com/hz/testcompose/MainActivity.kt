package com.hz.testcompose

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.activity.viewModels
import androidx.compose.material.Surface
import com.hz.testcompose.ui.screen.MainScreen
import com.hz.testcompose.ui.theme.TestComposeTheme
import com.hz.testcompose.ui.viewModel.MainViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    val viewModel: MainViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        setContent {
            TestComposeTheme {
                Surface {
                    MainScreen(viewModel)
                }
            }
        }
//        viewModel.fetchTodo()

    }
}
