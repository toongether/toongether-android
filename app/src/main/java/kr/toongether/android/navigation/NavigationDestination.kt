package kr.toongether.android.navigation

import androidx.annotation.StringRes
import androidx.compose.ui.graphics.vector.ImageVector
import kr.toongether.android.R
import kr.toongether.designsystem.icon.ToongetherIcons
import kr.toongether.designsystem.icon.icons.Community
import kr.toongether.designsystem.icon.icons.Home
import kr.toongether.designsystem.icon.icons.My
import kr.toongether.designsystem.icon.icons.Series
import kr.toongether.designsystem.icon.icons.Shorts

enum class NavigationDestination(
    val icon: ImageVector,
    @StringRes val iconTextId: Int,
    @StringRes val titleTextId: Int?,
) {
    HOME(
        icon = ToongetherIcons.Home,
        iconTextId = R.string.home,
        titleTextId = null
    ),
    SERIES(
        icon = ToongetherIcons.Series,
        iconTextId = R.string.series,
        titleTextId = R.string.title_series
    ),
    SHORTS(
        icon = ToongetherIcons.Shorts,
        iconTextId = R.string.shorts,
        titleTextId = R.string.title_shorts
    ),
    COMMUNITY(
        icon = ToongetherIcons.Community,
        iconTextId = R.string.community,
        titleTextId = R.string.community
    ),
    MY(
        icon = ToongetherIcons.My,
        iconTextId = R.string.my,
        titleTextId = R.string.title_my
    )
}
