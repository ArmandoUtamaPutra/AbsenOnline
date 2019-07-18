package com.example.absenonline.service


import com.example.absenonline.model.PesertaModel
import com.example.absenonline.view.DataAbsensi
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.POST

interface ApiOnly {
    @GET("sign_in")
    fun getDataPeserta(): Call<List<PesertaModel>>


}