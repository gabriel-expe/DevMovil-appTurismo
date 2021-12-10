package com.devmovil.appTurismo.detalle

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.widget.Toolbar
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import com.devmovil.appTurismo.R
import com.devmovil.appTurismo.databinding.FragmentDetallesBinding
import com.squareup.picasso.Picasso

class DetallesFragment : Fragment() {
    private lateinit var detallesBinding: FragmentDetallesBinding
    private val args:DetallesFragmentArgs by navArgs()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        detallesBinding = FragmentDetallesBinding.inflate(inflater,container,false)
        return detallesBinding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val lugar = args.lugar
        with(detallesBinding){
            Titulo.text = lugar.nombre
            Ubicacion.text = lugar.ubicacion
            Temperatura.text = lugar.temperatura
            Parrafo.text = lugar.parrafo
            Actividades.text = lugar.actividades
            Picasso.get().load(lugar.urlImagen).into(Image)

            mapButton.setOnClickListener{
                val lat = lugar.latitud
                val lng = lugar.longitud
                val actionDetail = DetallesFragmentDirections.actionDetallesFragmentToMapsFragment(lat, lng)

                println(lat)
                println(lng)
                findNavController().navigate(actionDetail)
            }

        }
    }


}