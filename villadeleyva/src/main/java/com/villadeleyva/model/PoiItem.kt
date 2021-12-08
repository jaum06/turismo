package com.villadeleyva.model


import com.google.gson.annotations.SerializedName
import java.io.Serializable

data class PoiItem(
    @SerializedName("description")
    val description: String,
    @SerializedName("name")
    val name: String,
    @SerializedName("score")
    val score: String,
    @SerializedName("urlPicture")
    val urlPicture: String,
    @SerializedName("detail")
    val detail: String,
    @SerializedName("longitud")
    val longitud: Double,
    @SerializedName("latitud")
    val latitud: Double,
    @SerializedName("zoom")
    val zoom: Float
): Serializable