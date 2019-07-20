package com.example.absenonline.model

import com.google.gson.annotations.SerializedName

class AbsensiModel {

    @SerializedName("id_peserta")
    lateinit var id_peserta :String

    @SerializedName("nama_peserta")
    lateinit var nama_peserta :String

    @SerializedName("jam_masuk")
    lateinit var jam_masuk :String

    @SerializedName("jam_pulang")
    lateinit var jam_pulang :String

    @SerializedName("date")
    lateinit var date :String

    constructor(){}

    constructor(id_peserta:String,nama_peserta : String,  jam_masuk : String, jam_pulang : String, date: String){
        this.id_peserta = id_peserta
        this.nama_peserta = nama_peserta
        this.jam_masuk = jam_masuk
        this.jam_pulang = jam_pulang
        this.date = date

    }
}