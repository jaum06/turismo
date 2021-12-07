package com.villadeleyva.list

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageButton
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.NavController
import androidx.navigation.Navigation
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.villadeleyva.R
import com.villadeleyva.databinding.FragmentListBinding
import com.villadeleyva.main.MainActivity
import com.villadeleyva.model.PoiItem


class ListFragment : Fragment() {

    private lateinit var listBinding: FragmentListBinding
    private lateinit var listViewModel: ListViewModel
    private lateinit var poiAdapter: PoiAdapter
    private var listPoi: ArrayList<PoiItem> = arrayListOf()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        listBinding = FragmentListBinding.inflate(inflater, container, false)
        listViewModel = ViewModelProvider(this)[ListViewModel::class.java]
        return listBinding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        (activity as MainActivity?)?.hideIcon()
        listViewModel.loadMockPoiFromJson(context?.assets?.open("pois.json"))
        listViewModel.onPoiLoaded.observe(viewLifecycleOwner,{result ->
            onPoiLoadedSubscribe(result)
        })

        poiAdapter = PoiAdapter(listPoi,onItemClicked = {onPoiClicked(it)})

        listBinding.poiRecyclerView.apply{
            layoutManager = LinearLayoutManager(context,LinearLayoutManager.HORIZONTAL,false)
            adapter = poiAdapter
            setHasFixedSize(false)
        }
        listBinding.mapButtons.setOnClickListener {
            findNavController().navigate(ListFragmentDirections.actionListFragmentToMapsFragment())
        }
    }

    private fun onPoiLoadedSubscribe(result: ArrayList<PoiItem>?) {
        result?.let{listaPoi->
            poiAdapter.appendItems(listaPoi)
        }
    }

    private fun onPoiClicked(poI:PoiItem){
        findNavController().navigate(ListFragmentDirections.actionListFragmentToDetailFragment(poI))

    }
}