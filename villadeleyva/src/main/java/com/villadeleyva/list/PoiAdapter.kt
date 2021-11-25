package com.villadeleyva.list

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.squareup.picasso.Picasso
import com.villadeleyva.R
import com.villadeleyva.model.PoiItem

class PoiAdapter(
    private val poiList: ArrayList<PoiItem>,
    private val onItemClicked: (PoiItem)->Unit
) : RecyclerView.Adapter<PoiAdapter.PoiViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PoiViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.card_view_poi_item, parent, false)
        return PoiViewHolder(view)
    }

    override fun onBindViewHolder(holder: PoiViewHolder, position: Int) {
        val poi = poiList[position]
        holder.bind(poi)
    }

    override fun getItemCount(): Int = poiList.size

    class PoiViewHolder(itemview: View) : RecyclerView.ViewHolder(itemview) {
        private var pictureImageView: ImageView = itemview.findViewById(R.id.picture_image_view)
        private var nameTextView: TextView = itemview.findViewById(R.id.name_text_view)
        private var scoreTextView: TextView = itemview.findViewById(R.id.score_text_view)
        private var descriptionTextView: TextView = itemview.findViewById(R.id.description_text_view)

        fun bind(poi: PoiItem) {
            Picasso.get().load(poi.urlPicture).into(pictureImageView)
            nameTextView.text = poi.name
            scoreTextView.text = poi.score
            descriptionTextView.text = poi.description
        }
    }

}