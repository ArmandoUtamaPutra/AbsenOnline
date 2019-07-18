package com.example.absenonline.model

import com.google.gson.annotations.SerializedName

class PesertaModel {
    @SerializedName("id")
    lateinit var id: String
    @SerializedName("nik")
    lateinit var nik: String
    @SerializedName("nama")
    lateinit var nama: String
    constructor(){}
    constructor(id: String, nik: String, nama: String){
        this.id = id
        this.nik = nik
        this.nama = nama
    }
}