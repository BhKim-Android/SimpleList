package com.kimbh.simplelist.presentation.viewmodel

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.paging.PagingData
import androidx.paging.cachedIn
import com.kimbh.simplelist.domain.model.Document
import com.kimbh.simplelist.domain.usecase.ImagesUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.emitAll
import kotlinx.coroutines.flow.emptyFlow
import kotlinx.coroutines.flow.flatMapLatest
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(
    private val imagesUseCase: ImagesUseCase
) : ViewModel() {
    private val queryFlow = MutableSharedFlow<String>(replay = 1)

    val document = queryFlow.flatMapLatest {
        imagesUseCase(query = it, page = 1)
    }.cachedIn(viewModelScope)

    fun search(query: String) = viewModelScope.launch {
        queryFlow.emit(query)
    }
}