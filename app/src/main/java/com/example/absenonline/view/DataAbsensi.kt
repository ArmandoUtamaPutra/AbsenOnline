package com.example.absenonline.view

import android.annotation.SuppressLint
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.view.View
import com.example.absenonline.R
import com.example.absenonline.data.SharePref
import kotlinx.android.synthetic.main.absen.*
import java.time.LocalDateTime
import java.time.format.DateTimeFormatter

class DataAbsensi : AppCompatActivity (){

    var oke : String? = null
    var shared:SharePref? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.absen)
        shared = SharePref(this)
        oke = getTimeOk()
        tanggalabsen.text = oke

        val statusabsen = shared!!.getStatusAbsen()
        if(statusabsen == true){
            absenmasuk.visibility = View.GONE
            absenpulang.visibility = View.VISIBLE
        }else{
            absenmasuk.visibility = View.VISIBLE
            absenpulang.visibility = View.GONE
        }

        absenmasuk.setOnClickListener {
            absenpulang.visibility = View.VISIBLE
            absenmasuk.visibility = View.GONE
            centang1.visibility = View.VISIBLE
            centang2.visibility = View.GONE
            shared!!.saveStatusAbsen(true)
        }
        absenpulang.setOnClickListener {
            absenmasuk.visibility = View.GONE
            absenpulang.visibility = View.GONE
            centang2.visibility = View.VISIBLE
            centang1.visibility = View.GONE


        }

    }
    //for get time
    @SuppressLint("NewApi")
    fun getTimeOk() : String{
        val currentTime = LocalDateTime.now()
        val formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy")
        val dateOk = currentTime.format(formatter)
        return dateOk
    }
}
