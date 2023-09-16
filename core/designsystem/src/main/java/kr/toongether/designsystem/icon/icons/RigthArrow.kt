package kr.toongether.designsystem.icon.icons

import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.PathFillType
import androidx.compose.ui.graphics.SolidColor
import androidx.compose.ui.graphics.StrokeCap
import androidx.compose.ui.graphics.StrokeJoin
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.graphics.vector.group
import androidx.compose.ui.graphics.vector.path
import androidx.compose.ui.unit.dp
import kr.toongether.designsystem.icon.ToongetherIcons

val ToongetherIcons.RightArrow: ImageVector
    get() {
        if (_rightArrow != null) {
            return _rightArrow!!
        }
        _rightArrow = ImageVector.Builder(
            name = "RightArrow",
            defaultWidth = 9.dp,
            defaultHeight = 15.dp,
            viewportWidth = 9f,
            viewportHeight = 15f
        ).apply {
            group {
                path(
                    fill = SolidColor(Color(0xFFFFFFFF)),
                    fillAlpha = 1.0f,
                    stroke = null,
                    strokeAlpha = 1.0f,
                    strokeLineWidth = 1.0f,
                    strokeLineCap = StrokeCap.Butt,
                    strokeLineJoin = StrokeJoin.Miter,
                    strokeLineMiter = 1.0f,
                    pathFillType = PathFillType.NonZero
                ) {
                    moveTo(9f, 7.50425f)
                    curveTo(9f, 7.2178f, 8.8933f, 6.9751f, 8.6535f, 6.7487f)
                    lineTo(1.75532f, 0.292075f)
                    curveTo(1.5619f, 0.1f, 1.3211f, 0.0069f, 1.0353f, 0.0069f)
                    curveTo(0.4574f, 0.0069f, 0f, 0.4364f, 0f, 0.985f)
                    curveTo(0f, 1.2615f, 0.1228f, 1.5043f, 0.3185f, 1.6955f)
                    lineTo(6.53972f, 7.50578f)
                    lineTo(0.318506f, 13.313f)
                    curveTo(0.1212f, 13.5058f, 0f, 13.7539f, 0f, 14.022f)
                    curveTo(0f, 14.5722f, 0.4574f, 15f, 1.0353f, 15f)
                    curveTo(1.3227f, 15f, 1.5619f, 14.907f, 1.7553f, 14.7219f)
                    lineTo(8.65354f, 8.25983f)
                    curveTo(8.8917f, 8.0403f, 8.9984f, 7.7922f, 9f, 7.5042f)
                    close()
                }
            }
        }
            .build()
        return _rightArrow!!
    }

private var _rightArrow: ImageVector? = null
