package com.example.absenonline.data

import android.content.Context
import android.content.SharedPreferences

class SharePref {
    internal  var mContext : Context
    private  var sharePref : SharedPreferences
    val statusabsen: String = "Statusabsen"
    val NIK: String = "NIK"
    val NAMA: String = "NAMA"

    constructor(context: Context){
        mContext = context
        sharePref = mContext.getSharedPreferences("Nik", Context.MODE_PRIVATE)
    }
    fun  readSetting(key: String):String{
        return sharePref.getString(key, "na")
    }
    fun updateSetting(key: String, value: String){
        val editor = sharePref.edit()
        editor.putString(key,value)
        editor.apply()
    }

    fun deleteAllSetting(){
        sharePref.edit().remove("nik").commit()
    }

    fun saveStatusAbsen(status:Boolean){
    val editor = sharePref.edit()
        editor.putBoolean(statusabsen,status)
        editor.apply()
    }
    fun getStatusAbsen():Boolean{
        return sharePref.getBoolean(statusabsen,false)
    }

    fun setNIK(nik : String){
        val editor = sharePref.edit()
        editor.putString(NIK, nik)
        editor.apply()
    }
    fun getNik(): String{
        return sharePref.getString(NIK, " ")
    }
    fun setNAMA(nama : String){
        val editor = sharePref.edit()
        editor.putString(NAMA, nama)
        editor.apply()
    }
    fun getNama(): String{
        return sharePref.getString(NAMA, " ")
    }
}