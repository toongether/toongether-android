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

val ToongetherIcons.Clock: ImageVector
    get() {
        if (_clock != null) {
            return _clock!!
        }
        _clock = ImageVector.Builder(
            name = "Clock",
            defaultWidth = 20.0.dp,
            defaultHeight = 20.0.dp,
            viewportWidth = 20.0f,
            viewportHeight = 20.0f
        ).apply {
            path(
                fill = SolidColor(Color(0xFFFFFFFF)),
                stroke = null,
                strokeLineWidth = 1.0f,
                strokeLineCap = StrokeCap.Butt,
                strokeLineJoin = StrokeJoin.Miter,
                strokeLineMiter = 1.0f,
                pathFillType = PathFillType.NonZero
            ) {
                moveTo(4.62892f, 10.5007f)
                curveTo(4.2564f, 10.5007f, 3.9769f, 10.2215f, 3.9769f, 9.8491f)
                curveTo(3.9769f, 9.4861f, 4.2564f, 9.2068f, 4.6289f, 9.2068f)
                horizontalLineTo(8.84802f)
                verticalLineTo(3.57473f)
                curveTo(8.848f, 3.2117f, 9.1274f, 2.9324f, 9.4907f, 2.9324f)
                curveTo(9.8539f, 2.9324f, 10.1427f, 3.2117f, 10.1427f, 3.5747f)
                verticalLineTo(9.84908f)
                curveTo(10.1427f, 10.2215f, 9.8539f, 10.5007f, 9.4907f, 10.5007f)
                horizontalLineTo(4.62892f)
                close()
                moveTo(9.49999f, 18.9908f)
                curveTo(14.6971f, 18.9908f, 19f, 14.6806f, 19f, 9.4954f)
                curveTo(19f, 4.3008f, 14.6877f, 0f, 9.4907f, 0f)
                curveTo(4.3029f, 0f, 0f, 4.3008f, 0f, 9.4954f)
                curveTo(0f, 14.6806f, 4.3122f, 18.9908f, 9.5f, 18.9908f)
                close()
            }
        }
            .build()
        return _clock!!
    }

private var _clock: ImageVector? = null
