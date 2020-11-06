package com.maku.droidwikimvvm.model.search


import com.google.gson.annotations.SerializedName

data class Query(
    @SerializedName("search")
    val search: List<Search>,
    @SerializedName("searchinfo")
    val searchinfo: Searchinfo
)