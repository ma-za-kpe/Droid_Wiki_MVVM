package com.maku.droidwikimvvm.model.homepage


import com.google.gson.annotations.SerializedName

data class Template(
    @SerializedName("exists")
    val exists: String,
    @SerializedName("ns")
    val ns: Int, // 4
    @SerializedName("*")
    val x: String // Wikipedia:Main Page/styles.css
)