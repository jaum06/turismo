package com.zlasher.turismo


import com.google.gson.annotations.SerializedName

data class PoiItem(
    @SerializedName("description")
    val description: String,
    @SerializedName("name")
    val name: String,
    @SerializedName("score")
    val score: String,
    @SerializedName("urlPicture")
    val urlPicture: String
)