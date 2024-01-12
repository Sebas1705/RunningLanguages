package com.sebss.pass_word.data

import android.annotation.SuppressLint
import android.content.Context

class SharedPreferences(val context: Context) {

    private val sharedName = "Pass_word_preferences"
    private val sharedUserName = "Actual_user"
    private val storage = context.getSharedPreferences(sharedName,Context.MODE_PRIVATE)

    fun saveUser(name:String){
        storage.edit().putString(sharedUserName,name).apply()
    }

    fun loadUser():String?{
        return storage.getString(sharedUserName,null)
    }

}