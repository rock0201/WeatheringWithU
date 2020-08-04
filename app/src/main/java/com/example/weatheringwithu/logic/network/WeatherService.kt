package com.example.weatheringwithu.logic.network

import com.example.weatheringwithu.WeatheringWithUApplication
import com.example.weatheringwithu.logic.model.DailyResponce
import com.example.weatheringwithu.logic.model.RealtimeResponce
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path

interface WeatherService {
    @GET("v2.5/${WeatheringWithUApplication.TOKEN}/{lng},{lat}/realtime.json")
    fun getRealtimeWeather(@Path("lng")lng:String,@Path("lat")lat:String)
            :Call<RealtimeResponce>
    @GET("v2.5/${WeatheringWithUApplication.TOKEN}/{lng},{lat}/daily.json")
    fun getDailyWeather(@Path("lng")lng:String,@Path("lat")lat:String)
            :Call<DailyResponce>
}