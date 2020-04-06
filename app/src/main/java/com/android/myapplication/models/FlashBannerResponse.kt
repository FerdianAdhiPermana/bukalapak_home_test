package com.android.myapplication.models


import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize

@Parcelize
data class FlashBannerResponse(
    @SerializedName("banners") var bannerList: List<FlashBanner> = arrayListOf()
) : MainResponse(), Parcelable

@Parcelize
data class FlashBanner(
    @SerializedName("description") var description: String? = "",
    @SerializedName("image") var image: String? = "",
    @SerializedName("info") var info: Info? = Info(),
    @SerializedName("open_new_window") var openNewWindow: Boolean? = false
): Parcelable

@Parcelize
data class Info(
    @SerializedName("id") var id: Int? = 0,
    @SerializedName("promo_due") var promoDue: String? = "",
    @SerializedName("type") var type: String? = "",
    @SerializedName("url") var url: String? = ""
): Parcelable