package com.radityalabs.photos.features.library

internal sealed interface LibraryUiState {

    object Loading : LibraryUiState

    data class Success(
        val images: List<String>
    ) : LibraryUiState
}