package com.android.myapplication.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.android.myapplication.R
import com.android.myapplication.models.ProductCategory
import kotlinx.android.synthetic.main.item_category.view.*

class ProductCategoryAdapter : RecyclerView.Adapter<ProductCategoryAdapter.CategoryAdapterHolder>() {

    private var categoryData = listOf<ProductCategory>()

    fun setCategoryData(category: List<ProductCategory>) {
        this.categoryData = category
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CategoryAdapterHolder {
        return CategoryAdapterHolder(LayoutInflater.from(parent.context).inflate(R.layout.item_category, parent, false))
    }

    override fun getItemCount(): Int = categoryData.size

    override fun onBindViewHolder(holder: CategoryAdapterHolder, position: Int) {
        holder.setData(categoryData[position])
    }

    inner class CategoryAdapterHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        fun setData(category: ProductCategory) {
            itemView.tv_category.text = category.name
        }
    }
}