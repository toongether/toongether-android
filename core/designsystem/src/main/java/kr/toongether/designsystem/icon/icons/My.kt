package kr.toongether.designsystem.icon.icons

import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.PathFillType.Companion.EvenOdd
import androidx.compose.ui.graphics.PathFillType.Companion.NonZero
import androidx.compose.ui.graphics.SolidColor
import androidx.compose.ui.graphics.StrokeCap.Companion.Butt
import androidx.compose.ui.graphics.StrokeJoin.Companion.Miter
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.graphics.vector.ImageVector.Builder
import androidx.compose.ui.graphics.vector.path
import androidx.compose.ui.unit.dp
import kr.toongether.designsystem.icon.ToongetherIcons

public val ToongetherIcons.My: ImageVector
    get() {
        if (_my != null) {
            return _my!!
        }
        _my = Builder(
            name = "My",
            defaultWidth = 168.0.dp,
            defaultHeight = 168.0.dp,
            viewportWidth =
            168.0f,
            viewportHeight = 168.0f
        ).apply {
            path(
                fill = SolidColor(Color(0xFF787878)),
                stroke = null,
                strokeLineWidth = 0.0f,
                strokeLineCap = Butt,
                strokeLineJoin = Miter,
                strokeLineMiter = 4.0f,
                pathFillType = NonZero
            ) {
                moveTo(84.0f, 50.0f)
                moveToRelative(-30.0f, 0.0f)
                arcToRelative(30.0f, 30.0f, 0.0f, true, true, 60.0f, 0.0f)
                arcToRelative(30.0f, 30.0f, 0.0f, true, true, -60.0f, 0.0f)
            }
            path(
                fill = SolidColor(Color(0xFF787878)),
                stroke = null,
                strokeLineWidth = 0.0f,
                strokeLineCap = Butt,
                strokeLineJoin = Miter,
                strokeLineMiter = 4.0f,
                pathFillType = EvenOdd
            ) {
                moveTo(148.0f, 148.0f)
                curveTo(148.0f, 114.863f, 119.346f, 88.0f, 84.0f, 88.0f)
                curveTo(48.654f, 88.0f, 20.0f, 114.863f, 20.0f, 148.0f)
                horizontalLineTo(148.0f)
                close()
            }
        }
            .build()
        return _my!!
    }

private var _my: ImageVector? = null
