package com.example.absenonline

import android.content.Intent
import android.os.Bundle
import android.os.Handler
import android.support.v7.app.AppCompatActivity
import com.example.absenonline.view.DataMenuUtama

class Splash :AppCompatActivity () {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.splash)
        Handler().postDelayed({
            val login = Intent(this, DataMenuUtama::class.java)
            startActivity(login)

//            UserHelper(this).StatusSplash = true
            finish()
        }, 3000)

        }
}