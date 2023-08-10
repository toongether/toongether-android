package kr.toongether.designsystem.icon.icons

import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.PathFillType.Companion.NonZero
import androidx.compose.ui.graphics.SolidColor
import androidx.compose.ui.graphics.StrokeCap.Companion.Butt
import androidx.compose.ui.graphics.StrokeJoin.Companion.Miter
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.graphics.vector.ImageVector.Builder
import androidx.compose.ui.graphics.vector.group
import androidx.compose.ui.graphics.vector.path
import androidx.compose.ui.unit.dp
import kr.toongether.designsystem.icon.ToongetherIcons

val ToongetherIcons.ScrollIndicator: ImageVector
    get() {
        if (_scrollindicator != null) {
            return _scrollindicator!!
        }
        _scrollindicator = Builder(
            name = "Scrollindicator",
            defaultWidth = 14.0.dp,
            defaultHeight = 30.0.dp,
            viewportWidth = 14.0f,
            viewportHeight = 30.0f
        ).apply {
            group {
                path(
                    fill = SolidColor(Color(0xFFffffff)),
                    stroke = null,
                    strokeLineWidth = 0.0f,
                    strokeLineCap = Butt,
                    strokeLineJoin = Miter,
                    strokeLineMiter = 4.0f,
                    pathFillType = NonZero
                ) {
                    moveTo(0.2646f, 6.7733f)
                    curveTo(0.0947f, 6.9471f, 0.0f, 7.1787f, 0.0f, 7.4455f)
                    curveTo(0.0f, 7.9836f, 0.3993f, 8.4038f, 0.9128f, 8.4038f)
                    curveTo(1.1709f, 8.4038f, 1.409f, 8.3027f, 1.5759f, 8.1147f)
                    lineTo(7.3901f, 1.8963f)
                    horizontalLineTo(6.617f)
                    lineTo(12.4255f, 8.1147f)
                    curveTo(12.5975f, 8.3042f, 12.837f, 8.4038f, 13.0872f, 8.4038f)
                    curveTo(13.5992f, 8.4038f, 14.0f, 7.9836f, 14.0f, 7.4455f)
                    curveTo(14.0f, 7.1772f, 13.9067f, 6.9456f, 13.734f, 6.7733f)
                    lineTo(7.7156f, 0.337f)
                    curveTo(7.5158f, 0.1161f, 7.2727f, 0.003f, 7.0039f, 0.0f)
                    curveTo(6.7301f, 0.0f, 6.4921f, 0.1146f, 6.2858f, 0.337f)
                    lineTo(0.2646f, 6.7733f)
                    close()
                }
            }
            group {
                path(
                    fill = SolidColor(Color(0xFFffffff)),
                    stroke = null,
                    strokeLineWidth = 0.0f,
                    strokeLineCap = Butt,
                    strokeLineJoin = Miter,
                    strokeLineMiter = 4.0f,
                    pathFillType = NonZero
                ) {
                    moveTo(13.7354f, 23.2267f)
                    curveTo(13.9053f, 23.0529f, 14.0f, 22.8213f, 14.0f, 22.5545f)
                    curveTo(14.0f, 22.0165f, 13.6007f, 21.5962f, 13.0872f, 21.5962f)
                    curveTo(12.8291f, 21.5962f, 12.591f, 21.6973f, 12.4241f, 21.8853f)
                    lineTo(6.6099f, 28.1037f)
                    lineTo(7.383f, 28.1037f)
                    lineTo(1.5745f, 21.8853f)
                    curveTo(1.4025f, 21.6958f, 1.163f, 21.5962f, 0.9128f, 21.5962f)
                    curveTo(0.4008f, 21.5962f, -0.0f, 22.0165f, -0.0f, 22.5545f)
                    curveTo(-0.0f, 22.8228f, 0.0933f, 23.0544f, 0.266f, 23.2267f)
                    lineTo(6.2844f, 29.663f)
                    curveTo(6.4842f, 29.8839f, 6.7273f, 29.997f, 6.9961f, 30.0f)
                    curveTo(7.2699f, 30.0f, 7.5079f, 29.8854f, 7.7142f, 29.663f)
                    lineTo(13.7354f, 23.2267f)
                    close()
                }
            }
        }
            .build()
        return _scrollindicator!!
    }

private var _scrollindicator: ImageVector? = null
