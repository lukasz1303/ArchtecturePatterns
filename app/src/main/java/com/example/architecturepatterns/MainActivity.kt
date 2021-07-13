package com.example.architecturepatterns

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.*
import com.example.architecturepatterns.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity(), View {

    private lateinit var presenter: MainActivityPresenter
    private lateinit var adapter: ArrayAdapter<String>
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        presenter = MainActivityPresenter(this)

        adapter = ArrayAdapter<String>(
            this,
            android.R.layout.simple_list_item_checked,
            android.R.id.text1,
            mutableListOf()
        )
        binding.tasksListView.adapter = adapter

        binding.tasksListView.setOnItemClickListener { _, _, position, _ ->

            val checkedPositions = binding.tasksListView.checkedItemPositions;
            if (checkedPositions.get(position)) {
                presenter.removeTask(position)
            }
            binding.tasksListView.setItemChecked(position, false)
        }

        binding.addButton.setOnClickListener {
            presenter.addTask(binding.taskEditText.editableText.toString())
        }
    }

    override fun updateListView(tasks: List<String>) {
        adapter.clear()
        adapter.addAll(tasks)
        adapter.notifyDataSetChanged()
    }
}