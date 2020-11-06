package com.maku.droidwikimvvm.network

import com.maku.droidwikimvvm.model.homepage.Homepage
import com.maku.droidwikimvvm.model.search.SearchResponse
import com.maku.droidwikimvvm.utils.Const
import okhttp3.Call
import okhttp3.HttpUrl.Companion.toHttpUrlOrNull
import okhttp3.Request
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query


interface WikiService {
    //https://en.wikipedia.org/w/api.php?action=query&list=search&format=json&srsearch=beef
    @GET("/w/api.php")
    suspend fun searchWiki(
        @Query("action") action: String,
        @Query("list") list: String,
        @Query("format") format: String,
        @Query("srsearch") srsearch: String): Response<SearchResponse>?

    //https://en.wikipedia.org/w/api.php?action=parse&page=Main%20Page&format=json
    @GET("/w/api.php")
    suspend fun getHomePage(
        @Query("action") action: String,
        @Query("page") page: String,
        @Query("format") format: String): Response<Homepage>?

}