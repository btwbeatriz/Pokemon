package com.example.myapplication.model

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class Usuario (
    val nome: String = "",
    val email: String = "",
    val matricula: String = "",
    val cpf: String = "",
    val genero: String = "",
    val fotoUrl: String = "",
    val dtNasc: String = "",
    val curso: String = ""
) : Parcelable