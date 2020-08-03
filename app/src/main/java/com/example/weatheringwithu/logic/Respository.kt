package com.example.weatheringwithu.logic

import androidx.lifecycle.LiveData
import androidx.lifecycle.liveData
import com.example.weatheringwithu.logic.model.Place
import com.example.weatheringwithu.logic.network.WeatheringWithUNetwork
import kotlinx.coroutines.Dispatchers
import java.lang.Exception
import java.lang.RuntimeException

object Respository {
    fun searchPlaces(query:String) = liveData(Dispatchers.IO) {
        val result = try {
            val placeResponce = WeatheringWithUNetwork.searchPlaces(query)
            if (placeResponce.status == "ok"){
                val places = placeResponce.places
                Result.success(places)
            }else{
                Result.failure(RuntimeException("responce status is ${placeResponce.status}"))
            }
        }catch (e:Exception){
            Result.failure<List<Place>>(e)
        }
        emit(result)
    }
}