package kr.toongether.designsystem.icon

import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.vectorResource
import kr.toongether.designsystem.R

object ToongetherIcons {
    object Bold {
        val MagnifyingGlass @Composable get() = ImageVector.vectorResource(id = R.drawable.ic_magnifying_glass)
        val List @Composable get() = ImageVector.vectorResource(id = R.drawable.ic_list)
        val Heart @Composable get() = ImageVector.vectorResource(id = R.drawable.ic_heart_bold)
        val DotsThree @Composable get() = ImageVector.vectorResource(id = R.drawable.ic_dots_three)
        val ArrowLeft @Composable get() = ImageVector.vectorResource(id = R.drawable.ic_arrow_left)
    }

    object Fill {
        val Archive @Composable get() = ImageVector.vectorResource(id = R.drawable.ic_archive)
        val Community @Composable get() = ImageVector.vectorResource(id = R.drawable.ic_community)
        val Series @Composable get() = ImageVector.vectorResource(id = R.drawable.ic_series)
        val Shorts @Composable get() = ImageVector.vectorResource(id = R.drawable.ic_shorts)
        val ThumbsUp @Composable get() = ImageVector.vectorResource(id = R.drawable.ic_thumbs_up)
        val ChatDots @Composable get() = ImageVector.vectorResource(id = R.drawable.ic_chat_dots)
        val CaretCircleLeft @Composable get() = ImageVector.vectorResource(id = R.drawable.ic_caret_circle_left)
        val CaretCircleRight @Composable get() = ImageVector.vectorResource(id = R.drawable.ic_caret_circle_right)
        val XCircle @Composable get() = ImageVector.vectorResource(id = R.drawable.ic_x_circle)
    }
}
