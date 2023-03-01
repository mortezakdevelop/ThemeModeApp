package com.example.darkmodethemeproject

import android.app.Application
import android.preference.PreferenceManager
import androidx.appcompat.app.AppCompatDelegate


class DarkModeApplication: Application() {
    override fun onCreate() {
        super.onCreate()
//        val prefs = PreferenceManager.getDefaultSharedPreferences(applicationContext)
//        val isNightMode = prefs.getBoolean("SwitchState", true)
//        if (isNightMode)
//            AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_YES)
//        else
//            AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO)
   }
}