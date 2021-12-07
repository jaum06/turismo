package com.villadeleyva.list

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.navigation.NavController
import androidx.navigation.Navigation
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.google.gson.Gson
import com.villadeleyva.R
import com.villadeleyva.databinding.FragmentListBinding
import com.villadeleyva.main.MainActivity
import com.villadeleyva.model.Poi
import com.villadeleyva.model.PoiItem


class ListFragment : Fragment() {

    private lateinit var listBinding: FragmentListBinding
    private lateinit var listPoi: ArrayList<PoiItem>
    private lateinit var poiAdapter: PoiAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        listBinding = FragmentListBinding.inflate(inflater, container, false)
        return listBinding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        (activity as MainActivity?)?.hideIcon()
        listPoi = loadMockPoiFromJson()
        poiAdapter = PoiAdapter(listPoi,onItemClicked = {onPoiClicked(it)})
        listBinding.poiRecyclerView.apply{
            layoutManager = LinearLayoutManager(context,LinearLayoutManager.HORIZONTAL,false)
            adapter = poiAdapter
            setHasFixedSize(false)
        }
    }

    private fun onPoiClicked(poI:PoiItem){
        findNavController().navigate(ListFragmentDirections.actionListFragmentToDetailFragment(poI))

    }

    private fun loadMockPoiFromJson(): ArrayList<PoiItem>{
        val poiString: String = context?.assets?.open("pois.json")?.bufferedReader().use{ it!!.readText()}//TODO reparar !!
        val gson = Gson()
        val poiList = gson.fromJson(poiString,Poi::class.java)
        return poiList
    }
}