package com.example.todolistapp.composables

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.material.MaterialTheme.typography
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.example.todolistapp.models.ToDo

@Composable
fun CreateToDoListItem(todo: ToDo) {
    Card(
        modifier = Modifier
            .padding(horizontal = 8.dp, vertical = 8.dp)
            .fillMaxWidth(),
        elevation = 2.dp,
        backgroundColor = Color(0xff694598),
        shape = RoundedCornerShape(topStart = 30.dp, topEnd = 30.dp, bottomStart = 0.dp, bottomEnd = 30.dp)
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
                OutlinedButton(onClick = {}, modifier = Modifier
                    .size(40.dp)
                    .align(alignment = Alignment.End),
                    colors = ButtonDefaults.buttonColors(backgroundColor = Color(0xffc1b6d1)), shape = CircleShape) {
                    Text(text = "X")
                }
            }
        }
    }
}
