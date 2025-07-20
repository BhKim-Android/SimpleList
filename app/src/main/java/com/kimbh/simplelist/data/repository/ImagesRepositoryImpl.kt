package com.kimbh.simplelist.data.repository

import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.PagingData
import com.kimbh.simplelist.data.source.ImagesDataSource
import com.kimbh.simplelist.data.source.ImagesPagingSource
import com.kimbh.simplelist.domain.model.Document
import com.kimbh.simplelist.domain.repository.ImagesRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class ImagesRepositoryImpl @Inject constructor(
    private val imagesDataSource: ImagesDataSource
) : ImagesRepository {
    override suspend fun images(
        query: String,
        sort: String?,
        page: Int
    ): Flow<PagingData<Document>> =
        Pager(
            config = PagingConfig(pageSize = 5),
            pagingSourceFactory = {
                ImagesPagingSource(
                    imagesDataSource = imagesDataSource,
                    query = query,
                    sort = sort
                )
            }
        ).flow
}