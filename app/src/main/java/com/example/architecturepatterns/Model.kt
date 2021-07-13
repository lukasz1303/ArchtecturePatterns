package com.example.architecturepatterns

class Model {
    val tasks: MutableList<String> = mutableListOf()

    fun addTask(name: String){
        tasks.add(name)
    }
}