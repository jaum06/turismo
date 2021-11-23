package com.zlasher.turismo

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.gson.Gson


class ListPoiActivity : AppCompatActivity() {

    private lateinit var listPoi: ArrayList<PoiItem>
    private lateinit var poiAdapter: PoiAdapter
    private lateinit var poiRecyclerView: RecyclerView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_list_poi)

        poiRecyclerView = findViewById(R.id.poi_recycler_view)

        listPoi = loadMockPoiFromJson()

        poiAdapter = PoiAdapter(listPoi)

        poiRecyclerView.apply {
            layoutManager = LinearLayoutManager(context)
            adapter = poiAdapter
            setHasFixedSize(false)
        }

        poiRecyclerView.adapter = poiAdapter
    }

    private fun loadMockPoiFromJson(): ArrayList<PoiItem> {
        val poiString: String =
            applicationContext.assets.open("pois.json").bufferedReader().use { it.readText() }
        val gson = Gson()
        val poiList = gson.fromJson(poiString, Poi::class.java)

        return poiList
    }
}