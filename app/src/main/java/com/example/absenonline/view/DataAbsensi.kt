package com.example.absenonline.view

import android.annotation.SuppressLint
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.util.Log.i
import android.util.Log.v
import android.view.View
import android.widget.Toast
import com.example.absenonline.R
import com.example.absenonline.data.SharePref
import com.example.absenonline.model.AbsensiModel
import com.example.absenonline.service.ApiOnly
import com.example.absenonline.service.Const
import kotlinx.android.synthetic.main.absen.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.time.LocalDateTime
import java.time.format.DateTimeFormatter

class DataAbsensi : AppCompatActivity (){

    var oke : String? = null
    var shared:SharePref? = null
    var retrofit:Retrofit? = null
    var absenPeserta: ApiOnly? =null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.absen)
        shared = SharePref(this)
        oke = getTimeOk()
        tanggalabsen.text = oke

        retrofit = Retrofit.Builder().baseUrl(Const.base_url).addConverterFactory(GsonConverterFactory.create()).build()
        absenPeserta = retrofit!!.create(ApiOnly::class.java)

        val statusabsen = shared!!.getStatusAbsen()
        if(statusabsen == true){
            absenmasuk.visibility = View.GONE
            absenpulang.visibility = View.VISIBLE
        }else{
            absenmasuk.visibility = View.VISIBLE
            absenpulang.visibility = View.GONE
        }

        absenmasuk.setOnClickListener {
            val nik = shared!!.getNik()
            val nama = shared!!.getNama()
            val jam = getTimeOk().toString()
            val w = getJamOk().toString()
            i("taf", "$jam")
            i("a", "$w")
            absenPeserta!!.absenMasuk("${nik}","${nama}","${w}","${jam}")
                .enqueue(object :Callback<AbsensiModel> {
                    override fun onFailure(call: Call<AbsensiModel>, t: Throwable) {
                        absenpulang.visibility = View.VISIBLE
                        absenmasuk.visibility = View.GONE
                        centang1.visibility = View.VISIBLE
                        centang2.visibility = View.GONE
                        shared!!.saveStatusAbsen(true)
                    }

                    override fun onResponse(call: Call<AbsensiModel>, response: Response<AbsensiModel>) {
                        absenpulang.visibility = View.VISIBLE
                        absenmasuk.visibility = View.GONE
                        centang1.visibility = View.VISIBLE
                        centang2.visibility = View.GONE
                        shared!!.saveStatusAbsen(true)
                    }

                })
        }
        absenpulang.setOnClickListener {
            //nah dibagian sini tambahkan kode yg sama kayak yg atas,
            //cuman isinya yg absen pulang
            //kodenya sama kayak yg absen masuk isinya aja yg beda
            //nnti samain kayak yg ane blok ya kodenya terus nte coba jalanin
            val nik = shared!!.getNik()
            val jam = getTimeOk() // gaperlu pake toString itu udh string
            val w = getJamOk()
            i("taf", "$jam")
            i("a", "$w")
            //lanjutin isinya
            absenPeserta!!.absenPulang("${nik}","${w}", "${jam}").enqueue(object : Callback<AbsensiModel>{
                override fun onFailure(call: Call<AbsensiModel>, t: Throwable) {

                }

                override fun onResponse(call: Call<AbsensiModel>, response: Response<AbsensiModel>) {
                    absenpulang.visibility = View.GONE
                    absenmasuk.visibility = View.GONE
                    centang1.visibility = View.VISIBLE // ini buat apa do?
                    centang2.visibility = View.GONE
                    shared!!.saveStatusAbsen(false)
                }
            })
            //RUN do
            //oke pak
            // kalo force close run di hp nte aja yak kan di emulator gabisa ngambil jam
            //oiya ya pak okee ;v

        }

    }
    //for get time
    @SuppressLint("NewApi")
    fun getTimeOk() : String{
        val currentTime = LocalDateTime.now()
        val formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd")
        val dateOk = currentTime.format(formatter)
        return dateOk
    }
    @SuppressLint("NewApi")
    fun getJamOk() : String{
        val currentTime = LocalDateTime.now()
        val formatter = DateTimeFormatter.ofPattern("HH:mm:ss")
        val dateOk = currentTime.format(formatter)
        return dateOk
    }
}
