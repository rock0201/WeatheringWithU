package com.example.weatheringwithu.ui.place

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Transformations
import androidx.lifecycle.ViewModel
import com.example.weatheringwithu.logic.model.Place
import com.example.weatheringwithu.logic.Respository
class PlaceViewModel :ViewModel() {
    private val searchLiveData = MutableLiveData<String>()
    val placeList = ArrayList<Place>()
    val placeLiveData = Transformations.switchMap(searchLiveData){query->
        Respository.searchPlaces(query)
    }
    fun searchPlace(query:String){
        searchLiveData.value = query
    }
}