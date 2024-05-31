package com.hanix.compose.composelayout

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.windowsizeclass.ExperimentalMaterial3WindowSizeClassApi
import androidx.compose.material3.windowsizeclass.WindowSizeClass
import androidx.compose.material3.windowsizeclass.WindowWidthSizeClass
import androidx.compose.material3.windowsizeclass.calculateWindowSizeClass
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.hanix.compose.composelayout.main_ui.AppNavigationRail
import com.hanix.compose.composelayout.main_ui.BottomNavigation
import com.hanix.compose.composelayout.main_ui.HomeScreen
import com.hanix.compose.composelayout.ui.theme.ComposeLayoutTheme

class MainActivity : ComponentActivity() {
    @OptIn(ExperimentalMaterial3WindowSizeClassApi::class)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            ComposeLayoutTheme {
                MySootheApp(calculateWindowSizeClass(this))
            }
        }
    }

}


@Composable
fun MySootheAppPortrait() {
    ComposeLayoutTheme {
        Scaffold(
            bottomBar = { BottomNavigation() }
        ) { padding ->
            HomeScreen(Modifier.padding(padding))
        }
    }
}

@Preview(widthDp = 360, heightDp = 640)
@Composable
fun MySoothePortraitPreview() {
    MySootheAppPortrait()
}

@Composable
fun MySootheAppLandscape() {
    ComposeLayoutTheme {
        Surface(color = MaterialTheme.colorScheme.background) {
            Row {
                AppNavigationRail()
                HomeScreen()
            }
        }
    }
}


@Preview(widthDp = 640, heightDp = 360)
@Composable
fun MySootheLandscapePreview() {
    MySootheAppLandscape()
}

@Composable
fun MySootheApp(windowSize: WindowSizeClass) {
    when (windowSize.widthSizeClass) {
        WindowWidthSizeClass.Compact -> {
            MySootheAppPortrait()
        }

        WindowWidthSizeClass.Expanded -> {
            MySootheAppLandscape()
        }
    }
}

