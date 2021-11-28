package com.devmovil.appTurismo

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.squareup.picasso.Picasso

class TurismoAdapter (
    private val listaSitios: ArrayList <Lugar>,
    private val onItemClicked: (Lugar) -> Unit
) : RecyclerView.Adapter<TurismoAdapter.ViewHolder> () {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.card_layout, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {

        val lugar = listaSitios[position]
        holder.itemView.setOnClickListener { onItemClicked(listaSitios[position])}
            holder.bind(lugar)

        }


        override fun getItemCount(): Int {
            return listaSitios.size
        }


        class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

            private var Nombre: TextView = itemView.findViewById(R.id.Nombre)
            private var Descripcion: TextView = itemView.findViewById(R.id.Descripcion)
            private var Imagen: ImageView = itemView.findViewById(R.id.item_image)

            fun bind(poi: Lugar) {
                Nombre.text = poi.nombre
                Descripcion.text = poi.descripcion
                Picasso.get().load(poi.urlImagen).into(Imagen)
            }
        }
    }


