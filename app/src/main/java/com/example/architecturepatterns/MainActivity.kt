package com.example.architecturepatterns

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
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

        binding.addButton.setOnClickListener {
            presenter.addTask(binding.taskEditText.editableText.toString())
        }
    }

    override fun updateListView(tasks: List<String>) {
        adapter.addAll(tasks)
        //TODO cokolwiek
        adapter.notifyDataSetChanged()
    }
}