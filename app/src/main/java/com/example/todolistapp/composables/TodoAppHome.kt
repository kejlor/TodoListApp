package com.example.todolistapp.composables

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.toMutableStateList
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.example.todolistapp.data.DataProvider
import com.example.todolistapp.models.ToDo

@ExperimentalMaterialApi
@Composable
fun TodoAppContent() {
    val todos = remember { (DataProvider.listOfToDoEntries.toMutableStateList()) }
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color(0xff503d69))
    ) {
        LazyColumn(
            contentPadding = PaddingValues(horizontal = 16.dp, vertical = 0.dp),
            modifier = Modifier
                .weight(1f), horizontalAlignment = Alignment.End
        ) {
            items(items = todos, itemContent = { CreateToDoListItem(todo = it)
                OutlinedButton(
                    onClick = { todos.remove(it) },
                    modifier = Modifier
                        .size(40.dp),
                    colors = ButtonDefaults.buttonColors(backgroundColor = Color(0xffc1b6d1)),
                    shape = CircleShape
                ) {
                    Text(text = "X")
                }
            })
        }
        Button(
            onClick = {todos.add(ToDo("pepega", "kekega"))},
            modifier = Modifier
                .size(60.dp)
                .align(alignment = Alignment.CenterHorizontally),
            colors = ButtonDefaults.buttonColors(backgroundColor = Color(0xffc1b6d1)),
            shape = CircleShape
        ) {
            Text(text = "+")
        }
    }
}