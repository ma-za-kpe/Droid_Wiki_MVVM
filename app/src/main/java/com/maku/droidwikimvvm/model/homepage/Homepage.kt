package com.maku.droidwikimvvm.model.homepage


import com.google.gson.annotations.SerializedName

data class Homepage(
    @SerializedName("parse")
    val parse: Parse
){
    override fun toString(): String {
        return super.toString()
    }
}