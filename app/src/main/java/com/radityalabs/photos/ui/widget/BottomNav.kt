package com.radityalabs.photos.ui.widget

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.padding
import androidx.compose.material.BottomNavigationDefaults
import androidx.compose.material.BottomNavigationItem
import androidx.compose.material.MaterialTheme
import androidx.compose.material.contentColorFor
import androidx.compose.material.primarySurface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import com.google.accompanist.insets.ui.BottomNavigationContent
import com.google.accompanist.insets.ui.BottomNavigationSurface
import com.radityalabs.photos.R

@Composable
fun BottomNavigation(
    modifier: Modifier = Modifier,
    contentPadding: PaddingValues = PaddingValues(0.dp),
    backgroundColor: Color = MaterialTheme.colors.primarySurface,
    contentColor: Color = contentColorFor(backgroundColor),
    elevation: Dp = BottomNavigationDefaults.Elevation
) {
    var selected by remember { mutableStateOf(0) }

    BottomNavigationSurface(
        modifier,
        backgroundColor,
        contentColor,
        elevation
    ) {
        BottomNavigationContent(Modifier.padding(contentPadding)) {
            BottomNavigationItem(
                selected = selected == 0,
                onClick = { selected = 0 },
                icon = {
                    Image(
                        painter = painterResource(id = R.drawable.ic_photo_library),
                        contentDescription = "Library",
                    )
                }
            )

            BottomNavigationItem(
                selected = selected == 1,
                onClick = { selected = 1 },
                icon = {
                    Image(
                        painter = painterResource(id = R.drawable.ic_for_you),
                        contentDescription = "For You",
                    )
                }
            )

            BottomNavigationItem(
                selected = selected == 2,
                onClick = { selected = 2 },
                icon = {
                    Image(
                        painter = painterResource(id = R.drawable.ic_album),
                        contentDescription = "Albums",
                    )
                }
            )

            BottomNavigationItem(
                selected = selected == 3,
                onClick = { selected = 3 },
                icon = {
                    Image(
                        painter = painterResource(id = R.drawable.ic_search),
                        contentDescription = "Search",
                    )
                }
            )
        }
    }
}
