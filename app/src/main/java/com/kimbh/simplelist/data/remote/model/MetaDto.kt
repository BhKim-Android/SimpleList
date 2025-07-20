package com.kimbh.simplelist.data.remote.model

import com.google.gson.annotations.SerializedName

/**
 * total_count	Integer	Number of documents found.
 * pageable_count	Integer	Number of documents to be displayed out of all documents (total_count).
 * is_end	Boolean	Whether the current page is the last page. If false, you can request the next page by incrementing the value of page.*/

data class MetaDto(
    @SerializedName("total_count")
    val total_count: Int,

    @SerializedName("pageable_count")
    val pageable_count: Int,

    @SerializedName("is_end")
    val is_end: Boolean
)
