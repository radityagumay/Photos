package com.radityalabs.photos

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.SideEffect
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.core.view.WindowCompat
import com.google.accompanist.insets.LocalWindowInsets
import com.google.accompanist.insets.ProvideWindowInsets
import com.google.accompanist.insets.rememberInsetsPaddingValues
import com.google.accompanist.systemuicontroller.rememberSystemUiController
import com.radityalabs.photos.ui.screen.LibraryScreen
import com.radityalabs.photos.ui.theme.PhotoAppTheme
import com.radityalabs.photos.ui.widget.BottomNavigation

class MainActivity : ComponentActivity() {
    @OptIn(ExperimentalMaterial3Api::class)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // Turn off the decor fitting system windows, which means we need to through handling
        WindowCompat.setDecorFitsSystemWindows(window, false)

        setContent {
            // Update the system bars to be translucent
            val systemUiController = rememberSystemUiController()
            SideEffect {
                systemUiController.setSystemBarsColor(Color.Transparent, darkIcons = false)
            }

            PhotoAppTheme {
                ProvideWindowInsets {
                    Scaffold(
                        modifier = Modifier
                            .fillMaxSize(),
                        content = {
                            LibraryScreen(modifier = Modifier)
                            //ForYouScreen(modifier = Modifier.fillMaxWidth())
                        }, bottomBar = {
                            BottomNavigation(
                                //modifier = Modifier,
                                //contentPadding = rememberInsetsPaddingValues(LocalWindowInsets.current.navigationBars),
                            )
                        })
                }
                /*Column(modifier = Modifier.fillMaxSize()) {
                    val appBarColor = MaterialTheme.colorScheme.surface.copy(alpha = 0.87f)

                    // Draw a scrim over the status bar which matches the app bar
                    Spacer(
                        Modifier
                            .background(appBarColor)
                            .fillMaxWidth()
                            .windowInsetsTopHeight(WindowInsets.statusBars)
                    )

                    Scaffold(
                        modifier = Modifier.fillMaxSize(),
                        content = {
                            LibraryScreen(modifier = Modifier)
                            //ForYouScreen(modifier = Modifier.fillMaxWidth())
                        }, bottomBar = {
                            PhotoBottomNav(
                                modifier = Modifier
                                    .fillMaxWidth()
                                    .background(color = Color.Black.copy(alpha = 0.2f))
                                    .size(50.dp)
                            )
                        })
                }
            }*/
            }
        }
    }
}