package com.example.weatheringwithu.ui.place

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Transformations
import androidx.lifecycle.ViewModel
import com.example.weatheringwithu.logic.model.Place
import com.example.weatheringwithu.logic.Respository
import com.example.weatheringwithu.logic.dao.PlaceDao

class PlaceViewModel :ViewModel() {
    private val searchLiveData = MutableLiveData<String>()
    val placeList = ArrayList<Place>()
    val placeLiveData = Transformations.switchMap(searchLiveData){query->
        Respository.searchPlaces(query)
    }
    fun searchPlace(query:String){
        searchLiveData.value = query
    }
    fun savePlace(place:Place) = Respository.savePlace(place)
    fun getSavedPlace() = Respository.getSavedPlace()
    fun isPlaceSaved() = Respository.isPlaceSaved()
}