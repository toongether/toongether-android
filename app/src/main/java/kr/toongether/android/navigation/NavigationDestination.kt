package kr.toongether.android.navigation

import androidx.annotation.StringRes
import androidx.compose.ui.graphics.vector.ImageVector
import kr.toongether.android.R
import kr.toongether.designsystem.icon.ToongetherIcons
import kr.toongether.designsystem.icon.icons.Home
import kr.toongether.designsystem.icon.icons.My
import kr.toongether.designsystem.icon.icons.Series
import kr.toongether.designsystem.icon.icons.Shorts

enum class NavigationDestination(
    val icon: ImageVector,
    @StringRes val iconTextId: Int
) {
    HOME(
        icon = ToongetherIcons.Home,
        iconTextId = R.string.home
    ),
    SERIES(
        icon = ToongetherIcons.Series,
        iconTextId = R.string.series
    ),
    SHORTS(
        icon = ToongetherIcons.Shorts,
        iconTextId = R.string.shorts
    ),
    MY(
        icon = ToongetherIcons.My,
        iconTextId = R.string.my
    )
}
