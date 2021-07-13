package com.example.architecturepatterns

class MainActivityPresenter(private val view: View) {

    private val model = Model()

    fun addTask(name: String){
        model.addTask(name)
        view.updateListView(model.tasks)
    }
}