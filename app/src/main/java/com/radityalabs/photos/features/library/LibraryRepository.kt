package com.radityalabs.photos.features.library

import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

internal interface LibraryRepository {
    fun getImages(): Flow<LibraryUiState>
}

internal class DefaultLibraryRepository @Inject constructor() : LibraryRepository {
    override fun getImages(): Flow<LibraryUiState> {
        return flow {
            val images = (1..100).map { "https://picsum.photos/id/$it/200/300" }
            emit(LibraryUiState.Success(images))
        }
    }
}