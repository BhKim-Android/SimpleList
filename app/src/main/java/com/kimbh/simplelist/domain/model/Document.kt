package com.kimbh.simplelist.domain.model

import com.google.gson.annotations.SerializedName

data class Document(
    val collection: String,
    val thumbnail_url: String,
    val image_url: String,
    val display_sitename: String,
    val doc_url: String,
    val datetime: String
)
