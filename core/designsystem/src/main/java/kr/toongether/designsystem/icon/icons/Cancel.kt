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

val ToongetherIcons.Cancel: ImageVector
    get() {
        if (_cancel != null) {
            return _cancel!!
        }
        _cancel = Builder(name = "Cancel", defaultWidth = 16.0.dp, defaultHeight = 16.0.dp,
                viewportWidth = 16.0f, viewportHeight = 16.0f).apply {
            path(fill = SolidColor(Color(0xFFA5A5A5)), stroke = null, strokeLineWidth = 0.0f,
                    strokeLineCap = Butt, strokeLineJoin = Miter, strokeLineMiter = 4.0f,
                    pathFillType = EvenOdd) {
                moveTo(8.0f, 16.0f)
                curveTo(12.4183f, 16.0f, 16.0f, 12.4183f, 16.0f, 8.0f)
                curveTo(16.0f, 3.5817f, 12.4183f, 0.0f, 8.0f, 0.0f)
                curveTo(3.5817f, 0.0f, 0.0f, 3.5817f, 0.0f, 8.0f)
                curveTo(0.0f, 12.4183f, 3.5817f, 16.0f, 8.0f, 16.0f)
                close()
                moveTo(10.959f, 11.7774f)
                lineTo(8.0936f, 8.912f)
                lineTo(5.2281f, 11.7774f)
                curveTo(5.0043f, 12.0012f, 4.6332f, 12.0012f, 4.4094f, 11.7774f)
                curveTo(4.1856f, 11.5536f, 4.1856f, 11.1825f, 4.4094f, 10.9587f)
                lineTo(7.2748f, 8.0933f)
                lineTo(4.4093f, 5.2277f)
                curveTo(4.1856f, 5.004f, 4.1856f, 4.6328f, 4.4093f, 4.409f)
                curveTo(4.6331f, 4.1853f, 5.0043f, 4.1853f, 5.2281f, 4.409f)
                lineTo(8.0936f, 7.2745f)
                lineTo(10.9591f, 4.409f)
                curveTo(11.1828f, 4.1853f, 11.554f, 4.1853f, 11.7778f, 4.409f)
                curveTo(12.0016f, 4.6328f, 12.0016f, 5.004f, 11.7778f, 5.2277f)
                lineTo(8.9123f, 8.0933f)
                lineTo(11.7777f, 10.9587f)
                curveTo(12.0015f, 11.1825f, 12.0015f, 11.5536f, 11.7777f, 11.7774f)
                curveTo(11.5539f, 12.0012f, 11.1828f, 12.0012f, 10.959f, 11.7774f)
                close()
            }
        }
        .build()
        return _cancel!!
    }

private var _cancel: ImageVector? = null
