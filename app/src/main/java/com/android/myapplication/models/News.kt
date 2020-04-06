package com.android.myapplication.models

import com.google.gson.annotations.SerializedName

data class News(
    @SerializedName("title") var newsTitle: String = "",
    @SerializedName("description") var newsDescription: String = "",
    @SerializedName("url") var newsVideoUrl: String = "",
    @SerializedName("urlToImage") var newsImageUrl: String = ""
)