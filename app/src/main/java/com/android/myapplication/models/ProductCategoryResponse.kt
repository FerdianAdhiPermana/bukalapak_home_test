package com.android.myapplication.models


import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize

@Parcelize
data class ProductCategoryResponse(
    @SerializedName("categories") var categoryList: List<ProductCategory> = arrayListOf()
) : MainResponse(), Parcelable

@Parcelize
data class ProductCategory(
    @SerializedName("id") var id: Int? = 0,
    @SerializedName("name") var name: String? = "",
    @SerializedName("revamped") var revamped: Boolean? = false,
    @SerializedName("url") var url: String? = ""
) : Parcelable