package com.vinayakgardi.todolist.Room

import androidx.room.Database
import androidx.room.RoomDatabase


@Database(entities = [Entity::class], version = 1)
abstract class TaskDatabase : RoomDatabase() {
    abstract fun dao() : Dao
}