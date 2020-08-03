package com.example.weatheringwithu

import android.app.Application
import android.content.Context

class WeatheringWithUApplication :Application(){
    companion object{
        const val TOKEN = "92DIiLJ2rh3mALgI"
        lateinit var context: Context
    }
    override fun onCreate() {
        super.onCreate()
        context = applicationContext
    }
}