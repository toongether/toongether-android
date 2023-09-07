package kr.toongether.designsystem.icon.icons

import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.PathFillType.Companion.EvenOdd
import androidx.compose.ui.graphics.SolidColor
import androidx.compose.ui.graphics.StrokeCap.Companion.Butt
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
        _shorts = Builder(name = "단편1 1", defaultWidth = 24.0.dp, defaultHeight = 24.0.dp,
            viewportWidth = 24.0f, viewportHeight = 24.0f).apply {
            group {
                path(fill = SolidColor(Color(0xFF737373)), stroke = null, strokeLineWidth = 0.0f,
                    strokeLineCap = Butt, strokeLineJoin = Miter, strokeLineMiter = 4.0f,
                    pathFillType = EvenOdd) {
                    moveTo(2.8572f, 5.0003f)
                    curveTo(2.8572f, 3.8168f, 3.8165f, 2.8574f, 5.0f, 2.8574f)
                    verticalLineTo(21.1431f)
                    curveTo(3.8165f, 21.1431f, 2.8572f, 20.1837f, 2.8572f, 19.0003f)
                    verticalLineTo(5.0003f)
                    close()
                    moveTo(6.1429f, 21.1431f)
                    verticalLineTo(2.8574f)
                    horizontalLineTo(19.0f)
                    curveTo(20.1834f, 2.8574f, 21.1429f, 3.8168f, 21.1429f, 5.0003f)
                    verticalLineTo(19.0003f)
                    curveTo(21.1429f, 20.1837f, 20.1834f, 21.1431f, 19.0f, 21.1431f)
                    horizontalLineTo(6.1429f)
                    close()
                    moveTo(13.9629f, 8.1774f)
                    horizontalLineTo(8.6929f)
                    verticalLineTo(12.5374f)
                    horizontalLineTo(14.1529f)
                    verticalLineTo(11.8674f)
                    horizontalLineTo(10.7829f)
                    verticalLineTo(8.8374f)
                    horizontalLineTo(13.9629f)
                    verticalLineTo(8.1774f)
                    close()
                    moveTo(17.7429f, 10.8774f)
                    verticalLineTo(10.1674f)
                    horizontalLineTo(16.7429f)
                    verticalLineTo(8.0874f)
                    horizontalLineTo(14.7429f)
                    verticalLineTo(13.4074f)
                    horizontalLineTo(16.7429f)
                    verticalLineTo(10.8774f)
                    horizontalLineTo(17.7429f)
                    close()
                    moveTo(11.2129f, 13.1974f)
                    horizontalLineTo(8.9729f)
                    verticalLineTo(15.9374f)
                    horizontalLineTo(16.9329f)
                    verticalLineTo(15.2774f)
                    horizontalLineTo(11.2129f)
                    verticalLineTo(13.1974f)
                    close()
                }
            }
        }
            .build()
        return _shorts!!
    }

private var _shorts: ImageVector? = null
