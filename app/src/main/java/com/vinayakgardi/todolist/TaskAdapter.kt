package com.vinayakgardi.todolist


import android.content.Intent
import android.graphics.Color
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class TaskAdapter(var taskList:List<Task>) : RecyclerView.Adapter<TaskAdapter.TodoViewHolder>()  {
    inner class TodoViewHolder(itemView : View) : RecyclerView.ViewHolder(itemView){
         var taskName = itemView.findViewById<TextView>(R.id.taskName)
         var taskPriority = itemView.findViewById<TextView>(R.id.taskPriority)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TodoViewHolder {
        val viewHolder = LayoutInflater.from(parent.context).inflate(R.layout.item_todo,parent,false)
        return TodoViewHolder(viewHolder)
    }

    override fun getItemCount(): Int {
      return taskList.size
    }


    override fun onBindViewHolder(holder: TodoViewHolder, position: Int) {
         holder.taskName.text = taskList[position].taskName

         when(taskList[position].taskPriority.lowercase().trim()){
             "high"->{
                 holder.taskPriority.setTextColor(Color.parseColor("#C70039"))
                 holder.taskPriority.setBackgroundResource(R.drawable.priority_background_high)
                 holder.taskPriority.text =  "HIGH"
             }
             "medium"->{
                 holder.taskPriority.setTextColor(Color.parseColor("#FF5733"))
                 holder.taskPriority.setBackgroundResource(R.drawable.priority_background_medium)
                 holder.taskPriority.text = "Medium"
             }
             "low"->{
                 holder.taskPriority.setTextColor(Color.parseColor("#FFC300"))
                 holder.taskPriority.setBackgroundResource(R.drawable.priority_background_low)
                 holder.taskPriority.text = "LOW"
             }
         }

        // update the activity
        holder.itemView.setOnClickListener {
            val intent = Intent(holder.itemView.context,UpdateTaskActivity::class.java)
            intent.putExtra("id",position)
            holder.itemView.context.startActivity(intent)
        }
    }
}