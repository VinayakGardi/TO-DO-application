package com.vinayakgardi.todolist.Room

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update
import com.vinayakgardi.todolist.Task

@Dao
interface Dao {

    @Insert
    suspend fun insertTask(entity: Entity)

    @Update
    suspend fun updateTasks(entity: Entity)

    @Delete
    suspend fun deleteTask(entity: Entity)

    @Query("Delete from TODO")
    suspend fun deleteAllTasks()

    @Query("Select * from TODO")
    suspend fun showTasks(): List<Task>




}