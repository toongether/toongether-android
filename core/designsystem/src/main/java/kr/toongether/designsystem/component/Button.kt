package kr.toongether.designsystem.component

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.RowScope
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Button
import androidx.compose.material.ButtonColors
import androidx.compose.material.ButtonDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import kr.toongether.designsystem.theme.Shape
import kr.toongether.designsystem.utils.NoRippleInteractionSource

@Composable
fun ToongetherButton(
    onClick: () -> Unit,
    modifier: Modifier = Modifier.wrapContentSize(),
    enabled: Boolean = true,
    shape: RoundedCornerShape = Shape.large,
    color: ButtonColors = ButtonDefaults.buttonColors(backgroundColor = Color.White),
    contentPadding: PaddingValues = PaddingValues(horizontal = 24.dp, vertical = 14.dp),
    content: @Composable RowScope.() -> Unit,
) {
    Button(
        onClick = onClick,
        modifier = modifier,
        enabled = enabled,
        shape = shape,
        colors = color,
        interactionSource = remember { NoRippleInteractionSource() },
        contentPadding = contentPadding,
        content = content
    )
}
