package com.devmovil.appTurismo.list

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.devmovil.appTurismo.data.LugaresRepository
import com.devmovil.appTurismo.model.ListaLugares
import com.devmovil.appTurismo.model.Lugar
import com.google.gson.Gson
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import java.io.InputStream

class ListViewModel: ViewModel() {

    private var lugaresload : MutableLiveData<ArrayList<Lugar>> = MutableLiveData()
    val lugaresloaded: LiveData<ArrayList<Lugar>> = lugaresload

    private val repository = LugaresRepository()
    fun getLugaresfromserver () {
        GlobalScope.launch(Dispatchers.IO){
           lugaresload.postValue(repository.getLugares())
        }
    }


    fun loadMockFlowersFromJson(lugaresString: InputStream?) {
        val lugaresString=lugaresString?.bufferedReader().use {it!!.readText()}
        val gson = Gson()
        lugaresload.value = gson.fromJson(lugaresString,ListaLugares::class.java)

    }


}