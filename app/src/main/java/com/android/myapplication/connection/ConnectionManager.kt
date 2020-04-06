package com.android.myapplication.connection

import android.util.Log
import com.android.myapplication.connection.interfaces.ConnectionCallback
import com.android.myapplication.helper.enqueue
import retrofit2.Call
import retrofit2.Response

class ConnectionManager {

    private lateinit var connectionCallback: ConnectionCallback
    private lateinit var call: Call<*>
    private val TAG = "API_RESPONSE"

    fun connect(call: Call<*>, connectionCallback: ConnectionCallback) {
        this.call = call
        this.connectionCallback = connectionCallback
        callApiRequest()
    }

    private fun callApiRequest() {
        call.clone().enqueue {
            onResponse = { call: Call<out Any>, response: Response<out Any> ->
                Log.i(TAG, "Response Code : " + response.code() + ", URL:" + response.raw().request().url().toString())
                connectionCallback.onSuccessResponse(call, response)
            }
            onFailure = { call: Call<out Any>, t: Throwable? ->
                Log.i(TAG, "Retrofit onFailure, URL:" + call.request().url().toString())
                if (t != null)
                    connectionCallback.onFailure(call)
            }
        }
    }

}