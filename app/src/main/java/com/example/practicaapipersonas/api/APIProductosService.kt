package com.example.practicaapipersonas.api


import com.example.practicaapipersonas.models.Genero
import com.example.practicaapipersonas.models.Libro
import com.example.practicaapipersonas.models.LibroGenero
import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.DELETE
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.PUT
import retrofit2.http.Path

interface APIProductosService {

    @GET("libros")
    fun obtenerListaDeLibros(): Call<List<Libro>>

    @GET("libros/{id}")
    fun obtenerLibroPorId(@Path("id") id: Int): Call<Libro>

    @DELETE("libros/{id}")
    fun eliminarLibro(@Path("id") id: Int): Call<Void>

    @POST("libros")
    fun insertarLibro(@Body libro: Libro): Call<Libro>

    @PUT("libros/{id}")
    fun editarLibro(@Path("id") id: Int, @Body libro: Libro): Call<Libro>

    // Métodos para géneros
    @GET("generos")
    fun obtenerListaDeGeneros(): Call<List<Genero>>

    @GET("generos/{id}")
    fun obtenerGeneroPorId(@Path("id") id: Int): Call<Genero>

    @DELETE("generos/{id}")
    fun eliminarGenero(@Path("id") id: Int): Call<Void>

    @POST("generos")
    fun insertarGenero(@Body genero: Genero): Call<Genero>

    @PUT("generos/{id}")
    fun editarGenero(@Path("id") id: Int, @Body genero: Genero): Call<Genero>

    // Métodos para agregar y eliminar géneros de libros
    @POST("libro-generos")
    fun agregarGeneroALibro(@Body libroGenero: LibroGenero): Call<Void>

    @DELETE("libro-generos")
    fun eliminarGeneroDeLibro(@Body libroGenero: LibroGenero): Call<Void>
}