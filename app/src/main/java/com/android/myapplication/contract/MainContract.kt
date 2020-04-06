package com.android.myapplication.contract

import com.android.myapplication.models.FlashBanner
import com.android.myapplication.models.PopularProductResponse
import com.android.myapplication.models.ProductCategory
import com.android.myapplication.models.PromoBanner

interface MainContract {

    interface View {
        fun setupFlashBannerData(flashBanner: List<FlashBanner>)
        fun setupProductCategoryData(productCategory: List<ProductCategory>)
        fun setupPromoBannerData(promoBanner: List<PromoBanner>)
        fun setupPopularProductData(popularResponse: PopularProductResponse)
        fun showSkeletonView()
    }

    interface Presenter {
        fun callGetHeadlineNews()
        fun callGetHomeFlashBanner()
        fun callGetHomeProductCategory()
        fun callGetHomePromoBanner()
        fun callGetPopularProducts()
    }

}