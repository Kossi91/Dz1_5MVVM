package com.example.dz1_5mvvm

import android.app.Application
import com.example.dz1_5mvvm.data.local.preference.PreferenceHelper
import com.example.dz1_5mvvm.data.local.preference.SignUpPreferenceHelper

class App: Application() {

    companion object{
        lateinit var preferenceHelper: PreferenceHelper
    }

    override fun onCreate() {
        super.onCreate()
        preferenceHelper = PreferenceHelper(applicationContext)
        SignUpPreferenceHelper.unit(this)
    }
}