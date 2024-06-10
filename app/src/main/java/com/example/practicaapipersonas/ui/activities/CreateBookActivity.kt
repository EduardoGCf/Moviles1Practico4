package com.example.practicaapipersonas.ui.activities

import android.os.Bundle
import android.util.Log
import android.widget.EditText
import androidx.appcompat.app.AppCompatActivity
import com.example.practicaapipersonas.R
import com.example.practicaapipersonas.models.Libro
import com.example.practicaapipersonas.ui.viewmodels.MainViewModel
import com.example.practicaapipersonas.databinding.ActivityCreateBookBinding
import androidx.activity.viewModels
import kotlin.math.log

class CreateBookActivity : AppCompatActivity() {
    private lateinit var binding: ActivityCreateBookBinding
    private val model: MainViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityCreateBookBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setupCreateBookButton()
    }

    private fun setupCreateBookButton() {
        binding.btnCreateBook.setOnClickListener {
            val bookName = binding.editTextBookName.text.toString()
            val author = binding.editTextAuthor.text.toString()
            val editorial = binding.editTextEditorial.text.toString()
            val isbn = binding.editTextISBN.text.toString()
            val synopsis = binding.editTextSynopsis.text.toString()

            val newBook = Libro(nombre = bookName, autor = author, editorial = editorial, imagen = "", isbn = isbn, sinopsis = synopsis)
            model.createLibro(newBook)
            Log.d("CreateBookActivity", "Book created: $newBook")
                    //cerrar el activity y resetear el anterior
            finish()
        }
    }
}