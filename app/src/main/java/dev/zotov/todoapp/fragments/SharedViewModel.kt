package dev.zotov.todoapp.fragments

import android.app.Application
import android.text.TextUtils
import androidx.lifecycle.AndroidViewModel
import dev.zotov.todoapp.data.models.Priority

class SharedViewModel(application: Application): AndroidViewModel(application) {
    fun verifyData(title: String, description: String): Boolean {
        return !TextUtils.isEmpty(title) && !TextUtils.isEmpty(description)
    }

    fun stringToPriority(priority: String): Priority {
        return when (priority) {
            "High Priority" -> {
                Priority.HIGH
            }
            "Medium Priority" -> {
                Priority.MEDIUM
            }
            "Low Priority" -> {
                Priority.LOW
            }
            else -> Priority.LOW
        }
    }
}