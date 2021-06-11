package dev.zotov.todoapp.data.repositories

import androidx.lifecycle.LiveData
import dev.zotov.todoapp.data.TodoDao
import dev.zotov.todoapp.data.models.TodoData

class TodoRepository(private val todoDao: TodoDao) {

    val getAllData: LiveData<List<TodoData>> = todoDao.getAllData()

    suspend fun insertData(todoData: TodoData) {
        todoDao.insertData(todoData)
    }
}