package com.example.absenonline.view

import android.arch.lifecycle.ViewModelProvider
import android.arch.lifecycle.ViewModelProviders
import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.util.Log.e
import android.util.Log.w
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import com.example.absenonline.MainActivity
import com.example.absenonline.R
import com.example.absenonline.data.SharePref
import com.example.absenonline.service.Const
import com.example.absenonline.viewmodel.ViewModelAbsensi

class LoginActivity : AppCompatActivity (){
    var etNik : EditText? = null
    var btnLogin : Button? = null
    var nama : String? = null
    var nik : String?= null
    var id : String?= null
    var login : String? = null
    internal  lateinit var set: SharePref


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.login)
        etNik = findViewById(R.id.etNik)
        btnLogin = findViewById(R.id.btnLogin)
        set = SharePref(this)

        val viewModel = ViewModelProviders.of(this).get(ViewModelAbsensi::class.java)
        btnLogin!!.setOnClickListener {
            login = etNik!!.text.toString()
            viewModel.dataAbsensi.observeForever {
                Toast.makeText(this, "login = $login", Toast.LENGTH_SHORT).show()
                for (data in it!!) {
                    w("Y", "$data")
                    nik = data.nik
                    Toast.makeText(this, "nik = $nik", Toast.LENGTH_SHORT).show()
                    if (login.equals(nik)) {
//                        id = data.id
                        nama = data.nama
                        set.setNAMA(nama!!)
                        set.setNIK(nik!!)
                        startActivity(Intent(this, DataMenuUtama::class.java))
                        break
                    } else {
                        e("ERRORRRR", "Error aduh error")
                        Toast.makeText(this, "data tidak terload", Toast.LENGTH_SHORT).show()

                    }
                }
            }
        }
    }
}