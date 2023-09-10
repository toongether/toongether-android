package kr.toongether.designsystem.component

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import kr.toongether.designsystem.theme.Black10
import kr.toongether.designsystem.theme.Gray50
import kr.toongether.designsystem.theme.Shape
import kr.toongether.designsystem.theme.pretendard
import kr.toongether.designsystem.utils.NoRippleInteractionSource

@Composable
fun ToongetherCard(
    modifier: Modifier = Modifier,
    title: String,
    titleColor: Color = Color.White,
    text: String? = null,
    textColor: Color = Gray50,
    icon: ImageVector,
    iconTint: Color = Gray50,
    onClick: (() -> Unit)? = null,
) {
    Row(
        modifier = modifier
            .fillMaxWidth()
            .padding(horizontal = 12.dp)
            .background(Black10, shape = Shape.medium)
            .padding(horizontal = 24.dp, vertical = 12.dp)
            .clickable(
                interactionSource = NoRippleInteractionSource(),
                indication = null,
                onClick = { onClick?.invoke() }
            ),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Text(
            text = title,
            fontSize = 16.sp,
            fontFamily = pretendard,
            fontWeight = FontWeight.Medium,
            color = titleColor
        )

        Spacer(modifier = modifier.weight(1f))

        if (text != null) {
            Text(
                text = text,
                fontSize = 16.sp,
                fontFamily = pretendard,
                fontWeight = FontWeight.Medium,
                color = textColor
            )
        }

        Spacer(modifier = modifier.width(8.dp))

        Icon(
            modifier = modifier,
            imageVector = icon,
            contentDescription = null,
            tint = iconTint
        )
    }
}
