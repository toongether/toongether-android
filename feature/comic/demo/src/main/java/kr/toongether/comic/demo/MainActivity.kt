package kr.toongether.comic.demo

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.SystemBarStyle
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import dagger.hilt.android.AndroidEntryPoint
import kr.toongether.comic.ComicScreen
import kr.toongether.designsystem.theme.ToongetherTheme

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        enableEdgeToEdge(
            statusBarStyle = SystemBarStyle.auto(
                android.graphics.Color.TRANSPARENT,
                android.graphics.Color.TRANSPARENT,
            ),
            navigationBarStyle = SystemBarStyle.auto(
                android.graphics.Color.TRANSPARENT,
                android.graphics.Color.TRANSPARENT,
            )
        )
        setContent {
            ToongetherTheme {
                ComicScreen(
                    episodeNumber = 87,
                    seriesId = -1,
                    navigateToLogin = { /*TODO*/ },
                    navigateToComic = {},
                    popBackStack = { /*TODO*/ }) {
                    
                }
            }
        }
    }
}
