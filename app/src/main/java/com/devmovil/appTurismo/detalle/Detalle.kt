package com.devmovil.appTurismo.detalle




import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.devmovil.appTurismo.databinding.DetalleBinding
import com.devmovil.appTurismo.list.Lugar
import com.squareup.picasso.Picasso


class Detalle : AppCompatActivity() {

    private lateinit var detalleBinding: DetalleBinding
    private lateinit var detalleViewModel: DetalleViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        detalleBinding = DetalleBinding.inflate(layoutInflater)
        setContentView(detalleBinding.root)

        val lugar: Lugar = intent.extras?.getSerializable("lugar") as Lugar

        with(detalleBinding){
            Titulo.text = lugar.nombre
            Descripcion.text = lugar.parrafo
            Ubicacion.text = lugar.ubicacion
            Temperatura.text = lugar.temperatura
            Actividades.text = lugar.actividades
            Picasso.get().load(lugar.urlImagen).into(Image)
        }


    }
}