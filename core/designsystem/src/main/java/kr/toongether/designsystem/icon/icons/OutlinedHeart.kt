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

public val ToongetherIcons.OutlinedHeart: ImageVector
    get() {
        if (_heart != null) {
            return _heart!!
        }
        _heart = ImageVector.Builder(
            name = "Heart",
            defaultWidth = 20.0.dp,
            defaultHeight = 20.0.dp,
            viewportWidth = 20.0f,
            viewportHeight = 20.0f
        ).apply {
            path(
                fill = SolidColor(Color(0xFFffffff)),
                stroke = null,
                strokeLineWidth = 0.0f,
                strokeLineCap = StrokeCap.Butt,
                strokeLineJoin = StrokeJoin.Miter,
                strokeLineMiter = 4.0f,
                pathFillType = PathFillType.NonZero
            ) {
                moveTo(9.9998f, 18.0413f)
                curveTo(9.7415f, 18.0413f, 9.4915f, 18.008f, 9.2832f, 17.933f)
                curveTo(6.0998f, 16.8413f, 1.0415f, 12.9663f, 1.0415f, 7.2413f)
                curveTo(1.0415f, 4.3247f, 3.3998f, 1.958f, 6.2998f, 1.958f)
                curveTo(7.7082f, 1.958f, 9.0248f, 2.508f, 9.9998f, 3.4913f)
                curveTo(10.9748f, 2.508f, 12.2915f, 1.958f, 13.6998f, 1.958f)
                curveTo(16.5998f, 1.958f, 18.9582f, 4.333f, 18.9582f, 7.2413f)
                curveTo(18.9582f, 12.9747f, 13.8998f, 16.8413f, 10.7165f, 17.933f)
                curveTo(10.5082f, 18.008f, 10.2582f, 18.0413f, 9.9998f, 18.0413f)
                close()
                moveTo(6.2998f, 3.208f)
                curveTo(4.0915f, 3.208f, 2.2915f, 5.0163f, 2.2915f, 7.2413f)
                curveTo(2.2915f, 12.933f, 7.7665f, 16.0997f, 9.6915f, 16.758f)
                curveTo(9.8415f, 16.808f, 10.1665f, 16.808f, 10.3165f, 16.758f)
                curveTo(12.2332f, 16.0997f, 17.7165f, 12.9413f, 17.7165f, 7.2413f)
                curveTo(17.7165f, 5.0163f, 15.9165f, 3.208f, 13.7082f, 3.208f)
                curveTo(12.4415f, 3.208f, 11.2665f, 3.7997f, 10.5082f, 4.8247f)
                curveTo(10.2748f, 5.1413f, 9.7415f, 5.1413f, 9.5082f, 4.8247f)
                curveTo(8.7332f, 3.7913f, 7.5665f, 3.208f, 6.2998f, 3.208f)
                close()
            }
        }
            .build()
        return _heart!!
    }

private var _heart: ImageVector? = null
