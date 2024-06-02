package kr.toongether.main.navigation

import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.vector.ImageVector
import kr.toongether.designsystem.icon.ToongetherIcons

enum class NavigationDestination(
    val icon: (@Composable () -> ImageVector)? = null,
    val label: String,
) {
    SERIES(
        icon = { ToongetherIcons.Fill.Series },
        label = "웹툰"
    ),
    SHORTS(
        icon = { ToongetherIcons.Fill.Series },
        label = "숏툰"
    ),
    COMMUNITY(
        icon = { ToongetherIcons.Fill.Community },
        label = "커뮤니티"
    ),
    ARCHIVE(
        icon = { ToongetherIcons.Fill.Archive },
        label = "보관함"
    ),
    MY(label = "MY")
}
