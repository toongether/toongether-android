package kr.toongether.designsystem.icon.icons

import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.PathFillType.Companion.NonZero
import androidx.compose.ui.graphics.SolidColor
import androidx.compose.ui.graphics.StrokeCap.Companion.Butt
import androidx.compose.ui.graphics.StrokeJoin.Companion.Miter
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.graphics.vector.ImageVector.Builder
import androidx.compose.ui.graphics.vector.group
import androidx.compose.ui.graphics.vector.path
import androidx.compose.ui.unit.dp
import kr.toongether.designsystem.icon.ToongetherIcons

val ToongetherIcons.Back: ImageVector
    get() {
        if (_back != null) {
            return _back!!
        }
        _back = Builder(
            name = "Back",
            defaultWidth = 20.0.dp,
            defaultHeight = 20.0.dp,
            viewportWidth = 20.0f,
            viewportHeight = 20.0f
        ).apply {
            group {
                path(
                    fill = SolidColor(Color(0xFFffffff)),
                    stroke = null,
                    strokeLineWidth = 0.0f,
                    strokeLineCap = Butt,
                    strokeLineJoin = Miter,
                    strokeLineMiter = 4.0f,
                    pathFillType = NonZero
                ) {
                    moveTo(4.0f, 9.4946f)
                    curveTo(4.0f, 9.8574f, 4.1304f, 10.1648f, 4.4234f, 10.4517f)
                    lineTo(12.8546f, 18.63f)
                    curveTo(13.091f, 18.8733f, 13.3853f, 18.9912f, 13.7346f, 18.9912f)
                    curveTo(14.4409f, 18.9912f, 15.0f, 18.4473f, 15.0f, 17.7524f)
                    curveTo(15.0f, 17.4021f, 14.8499f, 17.0946f, 14.6107f, 16.8524f)
                    lineTo(7.007f, 9.4927f)
                    lineTo(14.6107f, 2.1368f)
                    curveTo(14.8519f, 1.8927f, 15.0f, 1.5784f, 15.0f, 1.2388f)
                    curveTo(15.0f, 0.5419f, 14.4409f, 0.0f, 13.7346f, 0.0f)
                    curveTo(13.3834f, 0.0f, 13.091f, 0.1178f, 12.8546f, 0.3523f)
                    lineTo(4.4234f, 8.5375f)
                    curveTo(4.1324f, 8.8156f, 4.0019f, 9.1299f, 4.0f, 9.4946f)
                    close()
                }
            }
        }
            .build()
        return _back!!
    }

private var _back: ImageVector? = null
