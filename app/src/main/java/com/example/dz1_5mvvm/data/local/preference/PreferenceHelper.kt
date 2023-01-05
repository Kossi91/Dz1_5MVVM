package com.example.dz1_5mvvm.data.local.preference

import android.content.Context
import android.content.SharedPreferences

class PreferenceHelper(context: Context) {

    private val sharedPreferences: SharedPreferences =
        context.getSharedPreferences("sing-up", Context.MODE_PRIVATE)

    var username: String?
    get() = sharedPreferences.getString("username" , "")
    set(value) = sharedPreferences.edit().putString("username" , value).apply()

    var age: Int
        get() = sharedPreferences.getInt("age" , 0)
        set(value) = sharedPreferences.edit().putInt("age" , value).apply()

    var email: String?
        get() = sharedPreferences.getString("mail" , "")
        set(value) = sharedPreferences.edit().putString("mail" , value).apply()

    var password: String?
        get() = sharedPreferences.getString("password" , "")
        set(value) = sharedPreferences.edit().putString("password" , value).apply()

}
