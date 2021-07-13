package com.example.architecturepatterns

class MainActivityPresenter(private val view: View) {

    val tasks: MutableList<String> = mutableListOf()

    fun addTask(name: String){
        tasks.add(name)
        view.updateListView()
    }
}