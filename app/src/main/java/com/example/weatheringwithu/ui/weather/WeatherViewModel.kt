package com.example.weatheringwithu.ui.weather

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Transformations
import androidx.lifecycle.ViewModel
import com.example.weatheringwithu.logic.Respository
import com.example.weatheringwithu.logic.model.Location

class WeatherViewModel:ViewModel(){
    private val locationliveData = MutableLiveData<Location>()
    var locationLng = ""
    var locationLat = ""
    var placeName = ""
    val weatherLivaData = Transformations.switchMap(locationliveData){loaction->
        Respository.refreshWeather(loaction.lng,loaction.lat)
    }
    fun refreshWeather(lng:String,lat:String){
        locationliveData.value = Location(lng,lat)
    }
}