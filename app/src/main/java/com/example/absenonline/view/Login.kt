package com.example.absenonline.view

import android.arch.lifecycle.ViewModelProvider
import android.arch.lifecycle.ViewModelProviders
import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import com.example.absenonline.R
import com.example.absenonline.data.SharePref
import com.example.absenonline.service.Const
import com.example.absenonline.viewmodel.ViewModelAbsensi

class Login : AppCompatActivity (){
    var etNik : EditText? = null
    var btnLogin : Button? = null
    internal  lateinit var set: SharePref


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.login)
        etNik = findViewById(R.id.etNik)
        btnLogin = findViewById(R.id.btnLogin)
        set = SharePref(this)

        val viewModel = ViewModelProviders.of(this).get(ViewModelAbsensi::class.java)
        viewModel.dataAbsensi!!.observeForever{
            btnLogin!!.setOnClickListener {
                xx ->
                for (data in it!!){
                    val login = etNik!!.text.toString()
                    val id = data.id
                    val nik = data.nik
                    val peserta = data.nama_peserta
                    if (login ==nik){
                        if (peserta == "0"){
                            Toast.makeText(this, "Tes", Toast.LENGTH_SHORT).show()
                            set.updateSetting(Const.PREF_MY_ID, id)
                            startActivity(Intent(this,))

                        }
                    }
                }
            }
        }

    }
}