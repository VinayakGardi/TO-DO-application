package com.vinayakgardi.todolist.Room

import androidx.room.Entity
import androidx.room.PrimaryKey
import java.io.Serializable

@Entity(tableName = "TODO")
data class Entity(
    @PrimaryKey(autoGenerate = true)
     var id : Int ,
     var taskName : String,
     var taskPriority : String
)
