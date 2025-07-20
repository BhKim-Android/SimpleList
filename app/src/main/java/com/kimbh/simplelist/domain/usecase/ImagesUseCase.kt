package com.kimbh.simplelist.domain.usecase

import androidx.paging.PagingData
import com.kimbh.simplelist.domain.model.Document
import com.kimbh.simplelist.domain.repository.ImagesRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class ImagesUseCase @Inject constructor(
    private val imagesRepository: ImagesRepository
) {
    suspend operator fun invoke(
        query: String,
        sort: String? = null,
        page: Int
    ): Flow<PagingData<Document>> = imagesRepository.images(query = query, sort = sort, page = page)
}