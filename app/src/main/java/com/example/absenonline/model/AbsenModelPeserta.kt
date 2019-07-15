package com.example.absenonline.model

import com.google.gson.annotations.SerializedName

class AbsenModelPeserta {
    @SerializedName("id")
    lateinit var id :String

    @SerializedName("nik")
    lateinit var nik :String

    @SerializedName("nama_peserta")
    lateinit var nama_peserta :String

    @SerializedName("jam_masuk")
    lateinit var jam_masuk :String

    @SerializedName("jam_pulang")
    lateinit var jam_pulang :String

    constructor(){}

    constructor(nik: String, nama_peserta : String,  jam_masuk : String, jam_pulang : String){
        this.nik = nik
        this.nama_peserta = nama_peserta
        this.jam_masuk = jam_masuk
        this.jam_pulang = jam_pulang

    }
}