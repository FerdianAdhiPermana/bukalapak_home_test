package com.android.myapplication.helper

import com.android.myapplication.connection.RetrofitCallback
import retrofit2.Call

fun <T> Call<T>.enqueue(callback: RetrofitCallback<T>.() -> Unit) {
    val rc = RetrofitCallback<T>()
    callback.invoke(rc)
    this.enqueue(rc)
}