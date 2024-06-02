package kr.toongether.episode.demo

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.SystemBarStyle
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.safeDrawingPadding
import androidx.compose.ui.Modifier
import dagger.hilt.android.AndroidEntryPoint
import kr.toongether.designsystem.theme.ToongetherColors
import kr.toongether.designsystem.theme.ToongetherTheme
import kr.toongether.main.MainScreen

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge(
            statusBarStyle = SystemBarStyle.dark(
                android.graphics.Color.TRANSPARENT,
            ),
            navigationBarStyle = SystemBarStyle.dark(
                android.graphics.Color.TRANSPARENT,
            )
        )
        setContent {
            MainScreen(
                modifier = Modifier
                    .background(ToongetherColors.BackgroundNormal)
                    .safeDrawingPadding(),
                navigateToEpisode = { _, _, _ -> }, navigateToLogin = { }
            )
        }
    }
}
