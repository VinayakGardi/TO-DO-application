package com.vinayakgardi.todolist

import android.content.Intent
import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.room.Room
import com.vinayakgardi.todolist.Room.TaskDatabase
import com.vinayakgardi.todolist.databinding.ActivityMainBinding
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private lateinit var database: TaskDatabase
    val TAG = "MainActivity"
    override fun onCreate(savedInstanceState: Bundle?) {
        binding = ActivityMainBinding.inflate(layoutInflater)
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        Log.d(TAG, "Started activity")

        database = Room.databaseBuilder(
            applicationContext, TaskDatabase::class.java, "TODO"
        ).build()

       setAdapter()



        binding.btnAddTask.setOnClickListener {
            startActivity(Intent(this, AddTaskActivity::class.java))
        }



        binding.btnDeleteAll.setOnClickListener {
            TaskObject.deleteAllTask()

            GlobalScope.launch {
                database.dao().deleteAllTasks()
            }

            GlobalScope.launch {
                Log.i(TAG, "${database.dao().showTasks()}")
            }
            setAdapter()

        }

    }
    private fun setAdapter(){
        val adapter = TaskAdapter(TaskObject.taskList)
        binding.taskList.adapter = adapter
        binding.taskList.layoutManager = LinearLayoutManager(this)
    }
}