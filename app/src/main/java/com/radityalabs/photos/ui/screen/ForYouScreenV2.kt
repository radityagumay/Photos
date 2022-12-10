package com.radityalabs.photos.ui.screen


import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.google.accompanist.insets.ProvideWindowInsets
import com.google.accompanist.insets.ui.Scaffold
import com.radityalabs.photos.ui.theme.PhotoAppTheme
import com.radityalabs.photos.ui.widget.BottomNavV2Widget

@Composable
internal fun ForYouScreenV2() {
    Scaffold(
        bottomBar = {
            BottomNavV2Widget()
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

@Preview
@Composable
private fun ForYouScreenV2Preview() {
    PhotoAppTheme {
        ProvideWindowInsets {
            ForYouScreenV2()
        }
    }
}