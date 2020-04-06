package com.android.myapplication.adapter

import android.annotation.SuppressLint
import android.content.Context
import android.graphics.Paint
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.android.myapplication.R
import com.android.myapplication.models.Product
import com.android.myapplication.utility.Utils
import com.bumptech.glide.Glide
import kotlinx.android.synthetic.main.item_popular_product.view.*

class PopularProductAdapter(val context: Context) : RecyclerView.Adapter<PopularProductAdapter.PopularProductHolder>() {

    private var popularProductData = listOf<Product>()

    fun setPopularProductData(products: List<Product>) {
        this.popularProductData = products
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PopularProductHolder {
        return PopularProductHolder(LayoutInflater.from(parent.context).inflate(R.layout.item_popular_product, parent, false))
    }

    override fun getItemCount(): Int = popularProductData.size

    override fun onBindViewHolder(holder: PopularProductHolder, position: Int) {
        holder.setData(popularProductData[position])
    }

    inner class PopularProductHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        @SuppressLint("SetTextI18n")
        fun setData(product: Product) {
            itemView.tv_popular_product_name.text = product.name ?: "-"
            Glide.with(context)
                .load(product.images?.get(0))
                .apply(Utils.glideRequestOptions(R.drawable.ic_launcher_background))
                .into(itemView.iv_popular_product)

            if (product.dealInfo?.discountPrice != 0) {
                itemView.tv_discount_percent.text = product.dealInfo?.discountPercentage.toString() + " %"
                itemView.tv_popular_product_price_normal.text = Utils.setRupiah(product.dealInfo?.originalPrice.toString())
                itemView.tv_popular_product_price_normal.paintFlags = itemView.tv_popular_product_price_normal.paintFlags or Paint.STRIKE_THRU_TEXT_FLAG
                itemView.tv_popular_product_price_discount.text = Utils.setRupiah(product.dealInfo?.discountPrice.toString())

                itemView.tv_discount_percent.visibility = View.VISIBLE
                itemView.tv_popular_product_price_discount.visibility = View.VISIBLE
            } else {
                itemView.tv_popular_product_price_normal.text = Utils.setRupiah(product.price.toString())
            }
        }
    }
}