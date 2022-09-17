package com.example.composefirstapp.ui.data

import com.example.composefirstapp.ui.core.JSONConverter
import com.squareup.moshi.JsonAdapter
import com.squareup.moshi.Moshi
import com.squareup.moshi.adapter
import kotlin.reflect.KType

class AppMoshiJSONConverter : JSONConverter() {

    companion object{
        val moshi: Moshi = Moshi.Builder().build()
    }

    @OptIn(ExperimentalStdlibApi::class)
    override fun <T> fromJSON(data: String, type: KType): T? {
        println("*****Moshi: $type")
        val adapter : JsonAdapter<T> = moshi.adapter(type)
        return adapter.fromJson(data)
    }

    @OptIn(ExperimentalStdlibApi::class)
    override fun <T> toJSON(data: T, type: KType): String? {
        println("*****Moshi: $type")
        val adapter : JsonAdapter<T> = moshi.adapter(type)
        return adapter.toJson(data)
    }


}