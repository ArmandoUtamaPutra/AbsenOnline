package com.example.absenonline

import android.content.SharedPreferences
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    val PREFS_FILENAME = "com.example.absenonline.prefs"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val userRef = this.getSharedPreferences(PREFS_FILENAME, 0)

        val date: String = userRef.getString("tanggal", "20 January 2019")!!
        if (tanggalabsen.text.toString().equals(date)) {
            absenmasuk.visibility = View.VISIBLE
            centang3.visibility = View.GONE
        }

        absenmasuk.setOnClickListener {
            absenpulang.visibility = View.VISIBLE
            absenmasuk.visibility = View.GONE
            centang1.visibility = View.VISIBLE
            centang2.visibility = View.GONE
        }
        absenpulang.setOnClickListener {
            absenmasuk.visibility = View.GONE
            absenpulang.visibility = View.GONE
            centang2.visibility = View.VISIBLE
            centang1.visibility = View.GONE
            centang3.visibility = View.VISIBLE
            tanggalabsen.text = "21 January 2019"
            userRef.edit().putString("tanggal", "21 January 2019")
        }
    }
}
