package com.zehrayildirim.todolistapp

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.zehrayildirim.todolistapp.Item
import com.zehrayildirim.todolistapp.R

class ToDoAdapter(private val items: MutableList<Item>) : RecyclerView.Adapter<ToDoAdapter.ToDoViewHolder>() {

    inner class ToDoViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val txtTitleView: TextView = itemView.findViewById(R.id.txt_title_view)
        val txtDescView: TextView = itemView.findViewById(R.id.txt_desc_view)
        val deleteIcon: ImageView = itemView.findViewById(R.id.delete_icon)

        init {
            deleteIcon.setOnClickListener {
                val position = adapterPosition
                if (position != RecyclerView.NO_POSITION) {
                    items.removeAt(position)
                    notifyItemRemoved(position)
                }
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ToDoViewHolder {
        val itemView = LayoutInflater.from(parent.context).inflate(R.layout.to_do_items, parent, false)
        return ToDoViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: ToDoViewHolder, position: Int) {
        val currentItem = items[position]
        holder.txtTitleView.text = currentItem.title
        holder.txtDescView.text = currentItem.description
    }

    override fun getItemCount() = items.size
}
