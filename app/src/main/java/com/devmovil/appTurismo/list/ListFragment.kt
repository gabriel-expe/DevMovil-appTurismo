package com.devmovil.appTurismo.list

import android.content.Intent
import android.os.Bundle
import android.view.*
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.devmovil.appTurismo.R
import com.devmovil.appTurismo.databinding.FragmentListBinding
import com.devmovil.appTurismo.main.TurismoAdapter
import com.devmovil.appTurismo.model.ListaLugares
import com.devmovil.appTurismo.model.Lugar
import com.devmovil.appTurismo.preferences.SettingsActivity
import com.google.gson.Gson




class ListFragment : Fragment() {

    private lateinit var listBinding: FragmentListBinding
    private lateinit var listViewModel: ListViewModel
    private lateinit var turismoAdapter : TurismoAdapter
    private var listLugares: ArrayList<Lugar> = arrayListOf()


    override fun onCreateView(

        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        listBinding = FragmentListBinding.inflate(inflater,container,false)
        listViewModel = ViewModelProvider(this)[ListViewModel::class.java]
        return listBinding.root
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        listViewModel.getLugaresfromserver()
        listViewModel.lugaresloaded.observe(viewLifecycleOwner, {result ->
            onlugaresloadedSubscribe(result)
        })

        turismoAdapter = TurismoAdapter(listLugares, onItemClicked = { onLugarClicked(it) })
        listBinding.recyclerView.apply {
            layoutManager = LinearLayoutManager(context)
            adapter = turismoAdapter
            setHasFixedSize(false)
        }


    }

    private fun onlugaresloadedSubscribe(result: ArrayList<Lugar>){
        result?.let {listLugares ->
           turismoAdapter.appendItems(listLugares)

        }
    }



    private fun onLugarClicked(lugar: Lugar) {
        //findNavController().navigate(ListFragmentDirections.navigationDetail(lugar=lugar))
        findNavController().navigate(ListFragmentDirections.actionListFragmentToDetallesFragment(lugar))
    }

    /*
    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        var id=item.itemId

        if(id== R.id.btnConfg){
            toSettings()
            return true
        }
        return super.onOptionsItemSelected(item)
    }*/

    /*private fun toSettings() {
        val intent = Intent(this, SettingsActivity::class.java)
        startActivity(intent)
    }*/

}