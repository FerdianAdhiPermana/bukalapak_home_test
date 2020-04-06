package com.android.myapplication.utility

import com.bumptech.glide.load.engine.DiskCacheStrategy
import com.bumptech.glide.request.RequestOptions
import com.google.gson.Gson
import java.text.NumberFormat
import java.util.*

object Utils {

    fun convertObjectToJson(tag: String, obj: Any) {
        val gson = Gson()
        val jsonObject = gson.toJson(obj)
        println(tag + jsonObject)
    }

    fun glideRequestOptions(placeholder: Int): RequestOptions {
        return RequestOptions()
            .placeholder(placeholder)
            .error(placeholder)
            .diskCacheStrategy(DiskCacheStrategy.RESOURCE)
            .dontAnimate()
            .dontTransform()
    }

    fun setRupiah(inputCredit: String): String? {
        var sCredit: String? = null
        val credit: Int
        try {
            if (inputCredit.contains(".")) {
                sCredit = inputCredit.substring(0, inputCredit.indexOf("."))
                credit = Integer.parseInt(sCredit)
                sCredit =
                    "Rp " + NumberFormat.getNumberInstance(Locale.US).format(credit.toLong()).replace(',', '.')
            } else {
                credit = Integer.parseInt(inputCredit)
                sCredit =
                    "Rp " + NumberFormat.getNumberInstance(Locale.US).format(credit.toLong()).replace(',', '.')
            }
        } catch (e: Exception) {
            e.printStackTrace()
        }
        return sCredit
    }

}