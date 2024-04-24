package com.zehrayildirim.todolistapp

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.zehrayildirim.todolistapp.databinding.FirstPageBinding
import com.zehrayildirim.todolistapp.ToDoAdapter

class FirstPage : Fragment() {

    private lateinit var binding: FirstPageBinding
    private val items = mutableListOf<Item>()
    private lateinit var toDoAdapter: ToDoAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FirstPageBinding.inflate(inflater, container, false)
        setupRecyclerView()
        binding.btnAdd.setOnClickListener {
            addNewItem()
        }
        return binding.root
    }

    private fun setupRecyclerView() {
        toDoAdapter = ToDoAdapter(items)
        binding.recyclerview.apply {
            adapter = toDoAdapter
            layoutManager = LinearLayoutManager(context)
        }
    }

    private fun addNewItem() {
        val title = binding.txtTitle.text.toString().trim()
        val description = binding.txtDescription.text.toString().trim()

        if (title.isNotEmpty() && description.isNotEmpty()) {
            items.add(Item(title, description, items.size + 1, false))
            toDoAdapter.notifyItemInserted(items.size - 1)
            clearInputs()
        } else {
            Toast.makeText(context, "Fill all the blanks", Toast.LENGTH_SHORT).show()
        }
    }

    private fun clearInputs() {
        binding.txtTitle.setText("")
        binding.txtDescription.setText("")
    }
}
