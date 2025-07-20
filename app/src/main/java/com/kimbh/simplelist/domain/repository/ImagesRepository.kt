package com.kimbh.simplelist.domain.repository

import androidx.paging.PagingData
import com.kimbh.simplelist.domain.model.Document
import kotlinx.coroutines.flow.Flow

interface ImagesRepository {
    suspend fun images(
        query: String,
        sort: String?,
        page: Int
    ): Flow<PagingData<Document>>
}