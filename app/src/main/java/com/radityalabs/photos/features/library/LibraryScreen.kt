package com.radityalabs.photos.features.library

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.ExperimentalLifecycleComposeApi
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import coil.compose.SubcomposeAsyncImage
import coil.request.ImageRequest.Builder
import com.radityalabs.photos.features.library.LibraryUiState.Loading
import com.radityalabs.photos.features.library.LibraryUiState.Success

@ExperimentalLifecycleComposeApi
@Composable
internal fun LibraryScreenRoute(
    modifier: Modifier = Modifier,
    contentPadding: PaddingValues = PaddingValues(0.dp),
    vm: LibraryViewModel = hiltViewModel()
) {
    val addressWherePictureTook by vm.addressWherePictureTook.collectAsStateWithLifecycle()
    val dateWherePictureTook by vm.dateWherePictureTook.collectAsStateWithLifecycle()
    val state by vm.images.collectAsStateWithLifecycle()

    LibraryScreen(
        modifier = modifier,
        contentPadding = contentPadding,
        addressWherePictureTook = addressWherePictureTook,
        dateWherePictureTook = dateWherePictureTook,
        state = state
    )
}

@Composable
private fun LibraryScreen(
    modifier: Modifier,
    contentPadding: PaddingValues = PaddingValues(0.dp),
    addressWherePictureTook: String,
    dateWherePictureTook: String,
    state: LibraryUiState
) {
    when (state) {
        is Loading -> Text(text = "Loading...")
        is Success -> {
            Box(
                modifier = modifier.fillMaxSize()
            ) {
                // Images
                LazyVerticalGrid(
                    contentPadding = contentPadding,
                    modifier = modifier.background(Color.White),
                    columns = GridCells.Fixed(3),
                    content = {
                        items(
                            count = state.images.size,
                            key = { it }
                        ) { index ->
                            Box(
                                modifier = modifier.padding(1.dp)
                            ) {
                                SubcomposeAsyncImage(
                                    modifier = modifier
                                        .fillMaxWidth()
                                        .size(120.dp),
                                    model = Builder(LocalContext.current)
                                        .data(state.images[index])
                                        .crossfade(true)
                                        .build(),
                                    contentScale = ContentScale.Crop,
                                    loading = {
                                        CircularProgressIndicator(
                                            modifier = modifier.size(30.dp)
                                        )
                                    },
                                    contentDescription = null
                                )
                            }
                        }
                    }
                )

                // A gradient background for the header
                Box(
                    modifier = modifier
                        .fillMaxWidth()
                        .size(200.dp)
                        .background(
                            alpha = 0.5f,
                            brush = Brush.verticalGradient(
                                colors = listOf(Color.Black, Color.Transparent),
                                startY = 0f,
                                endY = 400f
                            )
                        )
                )

                // A date section
                Column(
                    modifier = modifier
                        .fillMaxWidth()
                        .padding(start = 8.dp, end = 8.dp)
                ) {

                    Spacer(modifier = modifier.size(36.dp))

                    Row(
                        modifier = modifier.fillMaxWidth(),
                        horizontalArrangement = Arrangement.Start,
                    ) {
                        Text(text = dateWherePictureTook, color = Color.White, fontSize = 20.sp)

                        Row(
                            modifier = modifier.fillMaxWidth(),
                            horizontalArrangement = Arrangement.End,
                        ) {
                            Card(
                                shape = MaterialTheme.shapes.small,
                                modifier = modifier.wrapContentWidth(),
                                colors = CardDefaults.cardColors(
                                    containerColor = Color.Black
                                )
                            ) {
                                Text(
                                    text = "Select",
                                    modifier = modifier.padding(
                                        start = 8.dp,
                                        top = 4.dp,
                                        end = 8.dp,
                                        bottom = 4.dp
                                    ),
                                    fontSize = 10.sp,
                                    color = Color.White
                                )
                            }
                            Spacer(modifier = modifier.size(16.dp))
                            Card(
                                modifier = modifier,
                                colors = CardDefaults.cardColors(
                                    containerColor = Color.Black
                                )
                            ) {
                                Text(
                                    text = "...", modifier = modifier.padding(4.dp),
                                    fontSize = 10.sp,
                                    color = Color.White
                                )
                            }
                        }
                    }

                    Spacer(modifier = modifier.size(4.dp))

                    Text(
                        text = addressWherePictureTook, color = Color.White, fontSize = 14.sp,
                        modifier = modifier
                    )
                }
            }
        }
    }
}

@Preview
@Composable
fun LibraryScreenPreview() {
    LibraryScreen(
        modifier = Modifier.fillMaxSize(),
        contentPadding = PaddingValues(0.dp),
        addressWherePictureTook = "Jakarta",
        dateWherePictureTook = "10 November 2022",
        state = LibraryUiState.Success(listOf("https://picsum.photos/id/0/200/300"))
    )
}