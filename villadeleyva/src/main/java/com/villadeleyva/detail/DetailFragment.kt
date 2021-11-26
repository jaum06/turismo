package com.villadeleyva.detail

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.navArgs
import com.squareup.picasso.Picasso
import com.villadeleyva.databinding.FragmentDetailBinding


class DetailFragment : Fragment() {

    private lateinit var detailBinding: FragmentDetailBinding
    private val args : DetailFragmentArgs by navArgs()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        detailBinding = FragmentDetailBinding.inflate(inflater, container, false)
        return detailBinding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val poi = args.poi

        with(detailBinding){
            textView.text = poi.name
            textView10.text = poi.score.toString()
            textView9.text = poi.description
            Picasso.get().load(poi.urlPicture).into(imageView)
        }
    }

}