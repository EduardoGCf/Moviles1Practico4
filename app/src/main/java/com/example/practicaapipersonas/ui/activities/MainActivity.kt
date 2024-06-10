package com.example.practicaapipersonas.ui.activities

import android.content.Intent
import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.practicaapipersonas.databinding.ActivityMainBinding
import com.example.practicaapipersonas.models.Libro
import com.example.practicaapipersonas.ui.adapters.LibroAdapter
import com.example.practicaapipersonas.ui.viewmodels.MainViewModel

class MainActivity : AppCompatActivity(), LibroAdapter.OnLibroClickListener {
    lateinit var binding: ActivityMainBinding
    private val model: MainViewModel by viewModels()
    private lateinit var adapter: LibroAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setupRecyclerView()
        setupViewModelObservers()
    }

    private fun setupRecyclerView() {
        adapter = LibroAdapter(emptyList<Libro>().toMutableList())
        adapter.setOnLibroClickListener(this)
        binding.recyclerView.apply {
            layoutManager = LinearLayoutManager(this@MainActivity)
            adapter = this@MainActivity.adapter
        }
    }

    private fun setupViewModelObservers() {
        model.libroList.observe(this) { libros ->
            adapter.updateLibros(libros)
        }
    }

    override fun onResume() {
        super.onResume()
        model.fetchLibros()
    }

    override fun onLibroClick(libro: Libro) {
        val intent = Intent(this, DetailActivity::class.java)
        intent.putExtra("libro", libro)
        startActivity(intent)
    }
}