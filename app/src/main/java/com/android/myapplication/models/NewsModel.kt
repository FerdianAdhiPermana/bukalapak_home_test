package com.android.myapplication.models

import com.google.gson.annotations.SerializedName

data class NewsModel(
    @SerializedName("articles") var articleList: ArrayList<News> = arrayListOf()
) : MainResponse()