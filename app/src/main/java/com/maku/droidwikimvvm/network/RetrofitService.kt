package com.maku.droidwikimvvm.network

import com.squareup.okhttp.logging.HttpLoggingInterceptor
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitService {

    //    val logging = HttpLoggingInterceptor()
    //    logging.setLevel(Level.BASIC)
    //    val client: OkHttpClient = Builder()
    //        .addInterceptor(logging)
    //        .build()
    val interceptor = HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.BODY)

    var client: OkHttpClient = OkHttpClient.Builder().build()

    private var retrofit = Retrofit.Builder()
        .baseUrl("https://en.wikipedia.org/")
        .addConverterFactory(GsonConverterFactory.create())
        .client(client)
        .build()

    fun <T> createService(serviceClass: Class<T>): T = retrofit.create(serviceClass)
}