package com.zehrayildirim.todolistapp

data class Item(
    val title: String,
    val description: String,
    val id: Int,
    val isCompleted: Boolean
)
