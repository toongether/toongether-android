package kr.toongether.main.navigation

import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.vector.ImageVector
import kr.toongether.designsystem.icon.ToongetherIcons

enum class NavigationDestination(
    val icon: @Composable () -> ImageVector,
    val label: String,
) {
    SERIES(
        icon = { ToongetherIcons.Series },
        label = "웹툰"
    ),
    SHORTS(
        icon = { ToongetherIcons.Series },
        label = "숏툰"
    ),
    COMMUNITY(
        icon = { ToongetherIcons.Community },
        label = "커뮤니티"
    ),
    ARCHIVE(
        icon = { ToongetherIcons.Archive },
        label = "보관함"
    )
}
