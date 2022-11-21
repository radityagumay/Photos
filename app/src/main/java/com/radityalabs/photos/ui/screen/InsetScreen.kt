package com.radityalabs.photos.ui.screen


import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.BottomNavigationItem
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.material.darkColors
import androidx.compose.material.lightColors
import androidx.compose.runtime.Composable
import androidx.compose.runtime.SideEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.core.view.WindowCompat
import coil.compose.rememberImagePainter
import com.google.accompanist.insets.LocalWindowInsets
import com.google.accompanist.insets.ProvideWindowInsets
import com.google.accompanist.insets.rememberInsetsPaddingValues
import com.google.accompanist.insets.ui.BottomNavigation
import com.google.accompanist.insets.ui.Scaffold
import com.google.accompanist.systemuicontroller.rememberSystemUiController
import com.radityalabs.photos.R.drawable
import com.radityalabs.photos.ui.theme.PhotoAppTheme

@Composable
fun AccompanistSampleTheme(
    darkTheme: Boolean = isSystemInDarkTheme(),
    content: @Composable () -> Unit
) {
    MaterialTheme(
        colors = if (darkTheme) darkColors() else lightColors(),
        content = content
    )
}

class EdgeToEdgeLazyColumnWithBottomNav : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // Turn off the decor fitting system windows, which means we need to through handling
        // insets
        WindowCompat.setDecorFitsSystemWindows(window, false)

        setContent {
            // Update the system bars to be translucent
            val systemUiController = rememberSystemUiController()

            SideEffect {
                systemUiController.setSystemBarsColor(Color.Transparent, darkIcons = false)
            }

            PhotoAppTheme {
                ProvideWindowInsets {
                    Sample()
                }
            }
        }
    }
}

@Composable
private fun Sample() {
    Scaffold(
        bottomBar = {
            var selected by remember { mutableStateOf(0) }

            BottomNavigation(
                backgroundColor = MaterialTheme.colors
                    .onBackground.copy(alpha = 0.5f),
                contentPadding = rememberInsetsPaddingValues(
                    LocalWindowInsets.current.navigationBars
                )
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
    ) { contentPadding ->
        Box {
            // We apply the contentPadding passed to us from the Scaffold
            LibraryScreen(
                contentPadding = contentPadding,
                modifier = Modifier.wrapContentSize()
            )
        }
    }
}

@Composable
fun ListItem(
    imageUrl: String,
    modifier: Modifier = Modifier
) {
    Row(modifier.padding(horizontal = 16.dp, vertical = 8.dp)) {
        Image(
            painter = rememberImagePainter(imageUrl),
            contentDescription = null,
            modifier = Modifier
                .size(64.dp)
                .clip(RoundedCornerShape(4.dp)),
        )

        Spacer(Modifier.width(16.dp))

        Text(
            text = "Text",
            style = MaterialTheme.typography.subtitle2,
            modifier = Modifier
                .weight(1f)
                .align(Alignment.CenterVertically)
        )
    }
}


private val listItems = List(40) { randomSampleImageUrl(it) }
private val rangeForRandom = (0..100000)

fun randomSampleImageUrl(
    seed: Int = rangeForRandom.random(),
    width: Int = 300,
    height: Int = width,
): String {
    return "https://picsum.photos/seed/$seed/$width/$height"
}

/**
 * Remember a URL generate by [randomSampleImageUrl].
 */
@Composable
fun rememberRandomSampleImageUrl(
    seed: Int = rangeForRandom.random(),
    width: Int = 300,
    height: Int = width,
): String = remember { randomSampleImageUrl(seed, width, height) }