package com.example.practicaapipersonas.ui.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.practicaapipersonas.databinding.LibroItemBinding
import com.example.practicaapipersonas.models.Libro

class LibroAdapter(private var libros: MutableList<Libro>) : RecyclerView.Adapter<LibroAdapter.LibroViewHolder>() {
    var listener: OnLibroClickListener? = null

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): LibroViewHolder {
        val binding = LibroItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return LibroViewHolder(binding)
    }

    override fun onBindViewHolder(holder: LibroViewHolder, position: Int) {
        val libro = libros[position]
        holder.bind(libro)
    }

    override fun getItemCount() = libros.size

    inner class LibroViewHolder(private val binding: LibroItemBinding) : RecyclerView.ViewHolder(binding.root) {

        fun bind(libro: Libro) {
            binding.nombreTextView.text = libro.nombre
            binding.autorTextView.text = libro.autor
            Glide.with(binding.root.context).load(libro.imagen).into(binding.imagenLibro)

            binding.root.setOnClickListener {
                listener?.onLibroClick(libro)
            }

            binding.imagenLibro.setOnClickListener {
                listener?.onLibroClick(libro)
            }
        }
    }

    interface OnLibroClickListener {
        fun onLibroClick(libro: Libro)
    }

    fun updateLibros(newLibros: List<Libro>) {
        libros.clear()
        libros.addAll(newLibros)
        notifyDataSetChanged()
    }

    fun setOnLibroClickListener(listener: OnLibroClickListener) {
        this.listener = listener
    }
}