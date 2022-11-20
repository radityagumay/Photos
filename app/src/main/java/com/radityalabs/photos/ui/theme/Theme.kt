package com.radityalabs.photos.ui.theme

import JetcasterTypography
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable

@Composable
fun PhotoAppTheme(
    content: @Composable () -> Unit
) {
    MaterialTheme(
        colorScheme = JetcasterColors,
        typography = JetcasterTypography,
        shapes = JetcasterShapes,
        content = content
    )
}
