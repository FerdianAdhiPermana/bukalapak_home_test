package com.android.myapplication.models


import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize

@Parcelize
data class PopularProductResponse(
    @SerializedName("populars") var popularList: List<Popular> = arrayListOf()
) : MainResponse(), Parcelable

@Parcelize
data class Popular(
    @SerializedName("campaign_id") var campaignId: Int? = 0,
    @SerializedName("icon_url") var iconUrl: String? = "",
    @SerializedName("title") var title: String? = "",
    @SerializedName("products") var products: List<Product> = arrayListOf()
) : Parcelable