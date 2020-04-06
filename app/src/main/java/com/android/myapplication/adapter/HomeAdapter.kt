package com.android.myapplication.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.android.myapplication.R
import com.android.myapplication.helper.HomeContentEnum
import com.android.myapplication.models.*
import kotlinx.android.synthetic.main.item_home_carousel.view.*
import kotlinx.android.synthetic.main.item_home_popular_product.view.*
import kotlinx.android.synthetic.main.item_home_product_category.view.*
import kotlinx.android.synthetic.main.item_home_promo_banner.view.*

class HomeAdapter(val context: Context) : RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    private val TYPE_CAROUSEL = 0
    private val TYPE_PRODUCT_CATEGORY = 1
    private val TYPE_PROMO_BANNER = 2
    private val TYPE_TOP_PRODUCT = 3

    private var homeData = ArrayList<HomeItem>()

    fun setupData(home: HomeResponse) {
        this.homeData = home.homeItem
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        return when (viewType) {
            TYPE_CAROUSEL -> {
                CarouselHolder(LayoutInflater.from(parent.context).inflate(R.layout.item_home_carousel, parent, false))
            }
            TYPE_PRODUCT_CATEGORY -> {
                ProductCateoryHolder(LayoutInflater.from(parent.context).inflate(R.layout.item_home_product_category, parent, false))
            }
            TYPE_PROMO_BANNER -> {
                PromoBannerHolder(LayoutInflater.from(parent.context).inflate(R.layout.item_home_promo_banner, parent, false))
            }
            TYPE_TOP_PRODUCT -> {
                PopularProductHolder(LayoutInflater.from(parent.context).inflate(R.layout.item_home_popular_product, parent, false))
            }
            else -> throw RuntimeException("No holder type matches")
        }
    }

    override fun getItemViewType(position: Int): Int {
        return when (homeData[position].contentType) {
            HomeContentEnum.CAROUSEL.name -> TYPE_CAROUSEL
            HomeContentEnum.PRODUCT_CATEGORY.name -> TYPE_PRODUCT_CATEGORY
            HomeContentEnum.PROMO_BANNER.name -> TYPE_PROMO_BANNER
            else -> TYPE_TOP_PRODUCT
        }
    }

    override fun getItemCount(): Int = homeData.size

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        when (holder.itemViewType) {
            TYPE_CAROUSEL -> {
                holder as CarouselHolder
                holder.setCarousel(homeData[position].flashBannerList)
            }
            TYPE_PRODUCT_CATEGORY -> {
                holder as ProductCateoryHolder
                holder.setData(homeData[position].productCategoryList)
            }
            TYPE_PROMO_BANNER -> {
                holder as PromoBannerHolder
                holder.setData(homeData[position].promoBannerList)
            }
            TYPE_TOP_PRODUCT -> {
                holder as PopularProductHolder
                holder.setData(homeData[position])
            }
        }
    }

    inner class CarouselHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        fun setCarousel(carousel: List<FlashBanner>) {
            val carouselAdapter = CarouselAdapter()
            carouselAdapter.setCarouselData(carousel)
            itemView.vp_main_carousel.adapter = carouselAdapter
        }
    }

    inner class ProductCateoryHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        fun setData(productCategory: List<ProductCategory>) {
            val productCategoryAdapter = ProductCategoryAdapter()
            productCategoryAdapter.setCategoryData(productCategory)
            itemView.rv_product_category.layoutManager = GridLayoutManager(context, 2, GridLayoutManager.HORIZONTAL, false)
            itemView.rv_product_category.adapter = productCategoryAdapter
        }
    }

    inner class PromoBannerHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        fun setData(promoBanner: List<PromoBanner>) {
            val promoBannerAdapter = PromoBannerAdapter(context)
            promoBannerAdapter.setPromoBannerData(promoBanner)
            itemView.rv_promo_banner.layoutManager = LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, false)
            itemView.rv_promo_banner.adapter = promoBannerAdapter
        }
    }

    inner class PopularProductHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        fun setData(home: HomeItem) {
            val popularProductAdapter = PopularProductAdapter(context)
            popularProductAdapter.setPopularProductData(home.popularProductList)
            itemView.tv_popular_header_title.text = home.popularProductHeadTitle
            itemView.rv_popular_product.layoutManager = LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, false)
            itemView.rv_popular_product.adapter = popularProductAdapter
        }
    }
}