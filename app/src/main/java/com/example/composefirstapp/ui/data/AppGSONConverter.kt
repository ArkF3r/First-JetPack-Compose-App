package com.example.composefirstapp.ui.data

import com.example.composefirstapp.ui.core.JSONConverter
import com.google.gson.GsonBuilder
import kotlin.reflect.KType
import kotlin.reflect.javaType

class AppGSONConverter : JSONConverter() {
    companion object{
        private val gson = GsonBuilder().disableHtmlEscaping().create()
        /*fun getInstance() : Gson{
            return gson
        }*/
    }

    @OptIn(ExperimentalStdlibApi::class)
    override fun <T> fromJSON(data: String, type: KType): T? {
        println("*****GSON: ${type.javaType}")
        return gson.fromJson(data, type.javaType) as T?
    }

    @OptIn(ExperimentalStdlibApi::class)
    override fun <T> toJSON(data: T, type: KType): String? {
        println("*****GSON: ${type.javaType}")
        return gson.toJson(data, type.javaType)
    }

    /*override fun <T> fromJSON(data: String, clazz: KType): T? {
        return gson.fromJson(data, clazz.java) as T?
    }

    override fun <T> toJSON(data: T, clazz: KType): String? {
        return gson.toJson(data, clazz.java)
    }*/

    /*inline fun <reified T> fromJSON(data: String): T? {
        //val clazz = Class<T>()
        return getInstance().fromJson(data, T::class.java)
    }

    override fun <T> toJSON(data: T): String? {
        return gson.toJson(data)
    }*/
}