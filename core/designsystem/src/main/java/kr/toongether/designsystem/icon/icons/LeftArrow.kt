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

val ToongetherIcons.LeftArrow: ImageVector
    get() {
        if (_leftArrow != null) {
            return _leftArrow!!
        }
        _leftArrow = ImageVector.Builder(
            name = "vector",
            defaultWidth = 8.dp,
            defaultHeight = 13.dp,
            viewportWidth = 8f,
            viewportHeight = 13f
        ).apply {
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
                moveTo(7.20952f, 13f)
                curveTo(7.0086f, 13f, 6.8077f, 12.9333f, 6.649f, 12.7903f)
                lineTo(0.230007f, 7.00404f)
                curveTo(-0.0767f, 6.7276f, -0.0767f, 6.27f, 0.23f, 5.9936f)
                lineTo(6.64904f, 0.207333f)
                curveTo(6.9557f, -0.0691f, 7.4633f, -0.0691f, 7.77f, 0.2073f)
                curveTo(8.0767f, 0.4838f, 8.0767f, 0.9413f, 7.77f, 1.2178f)
                lineTo(1.91143f, 6.49882f)
                lineTo(7.76999f, 11.7798f)
                curveTo(8.0767f, 12.0563f, 8.0767f, 12.5138f, 7.77f, 12.7903f)
                curveTo(7.6219f, 12.9333f, 7.4104f, 13f, 7.2095f, 13f)
                close()
            }
        }.build()
        return _leftArrow!!
    }

private var _leftArrow: ImageVector? = null
