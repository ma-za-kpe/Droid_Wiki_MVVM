package com.maku.droidwikimvvm.model.search


import com.google.gson.annotations.SerializedName

data class Search(
    @SerializedName("ns")
    val ns: Int, // 0
    @SerializedName("pageid")
    val pageid: Int, // 36968
    @SerializedName("size")
    val size: Int, // 67421
    @SerializedName("snippet")
    val snippet: String, // <span class="searchmatch">Beef</span> is the culinary name for meat from cattle, particularly skeletal muscle. Humans have been eating <span class="searchmatch">beef</span> since prehistoric times. <span class="searchmatch">Beef</span> is a source of
    @SerializedName("timestamp")
    val timestamp: String, // 2020-10-30T11:03:19Z
    @SerializedName("title")
    val title: String, // Beef
    @SerializedName("wordcount")
    val wordcount: Int // 7047
)