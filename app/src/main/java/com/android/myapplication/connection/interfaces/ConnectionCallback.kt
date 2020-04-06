package com.android.myapplication.connection.interfaces

import retrofit2.Call
import retrofit2.Response

interface ConnectionCallback {
    fun onSuccessResponse(call: Call<*>, response: Response<*>)
    fun onFailure(call: Call<*>)
}