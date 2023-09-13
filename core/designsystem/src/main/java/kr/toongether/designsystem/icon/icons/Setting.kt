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

public val ToongetherIcons.Setting: ImageVector
    get() {
        if (_setting != null) {
            return _setting!!
        }
        _setting = ImageVector.Builder(
            name = "Setting",
            defaultWidth = 24.0.dp,
            defaultHeight = 24.0.dp,
            viewportWidth = 24.0f,
            viewportHeight = 24.0f
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
                    pathFillType = PathFillType.EvenOdd
                ) {
                    moveTo(21.3339f, 9.07551f)
                    lineTo(19.3941f, 8.33236f)
                    curveTo(19.2632f, 8.2819f, 19.1439f, 8.2053f, 19.0435f, 8.1073f)
                    curveTo(18.9432f, 8.0093f, 18.8638f, 7.8919f, 18.8102f, 7.7623f)
                    curveTo(18.7566f, 7.6326f, 18.7299f, 7.4934f, 18.7318f, 7.3532f)
                    curveTo(18.7337f, 7.2129f, 18.7641f, 7.0745f, 18.8211f, 6.9463f)
                    lineTo(19.6656f, 5.05237f)
                    curveTo(19.7517f, 4.8614f, 19.7775f, 4.6486f, 19.7394f, 4.4425f)
                    curveTo(19.7013f, 4.2365f, 19.6011f, 4.047f, 19.4524f, 3.8994f)
                    lineTo(18.0982f, 2.54289f)
                    curveTo(17.9503f, 2.3946f, 17.7609f, 2.2948f, 17.5549f, 2.2567f)
                    curveTo(17.349f, 2.2186f, 17.1364f, 2.2441f, 16.9452f, 2.3296f)
                    lineTo(15.0516f, 3.17799f)
                    curveTo(14.9232f, 3.2348f, 14.7847f, 3.265f, 14.6443f, 3.2666f)
                    curveTo(14.504f, 3.2683f, 14.3648f, 3.2414f, 14.2351f, 3.1875f)
                    curveTo(14.1055f, 3.1337f, 13.9881f, 3.0541f, 13.8902f, 2.9536f)
                    curveTo(13.7923f, 2.853f, 13.7158f, 2.7336f, 13.6655f, 2.6026f)
                    lineTo(12.923f, 0.664954f)
                    curveTo(12.8481f, 0.4693f, 12.7156f, 0.3009f, 12.543f, 0.1822f)
                    curveTo(12.3704f, 0.0635f, 12.1658f, -0.0001f, 11.9563f, 0f)
                    horizontalLineTo(10.0395f)
                    curveTo(9.83f, 0f, 9.6255f, 0.0636f, 9.4529f, 0.1823f)
                    curveTo(9.2804f, 0.301f, 9.1479f, 0.4693f, 9.0731f, 0.665f)
                    lineTo(8.33206f, 2.6026f)
                    curveTo(8.2817f, 2.7336f, 8.2052f, 2.853f, 8.1073f, 2.9536f)
                    curveTo(8.0094f, 3.0541f, 7.892f, 3.1337f, 7.7624f, 3.1875f)
                    curveTo(7.6328f, 3.2414f, 7.4935f, 3.2683f, 7.3532f, 3.2666f)
                    curveTo(7.2128f, 3.265f, 7.0743f, 3.2348f, 6.9459f, 3.178f)
                    lineTo(5.05049f, 2.33107f)
                    curveTo(4.8594f, 2.2455f, 4.6467f, 2.2201f, 4.4408f, 2.2582f)
                    curveTo(4.2349f, 2.2962f, 4.0454f, 2.396f, 3.8975f, 2.5443f)
                    lineTo(2.54195f, 3.89803f)
                    curveTo(2.3937f, 4.046f, 2.294f, 4.2354f, 2.2559f, 4.4413f)
                    curveTo(2.2178f, 4.6472f, 2.2432f, 4.8598f, 2.3287f, 5.051f)
                    lineTo(3.17566f, 6.94488f)
                    curveTo(3.2328f, 7.0732f, 3.2631f, 7.2118f, 3.2649f, 7.3522f)
                    curveTo(3.2667f, 7.4926f, 3.2398f, 7.6319f, 3.186f, 7.7616f)
                    curveTo(3.1321f, 7.8913f, 3.0524f, 8.0087f, 2.9517f, 8.1066f)
                    curveTo(2.851f, 8.2045f, 2.7314f, 8.2808f, 2.6002f, 8.3309f)
                    lineTo(0.664986f, 9.07408f)
                    curveTo(0.4694f, 9.1483f, 0.301f, 9.2803f, 0.1822f, 9.4526f)
                    curveTo(0.0634f, 9.6248f, -0.0001f, 9.8291f, 0f, 10.0383f)
                    verticalLineTo(11.9574f)
                    curveTo(-0.0001f, 12.1667f, 0.0634f, 12.371f, 0.1822f, 12.5432f)
                    curveTo(0.301f, 12.7154f, 0.4694f, 12.8474f, 0.665f, 12.9217f)
                    lineTo(2.60024f, 13.6627f)
                    curveTo(2.7316f, 13.7131f, 2.8514f, 13.7898f, 2.9521f, 13.8881f)
                    curveTo(3.0529f, 13.9863f, 3.1327f, 14.104f, 3.1865f, 14.2341f)
                    curveTo(3.2403f, 14.3641f, 3.2671f, 14.5037f, 3.2653f, 14.6445f)
                    curveTo(3.2634f, 14.7852f, 3.2329f, 14.9241f, 3.1757f, 15.0526f)
                    lineTo(2.32799f, 16.9451f)
                    curveTo(2.2425f, 17.1363f, 2.2171f, 17.3489f, 2.2552f, 17.5548f)
                    curveTo(2.2933f, 17.7607f, 2.393f, 17.9501f, 2.5412f, 18.0981f)
                    lineTo(3.8968f, 19.4557f)
                    curveTo(4.045f, 19.6035f, 4.2344f, 19.703f, 4.4402f, 19.741f)
                    curveTo(4.646f, 19.7791f, 4.8585f, 19.754f, 5.0498f, 19.6689f)
                    lineTo(6.9438f, 18.8245f)
                    curveTo(7.072f, 18.7669f, 7.2107f, 18.7362f, 7.3513f, 18.7342f)
                    curveTo(7.4918f, 18.7322f, 7.6313f, 18.7589f, 7.7611f, 18.8128f)
                    curveTo(7.891f, 18.8667f, 8.0084f, 18.9466f, 8.1062f, 19.0476f)
                    curveTo(8.204f, 19.1485f, 8.2802f, 19.2684f, 8.3299f, 19.3999f)
                    lineTo(9.07097f, 21.335f)
                    curveTo(9.1458f, 21.5307f, 9.2782f, 21.699f, 9.4508f, 21.8177f)
                    curveTo(9.6234f, 21.9364f, 9.8279f, 22f, 10.0374f, 22f)
                    horizontalLineTo(11.9541f)
                    curveTo(12.1636f, 22f, 12.3681f, 21.9364f, 12.5407f, 21.8177f)
                    curveTo(12.7132f, 21.699f, 12.8457f, 21.5307f, 12.9205f, 21.335f)
                    lineTo(13.6615f, 19.3999f)
                    curveTo(13.7113f, 19.2684f, 13.7874f, 19.1485f, 13.8853f, 19.0476f)
                    curveTo(13.9831f, 18.9466f, 14.1005f, 18.8667f, 14.2303f, 18.8128f)
                    curveTo(14.3602f, 18.7589f, 14.4996f, 18.7322f, 14.6402f, 18.7342f)
                    curveTo(14.7808f, 18.7362f, 14.9194f, 18.7669f, 15.0477f, 18.8245f)
                    lineTo(16.947f, 19.6675f)
                    curveTo(17.1383f, 19.7525f, 17.3508f, 19.7777f, 17.5566f, 19.7396f)
                    curveTo(17.7624f, 19.7015f, 17.9518f, 19.6021f, 18.1f, 19.4543f)
                    lineTo(19.4556f, 18.0966f)
                    curveTo(19.6043f, 17.9491f, 19.7045f, 17.7596f, 19.7426f, 17.5535f)
                    curveTo(19.7807f, 17.3475f, 19.7549f, 17.1347f, 19.6688f, 16.9437f)
                    lineTo(18.8243f, 15.0523f)
                    curveTo(18.7671f, 14.9239f, 18.7366f, 14.7851f, 18.7346f, 14.6446f)
                    curveTo(18.7326f, 14.504f, 18.7592f, 14.3645f, 18.8128f, 14.2345f)
                    curveTo(18.8664f, 14.1045f, 18.9458f, 13.9867f, 19.0463f, 13.8884f)
                    curveTo(19.1468f, 13.79f, 19.2662f, 13.7131f, 19.3973f, 13.6623f)
                    lineTo(21.3371f, 12.9213f)
                    curveTo(21.5324f, 12.8467f, 21.7003f, 12.7146f, 21.8187f, 12.5424f)
                    curveTo(21.937f, 12.3702f, 22.0003f, 12.1661f, 22f, 11.9571f)
                    verticalLineTo(10.0379f)
                    curveTo(22.0003f, 9.829f, 21.937f, 9.6249f, 21.8187f, 9.4527f)
                    curveTo(21.7003f, 9.2805f, 21.5324f, 9.1483f, 21.3371f, 9.0737f)
                    moveTo(11.9563f, 15.8061f)
                    curveTo(10.9247f, 16.0119f, 9.8542f, 15.8805f, 8.9031f, 15.4312f)
                    curveTo(7.952f, 14.9819f, 7.1706f, 14.2386f, 6.6745f, 13.3111f)
                    curveTo(6.1784f, 12.3835f, 5.9938f, 11.321f, 6.148f, 10.2805f)
                    curveTo(6.3022f, 9.24f, 6.7871f, 8.2767f, 7.5309f, 7.533f)
                    curveTo(8.2748f, 6.7893f, 9.2382f, 6.3045f, 10.2787f, 6.1504f)
                    curveTo(11.3193f, 5.9963f, 12.3818f, 6.181f, 13.3093f, 6.6772f)
                    curveTo(14.2369f, 7.1734f, 14.9802f, 7.9547f, 15.4294f, 8.9058f)
                    curveTo(15.8786f, 9.857f, 16.01f, 10.9274f, 15.804f, 11.9589f)
                    curveTo(15.6138f, 12.9082f, 15.147f, 13.7801f, 14.4623f, 14.4647f)
                    curveTo(13.7776f, 15.1493f, 12.9057f, 15.616f, 11.9563f, 15.8061f)
                    close()
                }
            }
        }
            .build()
        return _setting!!
    }

private var _setting: ImageVector? = null
