package com.android.myapplication.connection.interfaces

import com.android.myapplication.helper.Constants
import com.android.myapplication.models.*
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Url

interface ApiCollections {

    @GET
    fun getTopHeadlines(@Url url: String): Call<NewsModel>

    @GET(Constants.ApiUrl.GET_HOME_FLASH_BANNER)
    fun getFlashBanner(): Call<FlashBannerResponse>

    @GET(Constants.ApiUrl.GET_HOME_CATEGORIES)
    fun getProductCategories(): Call<ProductCategoryResponse>

    @GET(Constants.ApiUrl.GET_HOME_PROMO_BANNERS)
    fun getPromoBanner(): Call<PromoBannerResponse>

    @GET(Constants.ApiUrl.GET_HOME_POPULAR_PRODUCTS)
    fun getPopularProduct(): Call<PopularProductResponse>
}