package com.maku.droidwikimvvm.model.search


import com.google.gson.annotations.SerializedName

data class Continue(
    @SerializedName("continue")
    val continueX: String, // -||
    @SerializedName("sroffset")
    val sroffset: Int // 10
)