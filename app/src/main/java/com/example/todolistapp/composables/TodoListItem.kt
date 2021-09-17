package com.example.todolistapp.composables

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.material.MaterialTheme.typography
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.todolistapp.models.Todo
import com.example.todolistapp.ui.theme.OwnPurple

@ExperimentalMaterialApi
@Composable
fun CreateToDoListItem(todo: Todo) {
    Card(
        modifier = Modifier
            .padding(horizontal = 30.dp, vertical = 0.dp)
            .fillMaxWidth(),
        elevation = 0.dp,
        backgroundColor = OwnPurple,
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
