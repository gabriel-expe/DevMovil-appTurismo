package com.devmovil.appTurismo

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.view.View
import androidx.appcompat.widget.Toolbar
import androidx.cardview.widget.CardView
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.card_layout.*


// Estas lineas de còdigo son para volver a implementar clicklistener
/*
class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        txtlagunacocha.setOnClickListener {
            val intent: Intent = Intent(this, LagunadelaCocha::class.java)
            startActivity(intent)
        }
        txtgaleras.setOnClickListener {
            val intent: Intent = Intent(this, volcangaleras::class.java)
            startActivity(intent)
        }
        txtLajas.setOnClickListener {
            val intent: Intent = Intent(this, ActividadSantuarioLajas::class.java)
            startActivity(intent)
        }

    }
}*/

//En este MainAcrivity se està incluyendo funciones del recyclerview y de los fragments

class MainActivity : AppCompatActivity() {

    private lateinit var listaSitios: ArrayList<listPOI>
    private lateinit var turismoAdapter: TurismoAdapter
    private lateinit var sitiosrecyclerView: RecyclerView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        this.supportActionBar?.hide()
        setContentView(R.layout.activity_main)

        // Declaraciones para el Adapter


        sitiosrecyclerView = findViewById(R.id.recyclerView)

        listaSitios= createMockSitios()

        turismoAdapter = TurismoAdapter(listaSitios)

        sitiosrecyclerView.apply {
            layoutManager = LinearLayoutManager(context)
            adapter =  turismoAdapter
            setHasFixedSize(false) }


        //Toolbar no borrar, declaración para Fragment

        val toolbar = findViewById<Toolbar>(R.id.toolbar)
        setSupportActionBar(toolbar)


    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {

        menuInflater.inflate(R.menu.menu_toolbar, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        var id=item.itemId

        if(id==R.id.btnConfg){
            toSettings()
            return true
        }
        return super.onOptionsItemSelected(item)
    }

    private fun toSettings() {
        val intent = Intent(this, SettingsActivity::class.java)
        startActivity(intent)
    }


    //Esta funciòn crea una maqueta de objetos

    private fun createMockSitios():  ArrayList<listPOI>{
        return arrayListOf (
            listPOI(
                nombre = "Las Lajas",
                descripcion = "Lugar que conecta con la espiritualidad"
            ),
            listPOI(
                nombre = "Galeras",
                descripcion = "Apasionante volcan que convive en paz con su vecino"
            ),
            listPOI(
                nombre = "Laguna de la Cocha",
                descripcion = "Basta cuerpo de agus cristalinas que invita a la reflexion"
            ),
            listPOI(
                nombre = "Tumaco",
                descripcion = "Vibrante pueblo frente al mar pacifico"
            )

        )
    }

}