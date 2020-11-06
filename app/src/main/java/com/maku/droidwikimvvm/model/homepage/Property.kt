package com.maku.droidwikimvvm.model.homepage


import com.google.gson.annotations.SerializedName

data class Property(
    @SerializedName("name")
    val name: String, // noexternallanglinks
    @SerializedName("*")
    val x: String // a:1:{i:0;s:1:"*";}
)