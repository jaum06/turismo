package com.villadeleyva.list

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.google.gson.Gson
import com.villadeleyva.data.LugaresRepository
import com.villadeleyva.model.Poi
import com.villadeleyva.model.PoiItem
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import java.io.InputStream

class ListViewModel:ViewModel() {
    private var poiLoad : MutableLiveData<ArrayList<PoiItem>> = MutableLiveData()
    val onPoiLoaded: LiveData<ArrayList<PoiItem>> = poiLoad

    private val repository = LugaresRepository()

    fun getLugaresFromServer(){
        GlobalScope.launch(Dispatchers.IO){
            poiLoad.postValue(repository.getLugares())
        }
    }

    fun loadMockPoiFromJson(poiString: InputStream?){
        val poiString = poiString?.bufferedReader().use{ it!!.readText()}
        val gson = Gson()
        poiLoad.value = gson.fromJson(poiString, Poi::class.java)
    }
}