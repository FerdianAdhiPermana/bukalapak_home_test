package com.android.myapplication.utility

import androidx.recyclerview.widget.RecyclerView
import com.android.myapplication.R
import com.ethanhua.skeleton.Skeleton
import com.ethanhua.skeleton.SkeletonScreen

object SkeletonView {
    private const val shimmerAngle = 0
    private var skeletonScreen: SkeletonScreen? = null

    fun destroySkeleton() {
        skeletonScreen = null
    }

    fun showSkeletonView(recyclerView: RecyclerView, itemLayout: Int) {
        try {
            skeletonScreen = Skeleton.bind(recyclerView)
                .shimmer(true)
                .color(R.color.color_white)
                .angle(shimmerAngle)
                .frozen(true)
                .count(5)
                .load(itemLayout)
                .show() as SkeletonScreen
        } catch (e: Exception) {
            e.printStackTrace()
        }
    }

    fun showSkeletonView(recyclerView: RecyclerView, itemLayout: Int, itemCount: Int) {
        try {
            skeletonScreen = Skeleton.bind(recyclerView)
                .shimmer(true)
                .color(R.color.color_white)
                .angle(shimmerAngle)
                .frozen(true)
                .count(itemCount)
                .load(itemLayout)
                .show() as SkeletonScreen
        } catch (e: Exception) {
            e.printStackTrace()
        }
    }

    fun showSkeletonLoadRecycler(recyclerView: RecyclerView) {
        try {
            skeletonScreen = Skeleton.bind(recyclerView)
                .shimmer(false)
                .color(R.color.color_transparent)
                .frozen(true)
                .load(R.layout.skeleton_loading_full)
                .show() as SkeletonScreen
        } catch (e: Exception) {
            e.printStackTrace()
        }
    }
}