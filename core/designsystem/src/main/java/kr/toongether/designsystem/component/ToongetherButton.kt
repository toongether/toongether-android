package kr.toongether.designsystem.component

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.RowScope
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import kr.toongether.designsystem.theme.Pretendard
import kr.toongether.designsystem.theme.Shape
import kr.toongether.designsystem.theme.ToongetherColors
import kr.toongether.designsystem.utils.NoRippleInteractionSource

@Composable
fun ToongetherButton(
    onClick: () -> Unit,
    modifier: Modifier = Modifier.wrapContentSize(),
    enabled: Boolean = true,
    shape: RoundedCornerShape = Shape.large,
    color: Color = ToongetherColors.PrimaryNormal,
    contentPadding: PaddingValues = PaddingValues(horizontal = 24.dp, vertical = 14.dp),
    content: @Composable RowScope.() -> Unit
) {
    Button(
        onClick = onClick,
        modifier = modifier,
        enabled = enabled,
        shape = shape,
        colors = ButtonDefaults.buttonColors(containerColor = color),
        interactionSource = remember { NoRippleInteractionSource() },
        contentPadding = contentPadding,
        content = content
    )
}

@Composable
fun ToongetherLargeButton(
    modifier: Modifier = Modifier,
    text: String,
    color: Color = ToongetherColors.PrimaryNormal,
    textColor: Color = Color.White,
    enabled: Boolean = true,
    onClick: () -> Unit
) {
    Button(
        onClick = onClick,
        modifier = modifier.fillMaxWidth(),
        shape = Shape.medium,
        enabled = enabled,
        colors = ButtonDefaults.buttonColors(containerColor = color),
        interactionSource = remember { NoRippleInteractionSource() },
        contentPadding = PaddingValues(vertical = 12.dp),
        content = {
            Text(
                text = text,
                fontFamily = Pretendard,
                fontSize = 18.sp,
                fontWeight = FontWeight.SemiBold,
                color = textColor
            )
        }
    )
}
