package kr.toongether.designsystem.icon.icons

import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.PathFillType.Companion.EvenOdd
import androidx.compose.ui.graphics.SolidColor
import androidx.compose.ui.graphics.StrokeCap.Companion.Butt
import androidx.compose.ui.graphics.StrokeJoin.Companion.Miter
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.graphics.vector.ImageVector.Builder
import androidx.compose.ui.graphics.vector.path
import androidx.compose.ui.unit.dp
import kr.toongether.designsystem.icon.ToongetherIcons

public val ToongetherIcons.Home: ImageVector
    get() {
        if (_home != null) {
            return _home!!
        }
        _home = Builder(
            name = "Home",
            defaultWidth = 168.0.dp,
            defaultHeight = 168.0.dp,
            viewportWidth = 168.0f,
            viewportHeight = 168.0f
        ).apply {
            path(
                fill = SolidColor(Color(0xFF787878)),
                stroke = null,
                strokeLineWidth = 0.0f,
                strokeLineCap = Butt,
                strokeLineJoin = Miter,
                strokeLineMiter = 4.0f,
                pathFillType = EvenOdd
            ) {
                moveTo(74.203f, 23.65f)
                curveTo(79.832f, 18.795f, 88.168f, 18.795f, 93.797f, 23.65f)
                lineTo(112.753f, 40.0f)
                lineTo(148.0f, 70.4f)
                horizontalLineTo(20.0f)
                lineTo(55.247f, 40.0f)
                horizontalLineTo(55.247f)
                lineTo(74.203f, 23.65f)
                close()
                moveTo(20.0f, 70.4f)
                horizontalLineTo(148.0f)
                verticalLineTo(133.0f)
                curveTo(148.0f, 141.285f, 141.284f, 148.0f, 133.0f, 148.0f)
                horizontalLineTo(35.0f)
                curveTo(26.716f, 148.0f, 20.0f, 141.285f, 20.0f, 133.0f)
                verticalLineTo(70.4f)
                close()
                moveTo(82.0f, 96.0f)
                curveTo(73.716f, 96.0f, 67.0f, 102.716f, 67.0f, 111.0f)
                verticalLineTo(148.0f)
                horizontalLineTo(101.0f)
                verticalLineTo(111.0f)
                curveTo(101.0f, 102.716f, 94.284f, 96.0f, 86.0f, 96.0f)
                horizontalLineTo(82.0f)
                close()
            }
        }
            .build()
        return _home!!
    }

private var _home: ImageVector? = null
