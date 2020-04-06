package com.android.myapplication.views

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.android.myapplication.R
import com.android.myapplication.adapter.HomeAdapter
import com.android.myapplication.contract.MainContract
import com.android.myapplication.helper.HomeContentEnum
import com.android.myapplication.models.*
import com.android.myapplication.presenter.MainPresenter
import com.android.myapplication.utility.SkeletonView
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity(), MainContract.View {

    private lateinit var mainPresenter: MainPresenter
    private lateinit var homeAdapter: HomeAdapter
    private lateinit var homeResponse: HomeResponse

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        homeAdapter = HomeAdapter(this)
        homeResponse = HomeResponse()
        mainPresenter = MainPresenter(this)
        mainPresenter.callGetHomeFlashBanner()
    }

    override fun setupFlashBannerData(flashBanner: List<FlashBanner>) {
        homeResponse.homeItem.add(HomeItem().apply {
            contentType = HomeContentEnum.CAROUSEL.name
            flashBannerList = flashBanner
        })
        mainPresenter.callGetHomeProductCategory()
    }

    override fun setupProductCategoryData(productCategory: List<ProductCategory>) {
        homeResponse.homeItem.add(HomeItem().apply {
            contentType = HomeContentEnum.PRODUCT_CATEGORY.name
            productCategoryList = productCategory
        })
        mainPresenter.callGetHomePromoBanner()
    }

    override fun setupPromoBannerData(promoBanner: List<PromoBanner>) {
        homeResponse.homeItem.add(HomeItem().apply {
            contentType = HomeContentEnum.PROMO_BANNER.name
            promoBannerList = promoBanner
        })
        mainPresenter.callGetPopularProducts()
    }

    override fun setupPopularProductData(popularResponse: PopularProductResponse) {
        for (popular in popularResponse.popularList) {
            homeResponse.homeItem.add(HomeItem().apply {
                contentType = HomeContentEnum.POPULAR_PRODUCT.name
                popularProductList = popular.products
                popularProductHeadTitle = popular.title ?: "-"
            })
        }
        setupHomeAdapter()
    }


    override fun showSkeletonView() {
        SkeletonView.showSkeletonLoadRecycler(rv_home)
    }

    private fun setupHomeAdapter() {
        homeAdapter.setupData(homeResponse)
        rv_home.layoutManager = LinearLayoutManager(this)
        rv_home.adapter = homeAdapter
    }
}
