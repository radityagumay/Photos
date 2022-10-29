package com.radityalabs.photos

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.AsyncImage
import coil.request.ImageRequest

class MainActivity : ComponentActivity() {
    @OptIn(ExperimentalMaterial3Api::class)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            HeaderScreen()
        }
    }
}

@Composable
fun HeaderScreen() {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.White)
    ) {
        HeaderWidget()
        LazyColumn {
            items(2) {
                HorizontalImageWidget()
            }
        }
    }
}

@Composable
private fun HeaderWidget() {
    Text(
        modifier = Modifier
            .fillMaxWidth()
            .padding(start = 16.dp, top = 16.dp),
        text = "For You", fontSize = 32.sp
    )
}

@Composable
fun HorizontalImageWidget() {
    Column(modifier = Modifier.fillMaxSize()) {
        Spacer(modifier = Modifier.size(16.dp))
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(start = 16.dp, top = 16.dp, end = 16.dp),
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Text(text = "Memories", fontSize = 20.sp)
            Text(text = "See All", fontSize = 20.sp, color = Color.Blue)
        }
        Spacer(modifier = Modifier.size(8.dp))
        LazyRow(
            modifier = Modifier
                .fillMaxHeight(),
            horizontalArrangement = Arrangement.spacedBy(10.dp)
        ) {
            items(5) {
                Card(
                    modifier = Modifier.size(width = 320.dp, height = 480.dp),
                    shape = RoundedCornerShape(10.dp)
                ) {
                    AsyncImage(
                        model = ImageRequest.Builder(LocalContext.current)
                            .data("https://cdn.britannica.com/47/188747-050-1D34E743/Bill-Gates-2011.jpg")
                            .crossfade(true)
                            .build(),
                        contentScale = ContentScale.Crop,
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
    HeaderScreen()
}
