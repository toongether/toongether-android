package kr.toongether.android

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.SystemBarStyle
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.core.view.WindowCompat
import dagger.hilt.android.AndroidEntryPoint
import kr.toongether.android.ui.ToongetherApp
import kr.toongether.designsystem.theme.ToongetherTheme

@AndroidEntryPoint
class MainActivity : ComponentActivity() {

    @ExperimentalMaterialApi
    @ExperimentalMaterial3Api
    @ExperimentalFoundationApi
    override fun onCreate(savedInstanceState: Bundle?) {
        enableEdgeToEdge(
            statusBarStyle = SystemBarStyle.dark(
                android.graphics.Color.TRANSPARENT,
            ),
            navigationBarStyle = SystemBarStyle.dark(
                android.graphics.Color.TRANSPARENT,
            )
        )
        
        super.onCreate(savedInstanceState)
        setContent {
            ToongetherTheme {
                ToongetherApp()
            }
        }
    }
}
