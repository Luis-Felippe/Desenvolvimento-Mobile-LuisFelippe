package com.example.tasksmanagerapp.viewModel

import android.content.Context
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.tasksmanagerapp.Utils.DataStoreUtils
import com.example.tasksmanagerapp.model.Task
import com.example.tasksmanagerapp.model.TaskCategory
import com.example.tasksmanagerapp.model.TaskPriority
import kotlinx.coroutines.flow.*
import kotlinx.coroutines.launch

class TasksViewModel(context: Context) : ViewModel() {
    private val _tasks = MutableStateFlow(
        listOf(
            Task("Reunião importante", false, TaskCategory.TRABALHO, TaskPriority.ALTA),
            Task("Estudar Jetpack Compose", false, TaskCategory.ESTUDOS, TaskPriority.MEDIA),
            Task("Limpar a casa", false, TaskCategory.CASA, TaskPriority.BAIXA)
        )
    )
    val tasks: StateFlow<List<Task>> = _tasks

    private var lastDeletedTask: Task? = null

    fun removeTask(task: Task) {
        lastDeletedTask = task
        _tasks.value = _tasks.value - task
    }

    fun undoDelete() {
        lastDeletedTask?.let {
            _tasks.value = _tasks.value + it
            lastDeletedTask = null
        }
    }

    private val _progress = MutableStateFlow(0f)
    val progress: StateFlow<Float> = _progress

    val themeFlow: Flow<Boolean> = DataStoreUtils.readTheme(context)
    private val _isDarkTheme = MutableStateFlow(false)

    init {
        viewModelScope.launch {
            themeFlow.collect { _isDarkTheme.value = it }
            updateProgress()
        }
    }

    val isDarkTheme: StateFlow<Boolean> = _isDarkTheme

    fun addTask(task: Task) {
        _tasks.value = _tasks.value + task
        updateProgress()
    }

    fun toggleTaskCompletion(task: Task) {
        _tasks.value = _tasks.value.map {
            if (it == task) it.copy(isCompleted = !it.isCompleted) else it
        }
        updateProgress()
    }

    private fun updateProgress() {
        val completed = _tasks.value.count { it.isCompleted }
        _progress.value = if (_tasks.value.isNotEmpty()) completed.toFloat() / _tasks.value.size else 0f
    }

    fun toggleTheme(context: Context) {
        viewModelScope.launch {
            val newTheme = !_isDarkTheme.value
            _isDarkTheme.value = newTheme
            DataStoreUtils.saveTheme(context, newTheme)
        }
    }
}