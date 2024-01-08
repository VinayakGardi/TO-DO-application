package com.vinayakgardi.todolist

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.vinayakgardi.todolist.databinding.ActivityAddTaskBinding

class AddTaskActivity : AppCompatActivity() {
    private lateinit var binding : ActivityAddTaskBinding
    val TAG = "AddActivity"
    override fun onCreate(savedInstanceState: Bundle?) {
        binding = ActivityAddTaskBinding.inflate(layoutInflater)
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        Log.d(TAG,"started")

        binding.btnAddTask.setOnClickListener {
            val taskName = binding.addTaskName.text.toString()
            val taskPriority = binding.addTaskPriority.text.toString()
            TaskObject.addTask(taskName,taskPriority)
            Log.d(TAG,"picked")
            startActivity(Intent(this,MainActivity::class.java))

        }


    }
}