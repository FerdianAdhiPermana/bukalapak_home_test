package com.android.myapplication.models

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class HomeResponse(
    var homeItem: ArrayList<HomeItem> = arrayListOf()
) : Parcelable

@Parcelize
data class HomeItem(
    var contentType: String? = "",
    var flashBannerList: List<FlashBanner> = arrayListOf(),
    var productCategoryList: List<ProductCategory> = arrayListOf(),
    var promoBannerList: List<PromoBanner> = arrayListOf(),
    var popularProductList: List<Product> = arrayListOf(),
    var popularProductHeadTitle: String = ""
) : Parcelable
