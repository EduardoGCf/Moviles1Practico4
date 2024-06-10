package com.example.practicaapipersonas.ui.activities

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.bumptech.glide.Glide
import com.example.practicaapipersonas.databinding.ActivityDetailBinding
import com.example.practicaapipersonas.models.Libro

class DetailActivity : AppCompatActivity() {
    private lateinit var binding: ActivityDetailBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDetailBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val libro = intent.getSerializableExtra("libro") as Libro

        binding.apply {
            bookNameTextView.text = libro.nombre
            bookAuthorTextView.text = libro.autor
            bookEditorialTextView.text = libro.editorial
            bookSynopsisTextView.text = libro.sinopsis
            bookIsbnTextView.text = libro.isbn
            Glide.with(this@DetailActivity).load(libro.imagen).into(LibroImageView)
        }
    }
}