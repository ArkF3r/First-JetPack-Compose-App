package com.example.composefirstapp.ui.data

import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class Ejemplo(
    val a : Int,
    val b : Int,
    val e : Ejemplo2?
)
