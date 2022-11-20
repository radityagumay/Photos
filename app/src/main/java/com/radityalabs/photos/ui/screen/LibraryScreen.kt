package com.radityalabs.photos.ui.screen

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
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.SubcomposeAsyncImage
import coil.request.ImageRequest.Builder

@Composable
fun LibraryScreen(
    modifier: Modifier,
    contentPadding: PaddingValues = PaddingValues(0.dp),
) {
    Box(
        modifier = modifier.fillMaxSize()
    ) {
        val list = (1..50).map { it.toString() }
        LazyVerticalGrid(
            contentPadding = contentPadding,
            modifier = modifier.background(Color.White),
            columns = GridCells.Fixed(3),
            content = {
                items(list.size) { index ->
                    Box(
                        modifier = modifier.padding(1.dp)
                    ) {
                        SubcomposeAsyncImage(
                            modifier = modifier
                                .fillMaxWidth()
                                .size(120.dp),
                            model = Builder(LocalContext.current)
                                .data("https://cdn.britannica.com/47/188747-050-1D34E743/Bill-Gates-2011.jpg")
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

        // a gradient background for the header
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

        // a date section
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
                Text(text = "17 Apr 2022", color = Color.White, fontSize = 20.sp)

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

            Text(
                text = "Catur tunggal", color = Color.White, fontSize = 14.sp,
                modifier = modifier
            )
        }
    }
}

@Preview
@Composable
fun LibraryScreenPreview() {
    LibraryScreen(
        modifier = Modifier.fillMaxSize()
    )
}