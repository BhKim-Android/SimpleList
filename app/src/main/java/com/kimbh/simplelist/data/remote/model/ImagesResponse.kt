package com.kimbh.simplelist.data.remote.model

import com.google.gson.annotations.SerializedName

data class ImagesResponse(
    @SerializedName("meta")
    val meta: MetaDto,

    @SerializedName("documents")
    val documents: List<DocumentDTO>
)
