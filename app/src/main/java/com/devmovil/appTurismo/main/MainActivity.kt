package com.devmovil.appTurismo.main

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.RecyclerView
import com.devmovil.appTurismo.*
import com.devmovil.appTurismo.model.Lugar

class MainActivity : AppCompatActivity() {

    private lateinit var listaSitios: ArrayList<Lugar>
    private lateinit var turismoAdapter: TurismoAdapter
    private lateinit var sitiosrecyclerView: RecyclerView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        this.supportActionBar?.hide()
        setContentView(R.layout.activity_main)
        //Toolbar no borrar, declaración para Fragment

        //val toolbar = findViewById<Toolbar>(R.id.toolbar)
        //setSupportActionBar(toolbar)


    }

}