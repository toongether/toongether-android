package kr.toongether.designsystem.icon.icons

import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.PathFillType
import androidx.compose.ui.graphics.SolidColor
import androidx.compose.ui.graphics.StrokeCap
import androidx.compose.ui.graphics.StrokeJoin
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.graphics.vector.path
import androidx.compose.ui.unit.dp
import kr.toongether.designsystem.icon.ToongetherIcons

public val ToongetherIcons.FilledMessage: ImageVector
    get() {
        if (_message != null) {
            return _message!!
        }
        _message = ImageVector.Builder(
            name = "FilledMessage",
            defaultWidth = 14.dp,
            defaultHeight = 14.dp,
            viewportWidth = 14f,
            viewportHeight = 14f
        ).apply {
            path(
                fill = SolidColor(Color(0xFF787878)),
                fillAlpha = 1.0f,
                stroke = null,
                strokeAlpha = 1.0f,
                strokeLineWidth = 1.0f,
                strokeLineCap = StrokeCap.Butt,
                strokeLineJoin = StrokeJoin.Miter,
                strokeLineMiter = 1.0f,
                pathFillType = PathFillType.EvenOdd
            ) {
                moveTo(3.87523f, 2f)
                horizontalLineTo(9.6257f)
                curveTo(11.3508f, 2f, 12.5009f, 3.1501f, 12.5009f, 4.8752f)
                verticalLineTo(8.32551f)
                curveTo(12.5009f, 10.0507f, 11.3508f, 11.2007f, 9.6257f, 11.2007f)
                verticalLineTo(12.4256f)
                curveTo(9.6257f, 12.8856f, 9.1139f, 13.1559f, 8.7344f, 12.9029f)
                lineTo(6.17542f, 11.2007f)
                horizontalLineTo(3.87523f)
                curveTo(2.1501f, 11.2007f, 1f, 10.0507f, 1f, 8.3255f)
                verticalLineTo(4.87523f)
                curveTo(1f, 3.1501f, 2.1501f, 2f, 3.8752f, 2f)
                close()
            }
        }
            .build()
        return _message!!
    }

private var _message: ImageVector? = null
