package com.example.practiacapipersonas.repositories

import com.example.practicaapipersonas.api.APIProductosService
import com.example.practicaapipersonas.models.Genero
import com.example.practicaapipersonas.repositories.RetrofitRepository
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

object GeneroRepository {
    fun getGeneroList(success: (List<Genero>?) -> Unit, failure: (Throwable) -> Unit) {
        val retrofit = RetrofitRepository.getRetrofitInstance()
        val service: APIProductosService = retrofit.create(APIProductosService::class.java)
        service.obtenerListaDeGeneros().enqueue(object : Callback<List<Genero>> {
            override fun onResponse(call: Call<List<Genero>>, response: Response<List<Genero>>) {
                success(response.body())
            }

            override fun onFailure(call: Call<List<Genero>>, t: Throwable) {
                failure(t)
            }
        })
    }

    // Similar methods for obtenerGeneroPorId, eliminarGenero, insertarGenero, editarGenero
}