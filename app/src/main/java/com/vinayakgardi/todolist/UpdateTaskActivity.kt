package com.vinayakgardi.todolist

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.vinayakgardi.todolist.databinding.ActivityUpdateTaskBinding

class UpdateTaskActivity : AppCompatActivity() {
    private lateinit var binding : ActivityUpdateTaskBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        binding = ActivityUpdateTaskBinding.inflate(layoutInflater)
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

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
                startActivity(Intent(this,MainActivity::class.java))
            }
        }
        else{
            Toast.makeText(this, "Some error occurred ", Toast.LENGTH_SHORT).show()
        }
    }
}