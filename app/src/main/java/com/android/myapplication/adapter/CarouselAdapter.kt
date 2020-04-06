package com.android.myapplication.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.viewpager.widget.PagerAdapter
import com.android.myapplication.R
import com.android.myapplication.models.FlashBanner
import com.android.myapplication.utility.Utils
import com.bumptech.glide.Glide
import kotlinx.android.synthetic.main.item_carousel.view.*

class CarouselAdapter : PagerAdapter() {

    private var carouselData = listOf<FlashBanner>()

    fun setCarouselData(carousel: List<FlashBanner>) {
        this.carouselData = carousel
    }

    override fun isViewFromObject(view: View, `object`: Any): Boolean {
        return view == `object`
    }

    override fun getCount(): Int = carouselData.size

    override fun destroyItem(container: ViewGroup, position: Int, `object`: Any) {
        container.removeView(`object` as View)
    }

    override fun instantiateItem(container: ViewGroup, position: Int): Any {
        val view = LayoutInflater.from(container.context).inflate(R.layout.item_carousel, container, false)
        Glide.with(container.context)
            .load(carouselData[position].image)
            .apply(Utils.glideRequestOptions(R.drawable.ic_launcher_background))
            .into(view.iv_item_carousel)
        container.addView(view)
        return view
    }
}