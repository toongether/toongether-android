package kr.toongether.designsystem.icon.icons

import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.PathFillType.Companion.EvenOdd
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
        _series = Builder(name = "Series", defaultWidth = 168.0.dp, defaultHeight = 168.0.dp,
                viewportWidth = 168.0f, viewportHeight = 168.0f).apply {
            group {
                path(fill = SolidColor(Color(0xFF787878)), stroke = null, strokeLineWidth = 0.0f,
                        strokeLineCap = Butt, strokeLineJoin = Miter, strokeLineMiter = 4.0f,
                        pathFillType = EvenOdd) {
                    moveTo(91.876f, 23.822f)
                    curveTo(91.113f, 25.319f, 91.113f, 27.28f, 91.113f, 31.2f)
                    verticalLineTo(136.689f)
                    curveTo(91.113f, 140.61f, 91.113f, 142.57f, 91.876f, 144.067f)
                    curveTo(92.547f, 145.384f, 93.618f, 146.455f, 94.935f, 147.126f)
                    curveTo(96.432f, 147.889f, 98.393f, 147.889f, 102.313f, 147.889f)
                    horizontalLineTo(105.954f)
                    curveTo(109.875f, 147.889f, 111.835f, 147.889f, 113.332f, 147.126f)
                    curveTo(114.649f, 146.455f, 115.72f, 145.384f, 116.391f, 144.067f)
                    curveTo(117.154f, 142.57f, 117.154f, 140.61f, 117.154f, 136.689f)
                    verticalLineTo(51.935f)
                    lineTo(125.818f, 137.94f)
                    curveTo(126.196f, 141.686f, 126.385f, 143.559f, 127.23f, 144.913f)
                    curveTo(128.051f, 146.229f, 129.294f, 147.219f, 130.761f, 147.724f)
                    curveTo(132.27f, 148.244f, 134.137f, 148.008f, 137.872f, 147.536f)
                    lineTo(137.873f, 147.536f)
                    horizontalLineTo(137.873f)
                    curveTo(141.608f, 147.064f, 143.475f, 146.828f, 144.843f, 145.944f)
                    curveTo(146.172f, 145.085f, 147.187f, 143.81f, 147.726f, 142.322f)
                    curveTo(148.281f, 140.791f, 148.092f, 138.918f, 147.715f, 135.173f)
                    verticalLineTo(135.173f)
                    lineTo(138.81f, 46.781f)
                    verticalLineTo(46.781f)
                    curveTo(138.432f, 43.035f, 138.244f, 41.162f, 137.399f, 39.808f)
                    curveTo(136.577f, 38.492f, 135.334f, 37.502f, 133.867f, 36.997f)
                    curveTo(132.358f, 36.477f, 130.491f, 36.713f, 126.756f, 37.185f)
                    curveTo(123.02f, 37.658f, 121.153f, 37.894f, 119.785f, 38.777f)
                    curveTo(118.641f, 39.516f, 117.729f, 40.564f, 117.154f, 41.791f)
                    verticalLineTo(31.2f)
                    curveTo(117.154f, 27.28f, 117.154f, 25.319f, 116.391f, 23.822f)
                    curveTo(115.72f, 22.505f, 114.649f, 21.434f, 113.332f, 20.763f)
                    curveTo(111.835f, 20.0f, 109.875f, 20.0f, 105.954f, 20.0f)
                    horizontalLineTo(102.313f)
                    curveTo(98.393f, 20.0f, 96.432f, 20.0f, 94.935f, 20.763f)
                    curveTo(93.618f, 21.434f, 92.547f, 22.505f, 91.876f, 23.822f)
                    close()
                    moveTo(20.763f, 39.528f)
                    curveTo(20.0f, 41.025f, 20.0f, 42.985f, 20.0f, 46.906f)
                    verticalLineTo(136.689f)
                    curveTo(20.0f, 140.609f, 20.0f, 142.57f, 20.763f, 144.067f)
                    curveTo(21.434f, 145.384f, 22.505f, 146.455f, 23.822f, 147.126f)
                    curveTo(25.319f, 147.889f, 27.28f, 147.889f, 31.2f, 147.889f)
                    horizontalLineTo(32.838f)
                    curveTo(36.758f, 147.889f, 38.719f, 147.889f, 40.216f, 147.126f)
                    curveTo(41.533f, 146.455f, 42.604f, 145.384f, 43.275f, 144.067f)
                    curveTo(44.038f, 142.57f, 44.038f, 140.609f, 44.038f, 136.689f)
                    verticalLineTo(46.906f)
                    curveTo(44.038f, 42.985f, 44.038f, 41.025f, 43.275f, 39.528f)
                    curveTo(42.604f, 38.21f, 41.533f, 37.14f, 40.216f, 36.468f)
                    curveTo(38.719f, 35.706f, 36.758f, 35.706f, 32.838f, 35.706f)
                    horizontalLineTo(31.2f)
                    curveTo(27.28f, 35.706f, 25.319f, 35.706f, 23.822f, 36.468f)
                    curveTo(22.505f, 37.14f, 21.434f, 38.21f, 20.763f, 39.528f)
                    close()
                    moveTo(50.048f, 67.099f)
                    curveTo(50.048f, 63.178f, 50.048f, 61.218f, 50.811f, 59.721f)
                    curveTo(51.482f, 58.403f, 52.553f, 57.333f, 53.87f, 56.661f)
                    curveTo(55.367f, 55.899f, 57.327f, 55.899f, 61.248f, 55.899f)
                    horizontalLineTo(73.903f)
                    curveTo(77.824f, 55.899f, 79.784f, 55.899f, 81.281f, 56.661f)
                    curveTo(82.598f, 57.333f, 83.669f, 58.403f, 84.34f, 59.721f)
                    curveTo(85.103f, 61.218f, 85.103f, 63.178f, 85.103f, 67.099f)
                    verticalLineTo(136.689f)
                    curveTo(85.103f, 140.609f, 85.103f, 142.57f, 84.34f, 144.067f)
                    curveTo(83.669f, 145.384f, 82.598f, 146.455f, 81.281f, 147.126f)
                    curveTo(79.784f, 147.889f, 77.824f, 147.889f, 73.903f, 147.889f)
                    horizontalLineTo(61.248f)
                    curveTo(57.327f, 147.889f, 55.367f, 147.889f, 53.87f, 147.126f)
                    curveTo(52.553f, 146.455f, 51.482f, 145.384f, 50.811f, 144.067f)
                    curveTo(50.048f, 142.57f, 50.048f, 140.609f, 50.048f, 136.689f)
                    verticalLineTo(67.099f)
                    close()
                }
            }
        }
        .build()
        return _series!!
    }

private var _series: ImageVector? = null
