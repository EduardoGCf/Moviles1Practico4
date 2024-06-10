package com.example.practicaapipersonas.ui.viewmodels

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.practiacapipersonas.repositories.LibroRepository
import com.example.practiacapipersonas.repositories.GeneroRepository
import com.example.practicaapipersonas.models.Libro
import com.example.practicaapipersonas.models.Genero
import com.example.practicaapipersonas.models.LibroGenero

class MainViewModel : ViewModel() {
    private val _libroList: MutableLiveData<List<Libro>> by lazy {
        MutableLiveData<List<Libro>>()
    }
    val libroList: LiveData<List<Libro>> get() = _libroList

    private val _generoList: MutableLiveData<List<Genero>> by lazy {
        MutableLiveData<List<Genero>>()
    }
    val generoList: LiveData<List<Genero>> get() = _generoList

    private val _libroGeneroList: MutableLiveData<List<LibroGenero>> by lazy {
        MutableLiveData<List<LibroGenero>>()
    }
    val libroGeneroList: LiveData<List<LibroGenero>> get() = _libroGeneroList

    fun fetchLibros() {
        LibroRepository.getLibroList(
            success = { libros ->
                libros?.let {
                    _libroList.value = it
                }
            },
            failure = {
                it.printStackTrace()
            })
    }

    fun fetchGeneros() {
        GeneroRepository.getGeneroList(
            success = { generos ->
                generos?.let {
                    _generoList.value = it
                }
            },
            failure = {
                it.printStackTrace()
            })

    }
    fun createLibro(libro: Libro) {
        LibroRepository.createLibro(
            libro = libro,
            success = { newLibro ->

                fetchLibros()
            },
            failure = { error ->

                error.printStackTrace()
            }
        )
    }


}