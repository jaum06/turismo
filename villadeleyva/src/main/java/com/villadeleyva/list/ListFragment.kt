package com.villadeleyva.list

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.google.gson.Gson
import com.villadeleyva.databinding.FragmentListBinding
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
        listPoi = loadMockPoiFromJson()
        poiAdapter = PoiAdapter(listPoi,onItemClicked = {onPoiClicked(it)})
    }

    private fun onPoiClicked(poI:PoiItem){
        //TODO programar detalle

    }

    private fun loadMockPoiFromJson(): ArrayList<PoiItem>{
        val poiString: String = context?.assets?.open("pois.json")?.bufferedReader().use{ it!!.readText()}//TODO reparar !!
        val gson = Gson()
        val poiList = gson.fromJson(poiString,Poi::class.java)
        return poiList
    }

}