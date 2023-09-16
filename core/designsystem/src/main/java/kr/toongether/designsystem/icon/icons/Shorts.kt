package kr.toongether.designsystem.icon.icons

import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.PathFillType
import androidx.compose.ui.graphics.PathFillType.Companion.EvenOdd
import androidx.compose.ui.graphics.SolidColor
import androidx.compose.ui.graphics.StrokeCap
import androidx.compose.ui.graphics.StrokeCap.Companion.Butt
import androidx.compose.ui.graphics.StrokeJoin
import androidx.compose.ui.graphics.StrokeJoin.Companion.Miter
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.graphics.vector.ImageVector.Builder
import androidx.compose.ui.graphics.vector.group
import androidx.compose.ui.graphics.vector.path
import androidx.compose.ui.unit.dp
import kr.toongether.designsystem.icon.ToongetherIcons

public val ToongetherIcons.Shorts: ImageVector
    get() {
        if (_shorts != null) {
            return _shorts!!
        }
        _shorts = Builder(
            name = "단편1 1",
            defaultWidth = 24.0.dp,
            defaultHeight = 24.0.dp,
            viewportWidth = 24.0f,
            viewportHeight = 24.0f
        ).apply {
            group {
                path(
                    fill = SolidColor(Color(0xFF737373)),
                    fillAlpha = 1.0f,
                    stroke = null,
                    strokeAlpha = 1.0f,
                    strokeLineWidth = 1.0f,
                    strokeLineCap = Butt,
                    strokeLineJoin = Miter,
                    strokeLineMiter = 1.0f,
                    pathFillType = EvenOdd
                ) {
                    moveTo(3f, 5.10938f)
                    curveTo(3f, 3.9444f, 3.9444f, 3f, 5.1094f, 3f)
                    verticalLineTo(21f)
                    curveTo(3.9444f, 21f, 3f, 20.0556f, 3f, 18.8906f)
                    verticalLineTo(5.10938f)
                    close()
                    moveTo(6.23438f, 21f)
                    verticalLineTo(3f)
                    horizontalLineTo(18.8906f)
                    curveTo(20.0556f, 3f, 21f, 3.9444f, 21f, 5.1094f)
                    verticalLineTo(18.8906f)
                    curveTo(21f, 20.0556f, 20.0556f, 21f, 18.8906f, 21f)
                    horizontalLineTo(6.23438f)
                    close()
                    moveTo(13.6172f, 9.15488f)
                    curveTo(14.0374f, 8.5932f, 14.7113f, 8.2272f, 15.4643f, 8.2272f)
                    curveTo(16.7415f, 8.2272f, 17.7773f, 9.2672f, 17.7773f, 10.5527f)
                    curveTo(17.7773f, 11.0477f, 17.6983f, 11.5054f, 17.561f, 11.9297f)
                    curveTo(16.9037f, 14.0098f, 14.8777f, 15.2537f, 13.8751f, 15.5948f)
                    curveTo(13.7337f, 15.6447f, 13.5007f, 15.6447f, 13.3593f, 15.5948f)
                    curveTo(12.3567f, 15.2537f, 10.3307f, 14.0098f, 9.6734f, 11.9297f)
                    curveTo(9.5361f, 11.5054f, 9.457f, 11.0477f, 9.457f, 10.5527f)
                    curveTo(9.457f, 9.2672f, 10.4929f, 8.2272f, 11.7701f, 8.2272f)
                    curveTo(12.5231f, 8.2272f, 13.197f, 8.5932f, 13.6172f, 9.1549f)
                    close()
                }
            }
        }
            .build()
        return _shorts!!
    }

private var _shorts: ImageVector? = null
