package com.example.weatheringwithu.logic

import androidx.lifecycle.LiveData
import androidx.lifecycle.liveData
import com.example.weatheringwithu.logic.model.Place
import com.example.weatheringwithu.logic.model.Weather
import com.example.weatheringwithu.logic.network.WeatheringWithUNetwork
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.async
import kotlinx.coroutines.coroutineScope
import java.lang.Exception
import java.lang.RuntimeException
import kotlin.coroutines.CoroutineContext

object Respository {
    fun searchPlaces(query: String) = fire(Dispatchers.IO) {

        val placeResponce = WeatheringWithUNetwork.searchPlaces(query)
        if (placeResponce.status == "ok") {
            val places = placeResponce.places
            Result.success(places)
        } else {
            Result.failure(RuntimeException("responce status is ${placeResponce.status}"))
        }
    }



fun refreshWeather(lng: String, lat: String) = fire(Dispatchers.IO) {

    coroutineScope {
        val deferredRealtime = async {
            WeatheringWithUNetwork.getRealtimeWeather(lng, lat)
        }
        val deferredDaily = async {
            WeatheringWithUNetwork.getDailyWeather(lng, lat)
        }
        val realtimeResponce = deferredRealtime.await()
        val dailyResponce = deferredDaily.await()
        if (realtimeResponce.status == "ok" && dailyResponce.status == "ok") {
            val weather = Weather(realtimeResponce.result.realtime, dailyResponce.result.daily)
            Result.success(weather)
        } else {
            Result.failure(
                RuntimeException(
                    "realtime responce status is ${realtimeResponce.status}" +
                            "daily responce status is ${dailyResponce.status}"
                )
            )
        }
    }
}

private fun <T> fire(context: CoroutineContext, block: suspend () -> Result<T>) =
    liveData<Result<T>>(context) {
        val result = try {
            block()
        } catch (e: Exception) {
            Result.failure<T>(e)
        }
        emit(result)
    }
}