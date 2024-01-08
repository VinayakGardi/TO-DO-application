package com.vinayakgardi.todolist

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.LinearLayout
import androidx.recyclerview.widget.LinearLayoutManager
import com.vinayakgardi.todolist.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding : ActivityMainBinding
    val TAG = "MainActivity"
    override fun onCreate(savedInstanceState: Bundle?) {
        binding = ActivityMainBinding.inflate(layoutInflater)
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        Log.d(TAG ,"Started activity")

        binding.btnAddTask.setOnClickListener {
            startActivity(Intent(this,AddTaskActivity::class.java))
        }
//        var taskList = mutableListOf<Task>(
//            Task("task1", "high"),
//            Task("task2", "medium"),
//            Task("task44", "high"),
//            Task("task5", "low"),
//            Task("task1", "medium"),
//        )

        binding.taskList.adapter = TaskAdapter(TaskObject.taskList)
        binding.taskList.layoutManager = LinearLayoutManager(this)


    }
}