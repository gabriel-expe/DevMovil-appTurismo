package com.devmovil.appTurismo.main

import android.content.Intent
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.RecyclerView
import com.devmovil.appTurismo.R
import com.devmovil.appTurismo.detalle.DetallesFragmentDirections
import com.devmovil.appTurismo.model.Lugar
import com.devmovil.appTurismo.preferences.SettingsActivity

class MainActivity : AppCompatActivity() {

    private lateinit var listaSitios: ArrayList<Lugar>
    private lateinit var turismoAdapter: TurismoAdapter
    private lateinit var sitiosrecyclerView: RecyclerView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        //Toolbar no borrar, declaración para Fragment

        val tor = findViewById<Toolbar>(R.id.toolbar)
        setSupportActionBar(tor)



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




}