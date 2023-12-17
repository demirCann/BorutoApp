package com.demircandemir.borutoapp.data.local

import androidx.room.TypeConverter

class DatabaseConverter {

    private val seperator= ","

    @TypeConverter
    fun convertListToString(list: List<String>): String {
        val stringBuilder = StringBuilder()
        for (item in list) {
            stringBuilder.append(item).append(seperator)
        }

        stringBuilder.setLength(stringBuilder.length - seperator.length)
        return stringBuilder.toString()
    }

    @TypeConverter
    fun convertStringToList(string: String): List<String> {
        return string.split(seperator)
    }

}