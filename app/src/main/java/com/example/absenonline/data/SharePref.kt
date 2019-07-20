package com.example.absenonline.data

import android.content.Context
import android.content.SharedPreferences

class SharePref {
    internal  var mContext : Context
    private  var sharePref : SharedPreferences
    val statusabsen: String = "Statusabsen"
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
}