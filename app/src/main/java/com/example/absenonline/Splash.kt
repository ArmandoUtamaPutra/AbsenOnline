package com.example.absenonline

import android.content.Intent
import android.os.Bundle
import android.os.Handler
import android.support.v7.app.AppCompatActivity
import com.example.absenonline.view.DataMenuUtama
import com.example.absenonline.view.LoginActivity

class Splash :AppCompatActivity () {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.splash)
        Handler().postDelayed({
            val login = Intent(this, LoginActivity::class.java)
            startActivity(login)

//            UserHelper(this).StatusSplash = true
            finish()
        }, 3000)

        }
}