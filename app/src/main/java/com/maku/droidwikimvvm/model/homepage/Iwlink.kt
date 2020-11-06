package com.maku.droidwikimvvm.model.homepage


import com.google.gson.annotations.SerializedName

data class Iwlink(
    @SerializedName("prefix")
    val prefix: String, // commons
    @SerializedName("url")
    val url: String, // https://commons.wikimedia.org/wiki/
    @SerializedName("*")
    val x: String // commons:
)