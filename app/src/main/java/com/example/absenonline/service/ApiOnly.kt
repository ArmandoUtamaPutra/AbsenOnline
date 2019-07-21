package com.example.absenonline.service


import com.example.absenonline.model.AbsensiModel
import com.example.absenonline.model.PesertaModel
import com.example.absenonline.view.DataAbsensi
import retrofit2.Call
import retrofit2.http.Field
import retrofit2.http.FormUrlEncoded
import retrofit2.http.GET
import retrofit2.http.POST

interface ApiOnly {
    @GET("sign_in")
    fun getDataPeserta(): Call<List<PesertaModel>>

    @POST("absensi_pulang") // ini buat absen pulang
    @FormUrlEncoded
    fun absenPulang(@Field("id_peserta") id : String,
                  @Field("jam_pulang") jam_pulang : String,
                    @Field("date") date : String) : Call<AbsensiModel>
    @POST("absensi_masuk")
    @FormUrlEncoded
    fun absenMasuk(@Field("id_peserta")id_peserta: String,
                   @Field("name") name:String,
                   @Field("jam_masuk") jam_masuk :String,
                   @Field("date") date : String) : Call<AbsensiModel>



}