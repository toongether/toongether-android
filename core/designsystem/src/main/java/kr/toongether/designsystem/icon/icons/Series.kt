package kr.toongether.designsystem.icon.icons

import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.PathFillType.Companion.EvenOdd
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

public val ToongetherIcons.Series: ImageVector
    get() {
        if (_series != null) {
            return _series!!
        }
        _series = Builder(
            name = "연재1 2",
            defaultWidth = 24.0.dp,
            defaultHeight = 24.0.dp,
            viewportWidth = 24.0f,
            viewportHeight = 24.0f
        ).apply {
            group {
                path(
                    fill = SolidColor(Color(0xFF787878)),
                    stroke = null,
                    strokeLineWidth = 0.0f,
                    strokeLineCap = Butt,
                    strokeLineJoin = Miter,
                    strokeLineMiter = 4.0f,
                    pathFillType = NonZero
                ) {
                    moveTo(7.0f, 3.3574f)
                    curveTo(7.0f, 3.0813f, 6.7761f, 2.8574f, 6.5f, 2.8574f)
                    curveTo(6.2239f, 2.8574f, 6.0f, 3.0813f, 6.0f, 3.3574f)
                    verticalLineTo(5.6431f)
                    curveTo(6.0f, 5.9193f, 6.2239f, 6.1431f, 6.5f, 6.1431f)
                    curveTo(6.7761f, 6.1431f, 7.0f, 5.9193f, 7.0f, 5.6431f)
                    verticalLineTo(3.3574f)
                    close()
                }
                path(
                    fill = SolidColor(Color(0xFF787878)),
                    stroke = null,
                    strokeLineWidth = 0.0f,
                    strokeLineCap = Butt,
                    strokeLineJoin = Miter,
                    strokeLineMiter = 4.0f,
                    pathFillType = NonZero
                ) {
                    moveTo(17.7143f, 3.3574f)
                    curveTo(17.7143f, 3.0813f, 17.4904f, 2.8574f, 17.2143f, 2.8574f)
                    curveTo(16.9382f, 2.8574f, 16.7143f, 3.0813f, 16.7143f, 3.3574f)
                    verticalLineTo(5.3574f)
                    curveTo(16.7143f, 5.6336f, 16.9382f, 5.8574f, 17.2143f, 5.8574f)
                    curveTo(17.4904f, 5.8574f, 17.7143f, 5.6336f, 17.7143f, 5.3574f)
                    verticalLineTo(3.3574f)
                    close()
                }
                path(
                    fill = SolidColor(Color(0xFF787878)),
                    stroke = null,
                    strokeLineWidth = 0.0f,
                    strokeLineCap = Butt,
                    strokeLineJoin = Miter,
                    strokeLineMiter = 4.0f,
                    pathFillType = EvenOdd
                ) {
                    moveTo(2.8572f, 6.5716f)
                    curveTo(2.8572f, 5.3881f, 3.8165f, 4.4287f, 5.0f, 4.4287f)
                    horizontalLineTo(19.0f)
                    curveTo(20.1834f, 4.4287f, 21.1429f, 5.3881f, 21.1429f, 6.5716f)
                    horizontalLineTo(2.8572f)
                    close()
                    moveTo(2.8572f, 7.5716f)
                    horizontalLineTo(21.1429f)
                    verticalLineTo(19.0001f)
                    curveTo(21.1429f, 20.1836f, 20.1834f, 21.143f, 19.0f, 21.143f)
                    horizontalLineTo(5.0f)
                    curveTo(3.8165f, 21.143f, 2.8572f, 20.1836f, 2.8572f, 19.0001f)
                    verticalLineTo(7.5716f)
                    close()
                    moveTo(11.673f, 11.0827f)
                    horizontalLineTo(10.5765f)
                    verticalLineTo(14.9499f)
                    curveTo(10.5765f, 15.7159f, 10.0491f, 16.2599f, 9.2121f, 16.2641f)
                    curveTo(8.375f, 16.2599f, 7.8435f, 15.7159f, 7.8393f, 14.9499f)
                    verticalLineTo(11.0827f)
                    horizontalLineTo(6.7511f)
                    verticalLineTo(15.042f)
                    curveTo(6.7553f, 16.3436f, 7.7263f, 17.2351f, 9.2121f, 17.2351f)
                    curveTo(10.6895f, 17.2351f, 11.6688f, 16.3436f, 11.673f, 15.042f)
                    verticalLineTo(11.0827f)
                    close()
                    moveTo(12.7946f, 11.0827f)
                    verticalLineTo(17.143f)
                    horizontalLineTo(13.8828f)
                    verticalLineTo(15.0923f)
                    horizontalLineTo(15.0547f)
                    curveTo(16.4526f, 15.0923f, 17.2017f, 14.251f, 17.2059f, 13.0917f)
                    curveTo(17.2017f, 11.9282f, 16.461f, 11.0827f, 15.0714f, 11.0827f)
                    horizontalLineTo(12.7946f)
                    close()
                    moveTo(14.904f, 14.1966f)
                    horizontalLineTo(13.8828f)
                    verticalLineTo(11.9951f)
                    horizontalLineTo(14.904f)
                    curveTo(15.7243f, 11.9951f, 16.0926f, 12.4429f, 16.0926f, 13.0917f)
                    curveTo(16.0926f, 13.732f, 15.7243f, 14.1924f, 14.904f, 14.1966f)
                    close()
                }
            }
        }
            .build()
        return _series!!
    }

private var _series: ImageVector? = null
