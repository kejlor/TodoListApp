package com.example.todolistapp.models

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "todo_list")
data class Todo(
    @ColumnInfo(name = "todo_title")
    val title: String,
    @ColumnInfo(name = "todo_description")
    val description: String,
    @PrimaryKey(autoGenerate = true)
    var itemId: Long = 0L
) {
    constructor(title: String, description: String) : this(title, description, 0L)
}