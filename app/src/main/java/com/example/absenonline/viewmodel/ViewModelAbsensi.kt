package com.example.absenonline.viewmodel

import android.arch.lifecycle.LiveData
import android.arch.lifecycle.MutableLiveData
import android.arch.lifecycle.ViewModel
import android.util.Log.e
import com.example.absenonline.model.AbsensiModel
import com.example.absenonline.model.PesertaModel
import com.example.absenonline.service.ApiOnly
import com.example.absenonline.service.Const
import com.example.absenonline.view.DataAbsensi
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class ViewModelAbsensi : ViewModel() {
    var listAbsensi : MutableLiveData<List<PesertaModel>>? = null
    val dataAbsensi : LiveData<List<PesertaModel>>
    get() {
        if (listAbsensi == null){
            listAbsensi = MutableLiveData()
            loadDataAbsensi()
        }
        return listAbsensi!!
    }
    private fun loadDataAbsensi(){
        val retrofit = Retrofit.Builder().baseUrl(Const.base_url).addConverterFactory(GsonConverterFactory.create()).build()
        val apiData = retrofit.create(ApiOnly::class.java)
        val getData = apiData.getDataPeserta()
        getData.enqueue(object : Callback<List<PesertaModel>>{
            override fun onFailure(call: Call<List<PesertaModel>>, t: Throwable) {
                e("HAHAHAH", "Error ${t.localizedMessage}")
            }

            override fun onResponse(call: Call<List<PesertaModel>>, response: Response<List<PesertaModel>>) {
                e("HAHAHAH", "INI DATANYA BOS ${response.body()}")
                listAbsensi!!.value = response.body()
            }

        })
    }
}