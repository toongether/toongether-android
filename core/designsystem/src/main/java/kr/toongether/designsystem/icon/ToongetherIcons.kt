package kr.toongether.designsystem.icon

import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.vectorResource
import kr.toongether.designsystem.R

object ToongetherIcons {
    val Archive @Composable get() = ImageVector.vectorResource(id = R.drawable.ic_archive)
    val Community @Composable get() = ImageVector.vectorResource(id = R.drawable.ic_community)
    val Series @Composable get() = ImageVector.vectorResource(id = R.drawable.ic_series)
    val Shorts @Composable get() = ImageVector.vectorResource(id = R.drawable.ic_shorts)
    val MagnifyingGlass @Composable get() = ImageVector.vectorResource(id = R.drawable.ic_magnifying_glass)
    val List @Composable get() = ImageVector.vectorResource(id = R.drawable.ic_list)
    val ThumbsUp @Composable get() = ImageVector.vectorResource(id = R.drawable.ic_thumbs_up)
    val ChatDots @Composable get() = ImageVector.vectorResource(id = R.drawable.ic_chat_dots)
    val CaretCircleLeft @Composable get() = ImageVector.vectorResource(id = R.drawable.ic_caret_circle_left)
    val CaretCircleRight @Composable get() = ImageVector.vectorResource(id = R.drawable.ic_caret_circle_right)
}
