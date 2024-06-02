package kr.toongether.archive.source

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import kr.toongether.designsystem.theme.ToongetherColors

@Composable
fun ArchiveScreen() {
    Box(modifier = Modifier
        .fillMaxSize()
        .background(ToongetherColors.BackgroundNormal))
}
