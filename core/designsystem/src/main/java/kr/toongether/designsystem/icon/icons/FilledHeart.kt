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

public val ToongetherIcons.FilledHeart: ImageVector
    get() {
        if (_heart != null) {
            return _heart!!
        }
        _heart = ImageVector.Builder(
            name = "Heart1",
            defaultWidth = 20.0.dp,
            defaultHeight = 20.0.dp,
            viewportWidth = 20.0f,
            viewportHeight = 20.0f
        ).apply {
            path(
                fill = SolidColor(Color(0xFFFF0B0B)),
                stroke = null,
                strokeLineWidth = 0.0f,
                strokeLineCap = StrokeCap.Butt,
                strokeLineJoin = StrokeJoin.Miter,
                strokeLineMiter = 4.0f,
                pathFillType = PathFillType.NonZero
            ) {
                moveTo(13.6998f, 2.583f)
                curveTo(12.1915f, 2.583f, 10.8415f, 3.3163f, 9.9998f, 4.4413f)
                curveTo(9.1582f, 3.3163f, 7.8082f, 2.583f, 6.2998f, 2.583f)
                curveTo(3.7415f, 2.583f, 1.6665f, 4.6663f, 1.6665f, 7.2413f)
                curveTo(1.6665f, 8.233f, 1.8248f, 9.1497f, 2.0998f, 9.9997f)
                curveTo(3.4165f, 14.1663f, 7.4748f, 16.658f, 9.4832f, 17.3413f)
                curveTo(9.7665f, 17.4413f, 10.2332f, 17.4413f, 10.5165f, 17.3413f)
                curveTo(12.5248f, 16.658f, 16.5832f, 14.1663f, 17.8998f, 9.9997f)
                curveTo(18.1748f, 9.1497f, 18.3332f, 8.233f, 18.3332f, 7.2413f)
                curveTo(18.3332f, 4.6663f, 16.2582f, 2.583f, 13.6998f, 2.583f)
                close()
            }
        }
            .build()
        return _heart!!
    }

private var _heart: ImageVector? = null
