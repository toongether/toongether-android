package kr.toongether.designsystem.component

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import kr.toongether.designsystem.theme.Shape
import kr.toongether.designsystem.theme.ToongetherColors
import kr.toongether.designsystem.theme.ToongetherTypography

@Composable
fun ToongetherAlert(
    modifier: Modifier = Modifier,
    text: String,
    textColor: Color = ToongetherColors.LabelNormal,
    buttonText: String,
    buttonTextColor: Color = ToongetherColors.LabelNormal,
    buttonColor: Color = ToongetherColors.PrimaryNormal,
    onClickButton: () -> Unit
) {
    Column(
        modifier = modifier
            .background(ToongetherColors.BackgroundAlternative, Shape.medium)
            .padding(24.dp)
    ) {
        Text(
            text = text,
            style = ToongetherTypography.Label1,
            color = textColor,
        )

        Spacer(modifier = Modifier.height(12.dp))

        Button(
            onClick = onClickButton,
            colors = ButtonDefaults.buttonColors(buttonColor),
            modifier = Modifier.fillMaxWidth(),
            shape = Shape.medium,
            contentPadding = PaddingValues(vertical = 8.dp)
        ) {
            Text(
                text = buttonText,
                style = ToongetherTypography.Caption2,
                color = buttonTextColor,
            )
        }
    }
}

@Composable
fun ToongetherAlert(
    modifier: Modifier = Modifier,
    text: String,
    textColor: Color = ToongetherColors.LabelNormal,
    firstButtonText: String,
    firstButtonTextColor: Color = ToongetherColors.LabelNormal,
    firstButtonColor: Color = ToongetherColors.PrimaryNormal,
    onClickFirstButton: () -> Unit,
    secondButtonText: String,
    onClickSecondButton: () -> Unit
) {
    Column(
        modifier = modifier
            .background(ToongetherColors.BackgroundAlternative, Shape.medium)
            .padding(24.dp)
    ) {
        Text(
            text = text,
            style = ToongetherTypography.Label1,
            color = textColor,
        )

        Spacer(modifier = Modifier.height(12.dp))

        Button(
            onClick = onClickFirstButton,
            colors = ButtonDefaults.buttonColors(firstButtonColor),
            modifier = Modifier.fillMaxWidth(),
            shape = Shape.medium,
            contentPadding = PaddingValues(vertical = 8.dp)
        ) {
            Text(
                text = firstButtonText,
                style = ToongetherTypography.Caption2,
                color = firstButtonTextColor,
            )
        }

        Spacer(modifier = Modifier.height(4.dp))

        Button(
            onClick = onClickSecondButton,
            colors = ButtonDefaults.buttonColors(ToongetherColors.PrimaryNormal),
            modifier = Modifier.fillMaxWidth(),
            shape = Shape.medium,
            contentPadding = PaddingValues(vertical = 8.dp),
            border = BorderStroke(1.dp, ToongetherColors.LabelNormal)
        ) {
            Text(
                text = secondButtonText,
                style = ToongetherTypography.Caption2,
                color = ToongetherColors.LabelNormal,
            )
        }
    }
}
