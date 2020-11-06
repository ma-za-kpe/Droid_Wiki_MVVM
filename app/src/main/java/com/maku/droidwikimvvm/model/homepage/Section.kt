package com.maku.droidwikimvvm.model.homepage


import com.google.gson.annotations.SerializedName

data class Section(
    @SerializedName("anchor")
    val anchor: String, // From_today's_featured_article
    @SerializedName("byteoffset")
    val byteoffset: Any, // null
    @SerializedName("index")
    val index: String,
    @SerializedName("level")
    val level: String, // 2
    @SerializedName("line")
    val line: String, // From today's featured article
    @SerializedName("number")
    val number: String, // 1
    @SerializedName("toclevel")
    val toclevel: Int // 1
)