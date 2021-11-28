package com.devmovil.appTurismo

import android.content.Intent
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.gson.Gson


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

    private lateinit var listaSitios: ArrayList<Lugar>
    private lateinit var turismoAdapter: TurismoAdapter
    private lateinit var sitiosrecyclerView: RecyclerView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        this.supportActionBar?.hide()
        setContentView(R.layout.activity_main)

        // Declaraciones para el Adapter


        sitiosrecyclerView = findViewById(R.id.recyclerView)

        listaSitios= createMockSitios()

        turismoAdapter =  TurismoAdapter(listaSitios, onItemClicked={onListaLugaresClicked (it)} )

        sitiosrecyclerView.apply {
            layoutManager = LinearLayoutManager(context)
            adapter =  turismoAdapter
            setHasFixedSize(false) }


        //Toolbar no borrar, declaración para Fragment

        val toolbar = findViewById<Toolbar>(R.id.toolbar)
        setSupportActionBar(toolbar)


    }

    private fun onListaLugaresClicked(lugar: Lugar) {
        val intent = Intent(this, Detalle::class.java)
        intent.putExtra("lugar",lugar)
        startActivity(intent)
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


    //Consumir información del JSON

    private fun createMockSitios(): ArrayList<Lugar> {
        val lugaresString : String = applicationContext.assets.open("lugares.json").bufferedReader().use{ it.readText() }
        val gson = Gson()
        val data = gson.fromJson(lugaresString,ListaLugares::class.java)
        return data
    }

}