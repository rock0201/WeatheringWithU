package com.example.weatheringwithu.logic.network

import com.example.weatheringwithu.WeatheringWithUApplication
import com.example.weatheringwithu.logic.model.PlaceResponce
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface PlaceService {
    @GET("v2/place?token=${WeatheringWithUApplication.TOKEN}&lang=zh_CN")
    fun searchPlaces(@Query("query")query:String):Call<PlaceResponce>
}