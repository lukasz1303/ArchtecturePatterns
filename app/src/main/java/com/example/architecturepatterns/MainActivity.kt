package com.example.architecturepatterns

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.*

class MainActivity : AppCompatActivity(), View {

    private lateinit var presenter: MainActivityPresenter
    private lateinit var taskEditText: EditText
    private lateinit var addButton: Button
    private lateinit var adapter: ArrayAdapter<String>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        presenter = MainActivityPresenter(this)
        taskEditText = findViewById(R.id.task_edit_text)
        addButton = findViewById(R.id.add_button)

        val listView = findViewById<ListView>(R.id.tasks_list_view)
        adapter = ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, android.R.id.text1, presenter.tasks)
        listView.adapter = adapter

        addButton.setOnClickListener {
            presenter.addTask(taskEditText.editableText.toString())
        }
    }

    override fun updateListView() {
        adapter.notifyDataSetChanged()
    }
}