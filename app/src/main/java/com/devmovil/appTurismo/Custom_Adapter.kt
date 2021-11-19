package com.devmovil.appTurismo

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class CustomAdapter: RecyclerView.Adapter<CustomAdapter.ViewHolder> () {

    val titles = arrayOf("Volcán Galeras", "Laguna de La Cocha", "Tumaco", "Santuario de las Lajas","Laguna Verde" )
    val detalles = arrayOf("Apasionante", "Emocionante", "Delirante", "Espiritualidad", "Profundidad")
    val puntuaciones = arrayOf("Calificación", "Calificación", "Calificación", "Calificación", "Calificación")
    val images = arrayOf(R.drawable.volcangaleras2,
        R.drawable.lagunadelacocha1,
        R.drawable.tumacouno,
        R.drawable.lajas1,
        R.drawable.lajas1
    )


    override fun onCreateViewHolder(viewGroup: ViewGroup, i: Int): ViewHolder {
        val v = LayoutInflater.from(viewGroup.context).inflate(R.layout.card_layout, viewGroup, false)
        return ViewHolder(v)
    }

    override fun onBindViewHolder(viewHolder: ViewHolder, i: Int) {
        viewHolder.itemTitle.text=titles[i]
        viewHolder.itemDetalle.text=detalles[i]
        viewHolder.itemPuntuacion.text=puntuaciones[i]
        viewHolder.itemImage.setImageResource(images[i])
    }

    override fun getItemCount(): Int {
        return titles.size
    }

    inner class ViewHolder(itemView: View): RecyclerView.ViewHolder(itemView){
        var itemImage: ImageView
        var itemTitle: TextView
        var itemDetalle: TextView
        var itemPuntuacion: TextView

        init {
            itemImage = itemView.findViewById(R.id.item_image)
            itemTitle= itemView.findViewById(R.id.item_title)
            itemDetalle = itemView.findViewById(R.id.item_detalle)
            itemPuntuacion = itemView.findViewById(R.id.item_puntuacion)
        }

    }




}