package com.example.todolistapp

import android.app.Application
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Scaffold
import androidx.compose.material.Surface
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.platform.LocalContext
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.todolistapp.composables.TodoAppContent
import com.example.todolistapp.ui.theme.TodoListAppTheme
import com.example.todolistapp.viewmodels.TodoViewModel
import com.example.todolistapp.viewmodels.TodoViewModelFactory

class MainActivity : ComponentActivity() {
    @ExperimentalMaterialApi
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            val context = LocalContext.current
            val mTodoViewModel: TodoViewModel = viewModel(
                factory = TodoViewModelFactory(context.applicationContext as Application)
            )

            val todos = mTodoViewModel.readAllData.observeAsState(listOf()).value
            TodoListAppTheme {
                // A surface container using the 'background' color from the theme
                Surface(color = MaterialTheme.colors.background) {
                    Scaffold(content = {
                        TodoAppContent(
                            todos = todos,
                            mTodoViewModel = mTodoViewModel
                        )
                    })
                }
            }
        }
    }
}