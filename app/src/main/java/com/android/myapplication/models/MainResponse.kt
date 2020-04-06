package com.android.myapplication.models

import android.os.Parcelable
import com.android.myapplication.connection.ConnectionConstants
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize

@Parcelize
open class MainResponse(
    @SerializedName(ConnectionConstants.MainResponse.STATUS)
    private var status: String? = "",
    @SerializedName(ConnectionConstants.MainResponse.MESSAGE)
    private var message: String? = ""
) : Parcelable