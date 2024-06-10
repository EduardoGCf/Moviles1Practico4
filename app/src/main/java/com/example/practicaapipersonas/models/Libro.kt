package com.example.practicaapipersonas.models

import java.io.Serializable


data class Libro(
    val nombre: String,
    val autor: String,
    val editorial: String,
    val imagen: String,
    val sinopsis: String,
    val isbn: String
): Serializable