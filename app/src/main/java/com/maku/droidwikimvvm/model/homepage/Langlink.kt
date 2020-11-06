package com.maku.droidwikimvvm.model.homepage


import com.google.gson.annotations.SerializedName

data class Langlink(
    @SerializedName("autonym")
    val autonym: String, // Simple English
    @SerializedName("lang")
    val lang: String, // simple
    @SerializedName("langname")
    val langname: String, // Simple English
    @SerializedName("url")
    val url: String, // https://simple.wikipedia.org/wiki/
    @SerializedName("*")
    val x: String
)