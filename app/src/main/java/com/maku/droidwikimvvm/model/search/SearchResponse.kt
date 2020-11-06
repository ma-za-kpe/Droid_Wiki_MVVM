package com.maku.droidwikimvvm.model.search


import com.google.gson.annotations.SerializedName

data class SearchResponse(
    @SerializedName("batchcomplete")
    val batchcomplete: String,
    @SerializedName("continue")
    val continueX: Continue,
    @SerializedName("query")
    val query: Query
)