package com.kimbh.simplelist.data.source

import com.kimbh.simplelist.data.remote.api.ApiService
import com.kimbh.simplelist.data.remote.model.ImagesResponse
import javax.inject.Inject

class ImagesDataSource @Inject constructor(
    private val apiService: ApiService
) {
    suspend fun images(query: String, sort: String?, page: Int): ImagesResponse =
        apiService.images(
            query = query, sort = sort, page = page
        )
}