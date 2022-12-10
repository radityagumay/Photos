package com.radityalabs.photos.features.library

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.stateIn
import javax.inject.Inject

@HiltViewModel
internal class LibraryScreenViewModel @Inject constructor() : ViewModel() {

    val addressWherePictureTook: StateFlow<String> = flow {
        delay(1_000)
        emit("Jakarta")
        delay(1_000)
        emit("Bali")
    }.stateIn(
        scope = viewModelScope,
        started = SharingStarted.WhileSubscribed(5_000),
        initialValue = ""
    )

    val dateWherePictureTook: StateFlow<String> = flow {
        emit("10 November 2022")
    }.stateIn(
        scope = viewModelScope,
        started = SharingStarted.WhileSubscribed(5_000),
        initialValue = ""
    )
}