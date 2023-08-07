package kr.toongether.android

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.core.view.WindowCompat
import kr.toongether.android.ui.ToongetherApp
import kr.toongether.designsystem.theme.ToongetherTheme

class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        WindowCompat.setDecorFitsSystemWindows(window, false)

        super.onCreate(savedInstanceState)
        setContent {
            ToongetherTheme {
                ToongetherApp()
            }
        }
    }
}
