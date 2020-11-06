package com.maku.droidwikimvvm.model.search


import com.google.gson.annotations.SerializedName

data class Searchinfo(
    @SerializedName("suggestion")
    val suggestion: String, // beens
    @SerializedName("suggestionsnippet")
    val suggestionsnippet: String, // beens
    @SerializedName("totalhits")
    val totalhits: Int // 17688
)