package com.example.todolistapp.composables

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.example.todolistapp.data.DataProvider

@Composable
fun TodoAppContent() {
    val todos = remember { (DataProvider.listOfToDoEntries) }
    Column(modifier = Modifier.fillMaxSize().background(Color(0xff503d69))) {
        LazyColumn(
            contentPadding = PaddingValues(horizontal = 16.dp, vertical = 8.dp),
            modifier = Modifier
                .weight(1f)
        ) {
            items(items = todos, itemContent = { CreateToDoListItem(todo = it) })
        }
        Button(onClick = {}, modifier = Modifier
            .size(60.dp)
            .align(alignment = Alignment.CenterHorizontally),
            colors = ButtonDefaults.buttonColors(backgroundColor = Color(0xffc1b6d1)), shape = CircleShape
        ) {
            Text(text = "+")
        }
    }

}