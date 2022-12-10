package com.radityalabs.photos.features.library

import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

internal interface LibraryRepository {
    fun getImages(): Flow<String>
}

internal class DefaultLibraryRepository @Inject constructor() : LibraryRepository {
    override fun getImages(): Flow<String> {
        return flow {
            (0..100).forEach { index ->
                val url = "https://picsum.photos/id/$index/200/300"

                emit(url)
            }
        }
    }
}