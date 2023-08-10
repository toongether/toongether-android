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

public val ToongetherIcons.Community: ImageVector
    get() {
        if (_community != null) {
            return _community!!
        }
        _community = Builder(
            name = "Community",
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
                moveTo(35.0f, 20.0f)
                curveTo(26.716f, 20.0f, 20.0f, 26.716f, 20.0f, 35.0f)
                verticalLineTo(91.0f)
                curveTo(20.0f, 98.863f, 26.051f, 105.313f, 33.75f, 105.949f)
                lineTo(33.75f, 135.512f)
                curveTo(33.75f, 140.9f, 39.583f, 144.268f, 44.25f, 141.574f)
                lineTo(71.17f, 126.032f)
                lineTo(71.115f, 126.0f)
                horizontalLineTo(64.0f)
                curveTo(51.297f, 126.0f, 41.0f, 115.703f, 41.0f, 103.0f)
                verticalLineTo(70.0f)
                curveTo(41.0f, 57.298f, 51.298f, 47.0f, 64.0f, 47.0f)
                horizontalLineTo(133.0f)
                curveTo(133.674f, 47.0f, 134.341f, 47.029f, 135.0f, 47.086f)
                verticalLineTo(35.0f)
                curveTo(135.0f, 26.716f, 128.284f, 20.0f, 120.0f, 20.0f)
                horizontalLineTo(35.0f)
                close()
                moveTo(49.0f, 70.0f)
                curveTo(49.0f, 61.716f, 55.716f, 55.0f, 64.0f, 55.0f)
                horizontalLineTo(133.0f)
                curveTo(141.284f, 55.0f, 148.0f, 61.716f, 148.0f, 70.0f)
                verticalLineTo(103.0f)
                curveTo(148.0f, 111.201f, 141.419f, 117.864f, 133.25f, 117.998f)
                verticalLineTo(140.512f)
                curveTo(133.25f, 145.9f, 127.417f, 149.268f, 122.75f, 146.574f)
                lineTo(73.258f, 118.0f)
                horizontalLineTo(64.0f)
                curveTo(55.716f, 118.0f, 49.0f, 111.284f, 49.0f, 103.0f)
                verticalLineTo(70.0f)
                close()
                moveTo(67.0f, 78.0f)
                curveTo(67.0f, 79.657f, 68.343f, 81.0f, 70.0f, 81.0f)
                horizontalLineTo(121.0f)
                curveTo(122.657f, 81.0f, 124.0f, 79.657f, 124.0f, 78.0f)
                verticalLineTo(76.0f)
                curveTo(124.0f, 74.343f, 122.657f, 73.0f, 121.0f, 73.0f)
                horizontalLineTo(70.0f)
                curveTo(68.343f, 73.0f, 67.0f, 74.343f, 67.0f, 76.0f)
                verticalLineTo(78.0f)
                close()
                moveTo(70.0f, 100.0f)
                curveTo(68.343f, 100.0f, 67.0f, 98.657f, 67.0f, 97.0f)
                verticalLineTo(95.0f)
                curveTo(67.0f, 93.343f, 68.343f, 92.0f, 70.0f, 92.0f)
                horizontalLineTo(114.0f)
                curveTo(115.657f, 92.0f, 117.0f, 93.343f, 117.0f, 95.0f)
                verticalLineTo(97.0f)
                curveTo(117.0f, 98.657f, 115.657f, 100.0f, 114.0f, 100.0f)
                horizontalLineTo(70.0f)
                close()
            }
        }
            .build()
        return _community!!
    }

private var _community: ImageVector? = null
