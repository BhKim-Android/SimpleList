package com.kimbh.simplelist.data.remote.model

import com.google.gson.annotations.SerializedName

/**
 * collection	String	Collection.
 * thumbnail_url	String	Thumbnail image URL.
 * image_url	String	Image URL.
 * width	Integer	The image width.
 * height	Integer	The image height.
 * display_sitename	String	Source.
 * doc_url	String	Document URL.
 * datetime	Datetime	The time when the document was created in ISO 8601 format. [YYYY]-[MM]-[DD]T[hh]:[mm]:[ss].000+[tz].
 * */
data class DocumentDTO(
    @SerializedName("collection")
    val collection: String,

    @SerializedName("thumbnail_url")
    val thumbnail_url: String,

    @SerializedName("image_url")
    val image_url: String,

    @SerializedName("width")
    val width: Int,

    @SerializedName("height")
    val height: Int,

    @SerializedName("display_sitename")
    val display_sitename: String,

    @SerializedName("doc_url")
    val doc_url: String,

    @SerializedName("datetime")
    val datetime: String
)
