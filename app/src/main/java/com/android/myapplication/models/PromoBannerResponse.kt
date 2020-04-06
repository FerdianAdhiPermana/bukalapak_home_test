package com.android.myapplication.models


import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize

@Parcelize
data class PromoBannerResponse(
    @SerializedName("promo_banners") var promoBannerList: List<PromoBanner> = arrayListOf()
) : MainResponse(), Parcelable

@Parcelize
data class PromoBanner(
    @SerializedName("description") var description: String? = "",
    @SerializedName("image") var image: String? = "",
    @SerializedName("info") var info: Info? = Info()
) : Parcelable