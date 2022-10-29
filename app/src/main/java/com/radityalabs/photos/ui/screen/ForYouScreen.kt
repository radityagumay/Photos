package com.radityalabs.photos.ui.screen

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.Immutable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.semantics.semantics
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.SubcomposeAsyncImage
import coil.request.ImageRequest.Builder

@Immutable
data class HorizontalImageDto(
    val title: String,
    val isSeeAllEnabled: Boolean
)

@Composable
fun HeaderScreen(
    modifier: Modifier
) {
    val items = listOf(
        HorizontalImageDto(
            title = "Memories", isSeeAllEnabled = true
        ),
        HorizontalImageDto(
            title = "Featured Photos", isSeeAllEnabled = false
        )
    )

    Column(
        modifier = modifier
    ) {
        HeaderWidget()
        LazyColumn {
            itemsIndexed(items = items) { _: Int, item: HorizontalImageDto ->
                HorizontalImageWidget(title = item.title, isSeeAllEnabled = item.isSeeAllEnabled)
            }
        }
    }
}

@Composable
private fun HeaderWidget() {
    Text(
        modifier = Modifier
            .fillMaxWidth()
            .padding(start = 16.dp, top = 16.dp, bottom = 6.dp),
        text = "For You", fontSize = 32.sp
    )
}

@Composable
fun HorizontalImageWidget(
    title: String,
    isSeeAllEnabled: Boolean
) {
    Column(modifier = Modifier.fillMaxSize()) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(start = 16.dp, top = 16.dp, end = 16.dp),
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Text(text = title, fontSize = 20.sp)
            if (isSeeAllEnabled) {
                Text(text = "See All", fontSize = 20.sp, color = Color.Blue)
            }
        }
        Spacer(modifier = Modifier.size(8.dp))
        LazyRow(
            modifier = Modifier.semantics(mergeDescendants = true) {},
            horizontalArrangement = Arrangement.spacedBy(10.dp),
            contentPadding = PaddingValues(start = 16.dp, top = 8.dp, end = 16.dp, bottom = 16.dp)
        ) {
            items(5) {
                Card(
                    modifier = Modifier
                        .size(width = 320.dp, height = 480.dp),
                    shape = RoundedCornerShape(10.dp),
                ) {
                    SubcomposeAsyncImage(
                        model = Builder(LocalContext.current)
                            .data("https://cdn.britannica.com/47/188747-050-1D34E743/Bill-Gates-2011.jpg")
                            .crossfade(true)
                            .build(),
                        contentScale = ContentScale.Crop,
                        loading = {
                            CircularProgressIndicator(
                                modifier = Modifier
                                    .size(30.dp)
                            )
                        },
                        contentDescription = null
                    )
                }
            }
        }
    }
}

@Preview
@Composable
fun HeaderScreenPreview() {
    HeaderScreen(modifier = Modifier.fillMaxWidth())
}
