package dev.zotov.todoapp.data.viewmodels

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.viewModelScope
import dev.zotov.todoapp.data.TodoDatabase
import dev.zotov.todoapp.data.models.TodoData
import dev.zotov.todoapp.data.repositories.TodoRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class TodoViewModel(application: Application): AndroidViewModel(application) {

    private val todoDao = TodoDatabase.getDatabase(application).todoDao();
    private val repository: TodoRepository = TodoRepository(todoDao)
    val getAllData: LiveData<List<TodoData>> = repository.getAllData

    fun insertData(todoData: TodoData) {
        viewModelScope.launch(Dispatchers.IO) {
            repository.insertData(todoData)
        }
    }

}