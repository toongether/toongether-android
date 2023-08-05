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

val ToongetherIcons.Book: ImageVector
    get() {
        if (_book != null) {
            return _book!!
        }
        _book = Builder(name = "Book", defaultWidth = 168.0.dp, defaultHeight = 168.0.dp,
                viewportWidth = 168.0f, viewportHeight = 168.0f).apply {
            path(fill = SolidColor(Color(0xFFffffff)), stroke = null, strokeLineWidth = 0.0f,
                    strokeLineCap = Butt, strokeLineJoin = Miter, strokeLineMiter = 4.0f,
                    pathFillType = NonZero) {
                moveTo(0.0f, 0.0f)
                horizontalLineToRelative(168.0f)
                verticalLineToRelative(168.0f)
                horizontalLineToRelative(-168.0f)
                close()
            }
            path(fill = SolidColor(Color(0xFF000000)), stroke = null, strokeLineWidth = 0.0f,
                    strokeLineCap = Butt, strokeLineJoin = Miter, strokeLineMiter = 4.0f,
                    pathFillType = EvenOdd) {
                moveTo(35.0f, 20.0f)
                curveTo(26.716f, 20.0f, 20.0f, 26.716f, 20.0f, 35.0f)
                verticalLineTo(133.0f)
                curveTo(20.0f, 141.284f, 26.716f, 148.0f, 35.0f, 148.0f)
                horizontalLineTo(133.0f)
                curveTo(141.284f, 148.0f, 148.0f, 141.284f, 148.0f, 133.0f)
                verticalLineTo(35.0f)
                curveTo(148.0f, 26.716f, 141.284f, 20.0f, 133.0f, 20.0f)
                horizontalLineTo(35.0f)
                close()
                moveTo(44.0f, 33.0f)
                curveTo(42.343f, 33.0f, 41.0f, 34.343f, 41.0f, 36.0f)
                verticalLineTo(103.0f)
                curveTo(41.0f, 104.657f, 42.343f, 106.0f, 44.0f, 106.0f)
                horizontalLineTo(46.0f)
                curveTo(47.657f, 106.0f, 49.0f, 104.657f, 49.0f, 103.0f)
                verticalLineTo(36.0f)
                curveTo(49.0f, 34.343f, 47.657f, 33.0f, 46.0f, 33.0f)
                horizontalLineTo(44.0f)
                close()
                moveTo(66.0f, 51.0f)
                curveTo(66.0f, 52.657f, 67.343f, 54.0f, 69.0f, 54.0f)
                lineTo(120.0f, 54.0f)
                curveTo(121.657f, 54.0f, 123.0f, 52.657f, 123.0f, 51.0f)
                verticalLineTo(49.0f)
                curveTo(123.0f, 47.343f, 121.657f, 46.0f, 120.0f, 46.0f)
                lineTo(69.0f, 46.0f)
                curveTo(67.343f, 46.0f, 66.0f, 47.343f, 66.0f, 49.0f)
                verticalLineTo(51.0f)
                close()
                moveTo(69.0f, 73.0f)
                curveTo(67.343f, 73.0f, 66.0f, 71.657f, 66.0f, 70.0f)
                verticalLineTo(68.0f)
                curveTo(66.0f, 66.343f, 67.343f, 65.0f, 69.0f, 65.0f)
                horizontalLineTo(113.0f)
                curveTo(114.657f, 65.0f, 116.0f, 66.343f, 116.0f, 68.0f)
                verticalLineTo(70.0f)
                curveTo(116.0f, 71.657f, 114.657f, 73.0f, 113.0f, 73.0f)
                horizontalLineTo(69.0f)
                close()
            }
        }
        .build()
        return _book!!
    }

private var _book: ImageVector? = null
