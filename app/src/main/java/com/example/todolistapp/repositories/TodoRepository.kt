package com.example.todolistapp.repositories

import androidx.lifecycle.LiveData
import com.example.todolistapp.database.TodoDatabaseDao
import com.example.todolistapp.models.Todo

class TodoRepository(private val todoDatabaseDao: TodoDatabaseDao) {

    val readAllData: LiveData<List<Todo>> = todoDatabaseDao.getAll()

    suspend fun addTodo(todo: Todo) {
        todoDatabaseDao.insert(todo)
    }

    suspend fun deleteTodo(todo: Todo) {
        todoDatabaseDao.delete(todo)
    }
}