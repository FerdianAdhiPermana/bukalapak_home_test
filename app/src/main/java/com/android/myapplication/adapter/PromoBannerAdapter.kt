package com.android.myapplication.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.android.myapplication.R
import com.android.myapplication.models.PromoBanner
import com.android.myapplication.utility.Utils
import com.bumptech.glide.Glide
import kotlinx.android.synthetic.main.item_promo_banner.view.*

class PromoBannerAdapter(val context: Context) : RecyclerView.Adapter<PromoBannerAdapter.CategoryAdapterHolder>() {

    private var promoBannerData = listOf<PromoBanner>()

    fun setPromoBannerData(promoBanner: List<PromoBanner>) {
        this.promoBannerData = promoBanner
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CategoryAdapterHolder {
        return CategoryAdapterHolder(LayoutInflater.from(parent.context).inflate(R.layout.item_promo_banner, parent, false))
    }

    override fun getItemCount(): Int = promoBannerData.size

    override fun onBindViewHolder(holder: CategoryAdapterHolder, position: Int) {
        holder.setData(promoBannerData[position])
    }

    inner class CategoryAdapterHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        fun setData(promoBanner: PromoBanner) {
            itemView.tv_promo_banner.text = promoBanner.description
            Glide.with(context)
                .load(promoBanner.image)
                .apply(Utils.glideRequestOptions(R.drawable.ic_launcher_background))
                .into(itemView.iv_promo_banner)
        }
    }
}