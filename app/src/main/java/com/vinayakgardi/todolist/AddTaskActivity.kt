package com.vinayakgardi.todolist

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.room.Room
import androidx.room.RoomDatabase
import com.vinayakgardi.todolist.Room.Entity
import com.vinayakgardi.todolist.Room.TaskDatabase
import com.vinayakgardi.todolist.databinding.ActivityAddTaskBinding
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

class AddTaskActivity : AppCompatActivity() {
    private lateinit var binding : ActivityAddTaskBinding
    val TAG = "AddActivity"
    private lateinit var database : TaskDatabase
    override fun onCreate(savedInstanceState: Bundle?) {
        binding = ActivityAddTaskBinding.inflate(layoutInflater)
        super.onCreate(savedInstanceState)
        setContentView(binding.root)


        database = Room.databaseBuilder(
            applicationContext,TaskDatabase::class.java,"TODO"
        ).build()


        Log.d(TAG,"started")

        binding.btnAddTask.setOnClickListener {
            val taskName = binding.addTaskName.text.toString()
            val taskPriority = binding.addTaskPriority.text.toString()

            TaskObject.addTask(taskName,taskPriority)
            GlobalScope.launch {
             database.dao().insertTask(Entity(0,taskName,taskPriority))
            }
            GlobalScope.launch {
                Log.i(TAG,"${database.dao().showTasks()}")
            }
            startActivity(Intent(this,MainActivity::class.java))
        }

    }
}