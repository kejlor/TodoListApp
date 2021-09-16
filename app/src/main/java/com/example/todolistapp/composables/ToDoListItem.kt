package com.example.todolistapp.composables

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.material.MaterialTheme.typography
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.toMutableStateList
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.example.todolistapp.data.DataProvider
import com.example.todolistapp.models.ToDo
import androidx.compose.runtime.*
import androidx.compose.ui.text.style.TextOverflow

@ExperimentalMaterialApi
@Composable
fun CreateToDoListItem(todo: ToDo) {
    Card(
        modifier = Modifier
            .padding(horizontal = 30.dp, vertical = 0.dp)
            .fillMaxWidth(),
        elevation = 0.dp,
        backgroundColor = Color(0xff694598),
        shape = RoundedCornerShape(
            topStart = 30.dp,
            topEnd = 30.dp,
            bottomStart = 30.dp,
            bottomEnd = 0.dp
        )
    ) {
        Row {
            Column(
                modifier = Modifier
                    .padding(16.dp)
                    .fillMaxWidth()
                    .align(Alignment.CenterVertically)
            ) {
                Text(text = todo.title, style = typography.h6)
                Text(text = todo.description, style = typography.caption)
            }
        }
    }
}
