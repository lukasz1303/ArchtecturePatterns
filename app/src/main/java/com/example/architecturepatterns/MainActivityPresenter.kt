package com.example.architecturepatterns

import java.text.FieldPosition

class MainActivityPresenter(private val view: View) {

    private val model = Model()

    fun addTask(name: String) {
        model.addTask(name)
        view.updateListView(model.tasks)
    }

    fun removeTask(position: Int) {
        model.removeTask(position)
        view.updateListView(model.tasks)
    }
}