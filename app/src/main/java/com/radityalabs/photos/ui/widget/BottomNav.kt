package com.radityalabs.photos.ui.widget

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import com.radityalabs.photos.R

@Composable
fun PhotoBottomNav(
    modifier: Modifier
) {
    Box(
        modifier = modifier
    ) {
        Row(
            modifier = modifier,
            horizontalArrangement = Arrangement.SpaceAround,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Image(
                painter = painterResource(id = R.drawable.ic_photo_library),
                contentDescription = "Library",
                modifier = Modifier.clickable {

                }
            )
            Image(
                painter = painterResource(id = R.drawable.ic_for_you),
                contentDescription = "For You",
                modifier = Modifier.clickable {

                }
            )
            Image(
                painter = painterResource(id = R.drawable.ic_album),
                contentDescription = "Albums",
                modifier = Modifier.clickable {

                }
            )
            Image(
                painter = painterResource(id = R.drawable.ic_search),
                contentDescription = "Search",
                modifier = Modifier.clickable {

                }
            )
        }
    }
}

@Preview
@Composable
fun PhotoBottomNavPreview() {
    PhotoBottomNav(
        modifier = Modifier.fillMaxWidth()
    )
}