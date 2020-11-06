package com.maku.droidwikimvvm.model.homepage


import com.google.gson.annotations.SerializedName

data class Parse(
    @SerializedName("categories")
    val categories: List<Any>,
    @SerializedName("displaytitle")
    val displaytitle: String, // Main Page
    @SerializedName("externallinks")
    val externallinks: List<String>,
    @SerializedName("images")
    val images: List<String>,
    @SerializedName("iwlinks")
    val iwlinks: List<Iwlink>,
    @SerializedName("langlinks")
    val langlinks: List<Langlink>,
    @SerializedName("links")
    val links: List<Link>,
    @SerializedName("pageid")
    val pageid: Int, // 15580374
    @SerializedName("parsewarnings")
    val parsewarnings: List<Any>,
    @SerializedName("properties")
    val properties: List<Property>,
    @SerializedName("revid")
    val revid: Int, // 986033447
    @SerializedName("sections")
    val sections: List<Section>,
    @SerializedName("templates")
    val templates: List<Template>,
    @SerializedName("text")
    val text: Text,
    @SerializedName("title")
    val title: String // Main Page
)