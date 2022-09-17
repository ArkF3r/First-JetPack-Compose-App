package com.example.composefirstapp.ui.core

import kotlin.reflect.KType
import kotlin.reflect.typeOf

abstract class JSONConverter {
    inline fun <reified T> fromJSON(data : String) : T?{
        return fromJSON(data, typeOf<T>()) as T?
    }
    abstract fun<T> fromJSON(data: String, type: KType) : T?
    inline fun <reified T> toJSON(data : T) : String?{
        return toJSON(data, typeOf<T>())
    }
    abstract fun<T> toJSON(data: T, type: KType) : String?
}


/*abstract class JSONConverter {
    inline fun <reified T> fromJSON(data : String) : T?{
        return fromJSON(data, T::class) as T?
    }
    abstract fun<T> fromJSON(data : String, clazz: KClass<*> ) : T?
    inline fun <reified T> toJSON(data : T) : String?{
        return toJSON(data, T::class)
    }
    abstract fun<T> toJSON( data : T, clazz: KClass<*>) : String?
}*/

//interface JSONConverter {
//    fun<T> fromJSON(data : String, clazz: Class<*> ) : T?
//    fun<T> toJSON( data : T, clazz: Class<*> ) : String?
//}
//inline fun <reified T> JSONConverter.toJSON(data : T) : String?{
//    return toJSON(data, T::class.java)
//}
//inline fun <reified T> JSONConverter.fromJSON(data : String) : T?{
//    return fromJSON(data, T::class.java) as T?
//}