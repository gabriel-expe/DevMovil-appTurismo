package com.devmovil.appTurismo.main

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.devmovil.appTurismo.R
import com.devmovil.appTurismo.model.Lugar
import com.squareup.picasso.Picasso

class TurismoAdapter (
    private val listLugares : ArrayList<Lugar>,
    private val onItemClicked : (Lugar) -> Unit
) : RecyclerView.Adapter<TurismoAdapter.ViewHolder> () {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.card_layout, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val lugar = listLugares[position]
        holder.itemView.setOnClickListener { onItemClicked(listLugares[position]) }
        holder.bind(lugar)
    }

    override fun getItemCount(): Int = listLugares.size


    class ViewHolder(view: View) : RecyclerView.ViewHolder(view){

        private val nameTextView : TextView = view.findViewById(R.id.Nombre)
        private val descripcionTextView : TextView = view.findViewById(R.id.Descripcion)
        private val pictureImageView : ImageView = view.findViewById(R.id.item_image)

        fun bind (lugar : Lugar) {
            nameTextView.text = lugar.nombre
            descripcionTextView.text = lugar.descripcion
            Picasso.get().load(lugar.urlImagen).into(pictureImageView)
        }
    }
    }


