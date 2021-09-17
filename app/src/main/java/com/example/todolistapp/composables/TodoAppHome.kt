package com.example.todolistapp.composables

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.todolistapp.data.DataProvider
import com.example.todolistapp.models.ToDo
import com.example.todolistapp.ui.theme.DarkerPurple
import com.example.todolistapp.ui.theme.LightGray

@ExperimentalMaterialApi
@Composable
fun TodoAppContent() {
    val todos = remember { (DataProvider.listOfToDoEntries.toMutableStateList()) }
    val showDialog = remember { mutableStateOf(false) }
    var titleText by remember { mutableStateOf("") }
    var descriptionText by remember { mutableStateOf("") }
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(DarkerPurple)
    ) {
        LazyColumn(
            contentPadding = PaddingValues(horizontal = 16.dp, vertical = 0.dp),
            modifier = Modifier
                .weight(1f), horizontalAlignment = Alignment.End
        ) {
            items(items = todos, itemContent = {
                CreateToDoListItem(todo = it)
                OutlinedButton(
                    onClick = { todos.remove(it) },
                    modifier = Modifier
                        .size(40.dp),
                    colors = ButtonDefaults.buttonColors(backgroundColor = LightGray),
                    shape = CircleShape
                ) {
                    Text(text = "X")
                }
            })
        }
        Button(
            onClick = { showDialog.value = true },
            modifier = Modifier
                .size(60.dp)
                .align(alignment = Alignment.CenterHorizontally),
            colors = ButtonDefaults.buttonColors(backgroundColor = LightGray),
            shape = CircleShape
        ) {
            Text(text = "+")
        }
        if (showDialog.value) {
            AlertDialog(
                onDismissRequest = {
                    showDialog.value = false
                },
                text = {
                    Column {
                        Text(text = "Title", fontSize = 20.sp)
                        TextField(
                            value = titleText,
                            onValueChange = { titleText = it }
                        )
                        Text(text = "Description", fontSize = 20.sp)
                        TextField(
                            value = descriptionText,
                            onValueChange = { descriptionText = it }
                        )
                    }
                },
                buttons = {
                    Row(
                        horizontalArrangement = Arrangement.Center
                    ) {
                        Button(
                            modifier = Modifier
                                .fillMaxWidth(0.5f)
                                .padding(8.dp),
                            colors = ButtonDefaults.buttonColors(backgroundColor = LightGray),
                            onClick = {
                                showDialog.value = false
                                titleText = ""
                                descriptionText = ""
                            }
                        ) {
                            Text("Cancel")
                        }
                        Button(
                            modifier = Modifier
                                .fillMaxWidth()
                                .padding(8.dp),
                            colors = ButtonDefaults.buttonColors(backgroundColor = LightGray),
                            onClick = {
                                if (titleText.isEmpty() && descriptionText.isEmpty()) {
                                    showDialog.value = false
                                } else {
                                    showDialog.value = false
                                    todos.add(ToDo(titleText, descriptionText))
                                    titleText = ""
                                    descriptionText = ""
                                }
                            }
                        ) {
                            Text("Add")
                        }
                    }
                }
            )
        }
    }
}