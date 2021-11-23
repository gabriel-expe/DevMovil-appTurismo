package com.devmovil.appTurismo

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class TurismoAdapter (private val listaSitios: ArrayList <listPOI>) :
RecyclerView.Adapter<TurismoAdapter.ViewHolder> (){

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view =LayoutInflater.from(parent.context).inflate(R.layout.card_layout, parent, false)
        return ViewHolder (view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {

        val flower = listaSitios[position]
        holder.bind(flower)

    }

    override fun getItemCount(): Int {
        return listaSitios.size
    }


    class ViewHolder(itemView: View): RecyclerView.ViewHolder(itemView){

        private var Nombre: TextView = itemView.findViewById(R.id.Nombre)
        private var Descripcion: TextView = itemView.findViewById(R.id.Descripcion)
        //private var Image: ImageView = itemView.findViewById(R.id.Image)

        fun bind(poi:listPOI){
            Nombre.text = poi.nombre
            Descripcion.text = poi.descripcion


        }

    }
}