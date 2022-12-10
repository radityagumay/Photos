package com.radityalabs.photos.ui.widget

import androidx.compose.foundation.Image
import androidx.compose.material.BottomNavigationItem
import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import com.google.accompanist.insets.LocalWindowInsets
import com.google.accompanist.insets.rememberInsetsPaddingValues
import com.google.accompanist.insets.ui.BottomNavigation
import com.radityalabs.photos.R.drawable

@Preview
@Composable
internal fun BottomNavV2WidgetPreview() {
    BottomNavV2Widget()
}

@Composable
internal fun BottomNavV2Widget() {
    var selected by remember { mutableStateOf(0) }

    BottomNavigation(
        backgroundColor = MaterialTheme.colors.onBackground.copy(alpha = 0.5f),
        contentPadding = rememberInsetsPaddingValues(
            LocalWindowInsets.current.navigationBars
        ),
    ) {
        BottomNavigationItem(
            selected = selected == 0,
            onClick = { selected = 0 },
            icon = {
                Image(
                    painter = painterResource(id = drawable.ic_photo_library),
                    contentDescription = "Library",
                )
            }
        )
        BottomNavigationItem(
            selected = selected == 1,
            onClick = { selected = 1 },
            icon = {
                Image(
                    painter = painterResource(id = drawable.ic_for_you),
                    contentDescription = "For You",
                )
            }
        )
        BottomNavigationItem(
            selected = selected == 2,
            onClick = { selected = 2 },
            icon = {
                Image(
                    painter = painterResource(id = drawable.ic_album),
                    contentDescription = "Albums",
                )
            }
        )
        BottomNavigationItem(
            selected = selected == 3,
            onClick = { selected = 3 },
            icon = {
                Image(
                    painter = painterResource(id = drawable.ic_search),
                    contentDescription = "Search",
                )
            }
        )
    }
}