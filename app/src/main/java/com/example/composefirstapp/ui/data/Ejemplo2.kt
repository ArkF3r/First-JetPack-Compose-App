package com.example.composefirstapp.ui.data

import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class Ejemplo2(
    val c : String,
    val d : Int
)
