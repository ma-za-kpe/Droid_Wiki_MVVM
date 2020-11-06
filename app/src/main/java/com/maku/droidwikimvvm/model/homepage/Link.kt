package com.maku.droidwikimvvm.model.homepage


import com.google.gson.annotations.SerializedName

data class Link(
    @SerializedName("exists")
    val exists: String,
    @SerializedName("ns")
    val ns: Int, // 0
    @SerializedName("*")
    val x: String // Deaths in 2020
)