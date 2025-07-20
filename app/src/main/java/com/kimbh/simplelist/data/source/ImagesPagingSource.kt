package com.kimbh.simplelist.data.source

import android.util.Log
import androidx.paging.PagingSource
import androidx.paging.PagingState
import com.kimbh.simplelist.domain.model.Document

class ImagesPagingSource(
    private val imagesDataSource: ImagesDataSource,
    private val query: String,
    private val sort: String?
): PagingSource<Int, Document>() {
    override fun getRefreshKey(state: PagingState<Int, Document>): Int? =
        state.anchorPosition?.let { anchor ->
            state.closestPageToPosition(anchor)?.prevKey?.plus(1)
                ?: state.closestPageToPosition(anchor)?.nextKey?.minus(1)
        }

    override suspend fun load(params: LoadParams<Int>): LoadResult<Int, Document> {
        return try {
            val page = params.key ?: 1
            val response = imagesDataSource.images(
                query = query,
                sort = sort,
                page = page
            )
            val document = response.documents.map {
                Log.d("kimbh", "collection : ${it.collection}")
                Document(
                    collection = it.collection,
                    thumbnail_url = it.thumbnail_url,
                    image_url = it.image_url,
                    display_sitename = it.display_sitename,
                    doc_url = it.doc_url,
                    datetime = it.datetime
                )
            }

            LoadResult.Page(
                data = document,
                prevKey = if (page == 1) null else page - 1,
                nextKey = if (response.meta.is_end) null else page + 1
            )
        } catch (e: Exception) {
            e.printStackTrace()
            LoadResult.Error(e)
        }
    }
}