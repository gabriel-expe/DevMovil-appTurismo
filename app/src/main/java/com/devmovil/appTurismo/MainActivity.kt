package com.devmovil.appTurismo

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

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

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        this.supportActionBar?.hide()
        setContentView(R.layout.activity_main)

        val recyclerView=findViewById<RecyclerView>(R.id.recyclerView)
        val adapter = CustomAdapter()

        recyclerView.layoutManager = LinearLayoutManager(this)
        recyclerView.adapter = adapter

    }
}