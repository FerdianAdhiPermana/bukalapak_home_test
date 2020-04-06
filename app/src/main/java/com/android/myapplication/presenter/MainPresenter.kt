package com.android.myapplication.presenter

import com.android.myapplication.connection.ConnectionManager
import com.android.myapplication.connection.RetrofitService
import com.android.myapplication.connection.interfaces.ConnectionCallback
import com.android.myapplication.contract.MainContract
import com.android.myapplication.helper.Constants
import com.android.myapplication.models.*
import retrofit2.Call
import retrofit2.Response

class MainPresenter(private val mainView: MainContract.View) : MainContract.Presenter {

    private val connectionManager = ConnectionManager()

    override fun callGetHeadlineNews() {
        mainView.showSkeletonView()
        val call = RetrofitService.request().getTopHeadlines(Constants.ApiUrl.GET_HEADLINE_NEWS)
        connectionManager.connect(call, object : ConnectionCallback {
            override fun onSuccessResponse(call: Call<*>, response: Response<*>) {
                val res = response.body() as NewsModel
            }

            override fun onFailure(call: Call<*>) {

            }
        })
    }

    override fun callGetHomeFlashBanner() {
        val call = RetrofitService.request().getFlashBanner()
        connectionManager.connect(call, object : ConnectionCallback {
            override fun onSuccessResponse(call: Call<*>, response: Response<*>) {
                val res = response.body() as FlashBannerResponse
                mainView.setupFlashBannerData(res.bannerList)
            }

            override fun onFailure(call: Call<*>) {
            }
        })
    }

    override fun callGetHomeProductCategory() {
        val call = RetrofitService.request().getProductCategories()
        connectionManager.connect(call, object : ConnectionCallback {
            override fun onSuccessResponse(call: Call<*>, response: Response<*>) {
                val res = response.body() as ProductCategoryResponse
                mainView.setupProductCategoryData(res.categoryList)
            }

            override fun onFailure(call: Call<*>) {
            }
        })
    }

    override fun callGetHomePromoBanner() {
        val call = RetrofitService.request().getPromoBanner()
        connectionManager.connect(call, object : ConnectionCallback {
            override fun onSuccessResponse(call: Call<*>, response: Response<*>) {
                val res = response.body() as PromoBannerResponse
                mainView.setupPromoBannerData(res.promoBannerList)
            }

            override fun onFailure(call: Call<*>) {
            }
        })
    }

    override fun callGetPopularProducts() {
        val call = RetrofitService.request().getPopularProduct()
        connectionManager.connect(call, object : ConnectionCallback {
            override fun onSuccessResponse(call: Call<*>, response: Response<*>) {
                val res = response.body() as PopularProductResponse
                mainView.setupPopularProductData(res)
            }

            override fun onFailure(call: Call<*>) {
            }
        })
    }
}