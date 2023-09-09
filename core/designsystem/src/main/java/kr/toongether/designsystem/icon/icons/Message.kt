package kr.toongether.designsystem.icon.icons

import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.PathFillType.Companion.NonZero
import androidx.compose.ui.graphics.SolidColor
import androidx.compose.ui.graphics.StrokeCap.Companion.Butt
import androidx.compose.ui.graphics.StrokeJoin.Companion.Miter
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.graphics.vector.ImageVector.Builder
import androidx.compose.ui.graphics.vector.path
import androidx.compose.ui.unit.dp
import kr.toongether.designsystem.icon.ToongetherIcons

public val ToongetherIcons.Message: ImageVector
    get() {
        if (_message != null) {
            return _message!!
        }
        _message = Builder(
            name = "Message-2",
            defaultWidth = 20.0.dp,
            defaultHeight = 20.0.dp,
            viewportWidth = 20.0f,
            viewportHeight = 20.0f
        ).apply {
            path(
                fill = SolidColor(Color(0xFFffffff)),
                stroke = null,
                strokeLineWidth = 0.0f,
                strokeLineCap = Butt,
                strokeLineJoin = Miter,
                strokeLineMiter = 4.0f,
                pathFillType = NonZero
            ) {
                moveTo(13.3332f, 18.5999f)
                curveTo(13.0498f, 18.5999f, 12.7665f, 18.5166f, 12.5248f, 18.3582f)
                lineTo(8.9748f, 15.9915f)
                horizontalLineTo(5.8332f)
                curveTo(2.9665f, 15.9915f, 1.0415f, 14.0665f, 1.0415f, 11.1999f)
                verticalLineTo(6.1999f)
                curveTo(1.0415f, 3.3332f, 2.9665f, 1.4082f, 5.8332f, 1.4082f)
                horizontalLineTo(14.1665f)
                curveTo(17.0332f, 1.4082f, 18.9582f, 3.3332f, 18.9582f, 6.1999f)
                verticalLineTo(11.1999f)
                curveTo(18.9582f, 13.8499f, 17.3082f, 15.6999f, 14.7915f, 15.9582f)
                verticalLineTo(17.1415f)
                curveTo(14.7915f, 17.6832f, 14.4998f, 18.1749f, 14.0248f, 18.4249f)
                curveTo(13.8082f, 18.5415f, 13.5665f, 18.5999f, 13.3332f, 18.5999f)
                close()
                moveTo(5.8332f, 2.6499f)
                curveTo(3.6832f, 2.6499f, 2.2915f, 4.0415f, 2.2915f, 6.1915f)
                verticalLineTo(11.1915f)
                curveTo(2.2915f, 13.3415f, 3.6832f, 14.7332f, 5.8332f, 14.7332f)
                horizontalLineTo(9.1665f)
                curveTo(9.2915f, 14.7332f, 9.4082f, 14.7665f, 9.5165f, 14.8415f)
                lineTo(13.2248f, 17.3082f)
                curveTo(13.3165f, 17.3665f, 13.3998f, 17.3416f, 13.4415f, 17.3166f)
                curveTo(13.4832f, 17.2916f, 13.5498f, 17.2415f, 13.5498f, 17.1332f)
                verticalLineTo(15.3582f)
                curveTo(13.5498f, 15.0165f, 13.8332f, 14.7332f, 14.1748f, 14.7332f)
                curveTo(16.3248f, 14.7332f, 17.7165f, 13.3415f, 17.7165f, 11.1915f)
                verticalLineTo(6.1915f)
                curveTo(17.7165f, 4.0415f, 16.3248f, 2.6499f, 14.1748f, 2.6499f)
                horizontalLineTo(5.8332f)
                close()
            }
        }
            .build()
        return _message!!
    }

private var _message: ImageVector? = null
