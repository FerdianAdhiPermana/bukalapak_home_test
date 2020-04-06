package com.android.myapplication.connection

import com.android.myapplication.BuildConfig
import com.android.myapplication.connection.interfaces.ApiCollections
import com.google.gson.GsonBuilder
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

/**
 * Created by Stefanus Candra on 08/08/2019.
 */
class RetrofitService {

    companion object {

        private const val TIMEOUT_CONNECTION: Long = 30
        val gson = GsonBuilder().serializeNulls().setLenient().create()

        private val okHttpClient = OkHttpClient.Builder()
            .readTimeout(TIMEOUT_CONNECTION, TimeUnit.SECONDS)
            .connectTimeout(TIMEOUT_CONNECTION, TimeUnit.SECONDS)
            .retryOnConnectionFailure(false)
            .build()

        fun request(): ApiCollections {
            val retrofit = Retrofit.Builder()
                .baseUrl(BuildConfig.BASE_URL)
                .addConverterFactory(GsonConverterFactory.create(gson))
                .client(okHttpClient.newBuilder().build())
                .build()
            return retrofit.create(ApiCollections::class.java)
        }
    }

}