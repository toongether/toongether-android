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

val ToongetherIcons.Check: ImageVector
    get() {
        if (_check != null) {
            return _check!!
        }
        _check = ImageVector.Builder(
            name = "Check",
            defaultWidth = 20.0.dp,
            defaultHeight = 20.0.dp,
            viewportWidth = 20.0f,
            viewportHeight = 20.0f
        ).apply {
            group {
                path(
                    fill = SolidColor(Color(0xFFFFFFFF)),
                    stroke = null,
                    strokeLineWidth = 1.0f,
                    strokeLineCap = StrokeCap.Butt,
                    strokeLineJoin = StrokeJoin.Miter,
                    strokeLineMiter = 1.0f,
                    pathFillType = PathFillType.NonZero
                ) {
                    moveTo(9.49999f, 18.9908f)
                    curveTo(14.6971f, 18.9908f, 19f, 14.6806f, 19f, 9.4954f)
                    curveTo(19f, 4.3008f, 14.6877f, 0f, 9.4907f, 0f)
                    curveTo(4.3029f, 0f, 0f, 4.3008f, 0f, 9.4954f)
                    curveTo(0f, 14.6806f, 4.3122f, 18.9908f, 9.5f, 18.9908f)
                    close()
                    moveTo(8.45685f, 14.0475f)
                    curveTo(8.1402f, 14.0475f, 7.8794f, 13.9172f, 7.6372f, 13.5914f)
                    lineTo(5.2995f, 10.7242f)
                    curveTo(5.1598f, 10.538f, 5.076f, 10.3331f, 5.076f, 10.119f)
                    curveTo(5.076f, 9.7002f, 5.402f, 9.3557f, 5.8211f, 9.3557f)
                    curveTo(6.0912f, 9.3557f, 6.2961f, 9.4395f, 6.5289f, 9.7467f)
                    lineTo(8.41959f, 12.1857f)
                    lineTo(12.3965f, 5.79962f)
                    curveTo(12.5735f, 5.5203f, 12.8157f, 5.3714f, 13.0578f, 5.3714f)
                    curveTo(13.4676f, 5.3714f, 13.8495f, 5.6507f, 13.8495f, 6.0882f)
                    curveTo(13.8495f, 6.293f, 13.7284f, 6.5071f, 13.6166f, 6.7026f)
                    lineTo(9.2392f, 13.5914f)
                    curveTo(9.0436f, 13.8986f, 8.7735f, 14.0475f, 8.4568f, 14.0475f)
                    close()
                }
            }
        }
            .build()
        return _check!!
    }

private var _check: ImageVector? = null
