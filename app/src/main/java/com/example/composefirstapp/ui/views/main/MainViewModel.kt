package com.example.composefirstapp.ui.views.main

import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.composefirstapp.ui.data.AppGSONConverter
import com.example.composefirstapp.ui.data.AppMoshiJSONConverter
import com.example.composefirstapp.ui.data.Ejemplo
import com.example.composefirstapp.ui.data.Ejemplo2
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

class MainViewModel: ViewModel() {
    val starting = mutableStateOf(true)
    val showDialog = mutableStateOf(false)
    val counter = mutableStateOf(0)
    private val appGSONConverter = AppGSONConverter()
    private val appMoshiJSONConverter = AppMoshiJSONConverter()

    init {
        val jsonStr = "[{\"a\":0,\"b\":0,\"e\":{\"c\":\"ABC=\",\"d\":0}},{\"a\":1,\"b\":2,\"e\":{\"c\":\"DEF\",\"d\":6}},{\"a\":2,\"b\":4}]"
        val Ejemplos : Array<Ejemplo> = Array(3) {Ejemplo(it, it*2, Ejemplo2("${(it * 3)}==", it*6))}
        val EjemplosFromGSON : List<Ejemplo>? = appGSONConverter.fromJSON<List<Ejemplo>>(jsonStr)
        val EjemplosFromMoshi : List<Ejemplo>? = appMoshiJSONConverter.fromJSON<List<Ejemplo>>(jsonStr)
        val jsonFromGSON : String? = appGSONConverter.toJSON(Ejemplos)
        val jsonFromMoshi : String? = appMoshiJSONConverter.toJSON(Ejemplos)

        printInfo(EjemplosFromGSON, "USED GSON")
        printInfo(jsonFromGSON, "USED GSON")
        printInfo(EjemplosFromMoshi, "USED MOSHI")
        printInfo(jsonFromMoshi, "USED MOSHI")

        startApp()
    }

    private fun<T> printInfo(data : T, tag : String){
        println("------------------------------------")
        println("+++++++++ $tag")
        println("+++++++++ ${data!!::class}")
        println("+++++++++ ${data!!::class.java}")
        println("+++++++++ $data")
    }

    private fun startApp(){
        viewModelScope.launch{
            println("Iniciando carga de app")
            starting.value = true
            delay(2000)
            starting.value = false
            println("Fin carga de app")
        }
    }

    fun hideAlert(){
        showDialog.value = false
    }

    fun showAlert(){
        showDialog.value = true
    }

    fun increaseCounter(){
        hideAlert()
        counter.value++
    }
}