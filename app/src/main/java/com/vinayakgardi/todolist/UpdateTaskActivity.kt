package com.vinayakgardi.todolist

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.room.Room
import com.vinayakgardi.todolist.Room.Entity
import com.vinayakgardi.todolist.Room.TaskDatabase
import com.vinayakgardi.todolist.databinding.ActivityUpdateTaskBinding
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

class UpdateTaskActivity : AppCompatActivity() {
    private lateinit var binding : ActivityUpdateTaskBinding
    private lateinit var database : TaskDatabase
    val TAG = "UpdateActivity"
    override fun onCreate(savedInstanceState: Bundle?) {
        binding = ActivityUpdateTaskBinding.inflate(layoutInflater)
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        database = Room.databaseBuilder(
            applicationContext, TaskDatabase::class.java,"TODO"
        ).build()

        val position = intent.getIntExtra("id",-1)
        if(position>-1){
            val taskName : String = TaskObject.taskList[position].taskName
            val taskPriority = TaskObject.taskList[position].taskPriority
            binding.updateTaskName.setText(taskName)
            binding.updateTaskPriority.setText(taskPriority)

            binding.btnUpdateTask.setOnClickListener {
                val taskNameNew = binding.updateTaskName.text.toString()
                val taskPriorityNew = binding.updateTaskPriority.text.toString()
                TaskObject.updateTask(position,taskNameNew,taskPriorityNew)

                GlobalScope.launch {
                    database.dao().updateTasks(Entity(position+1,taskNameNew,taskPriorityNew))
                }
                GlobalScope.launch {
                    Log.i(TAG,"${database.dao().showTasks()}")
                }

                startActivity(Intent(this,MainActivity::class.java))
            }
        }
        else{
            Toast.makeText(this, "Some error occurred ", Toast.LENGTH_SHORT).show()
        }
    }
}