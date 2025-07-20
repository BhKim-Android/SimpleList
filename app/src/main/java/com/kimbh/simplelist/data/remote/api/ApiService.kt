package com.kimbh.simplelist.data.remote.api

import com.kimbh.simplelist.data.remote.model.ImagesResponse
import retrofit2.http.GET
import retrofit2.http.Query

/**
 * query	String	Search query you want to search.	O
 * sort	String	Sorting method of the document results.
 * accuracy (accuracy order) or recency (latest).
 * (Default: accuracy)	X
 * page	Integer	Result page number.
 * A value between 1 and 50.
 * (Default: 1)	X
 * size	Integer	Number of documents to be displayed on a single page.
 * A value between 1 and 50.
 * (Default: 10)	X*/

interface ApiService {
    @GET("image")
    suspend fun images(
        @Query("query") query: String,
        @Query("sort") sort: String? = null,
        @Query("page") page: Int? = null,
        @Query("size") size: Int = 10
    ): ImagesResponse
}