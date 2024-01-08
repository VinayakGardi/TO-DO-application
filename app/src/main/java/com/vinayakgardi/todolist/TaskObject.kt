package com.vinayakgardi.todolist

object TaskObject {
    var taskList = mutableListOf<Task>()

    fun addTask(taskName: String, taskPriority: String) {
        taskList.add(Task(taskName, taskPriority))
    }

    fun getAllTask(): List<Task> {
        return taskList
    }

    fun getTask(position: Int): Task {
        return taskList[position]
    }

    fun deleteAllTask() {
        taskList.clear()
    }

    fun deleteTask(position: Int) {
        taskList.removeAt(position)
    }

    fun updateTask(position: Int, taskName: String, taskPriority: String) {
        taskList[position].taskName = taskName
        taskList[position].taskPriority = taskPriority
    }


}