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
import androidx.compose.runtime.Stable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import kr.toongether.designsystem.theme.Blue60
import kr.toongether.designsystem.theme.DarkGray
import kr.toongether.designsystem.theme.Gray80
import kr.toongether.designsystem.theme.Shape
import kr.toongether.designsystem.theme.pretendard

@Composable
fun ToongetherAlert(
    modifier: Modifier = Modifier,
    text: String,
    textColor: Color = Color.White,
    buttonText: String,
    buttonTextColor: Color = Color.White,
    buttonColor: Color = Blue60,
    onClickButton: () -> Unit
) {
    Column(
        modifier = modifier
            .background(DarkGray, Shape.medium)
            .padding(24.dp)
    ) {
        Text(
            text = text,
            fontFamily = pretendard,
            fontWeight = FontWeight.Medium,
            color = textColor,
            fontSize = 16.sp
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
                fontFamily = pretendard,
                fontWeight = FontWeight.Normal,
                color = buttonTextColor,
                fontSize = 14.sp
            )
        }
    }
}

@Composable
fun ToongetherAlert(
    modifier: Modifier = Modifier,
    text: String,
    textColor: Color = Color.White,
    firstButtonText: String,
    firstButtonTextColor: Color = Color.White,
    firstButtonColor: Color = Blue60,
    onClickFirstButton: () -> Unit,
    secondButtonText: String,
    onClickSecondButton: () -> Unit
) {
    Column(
        modifier = modifier
            .background(DarkGray, Shape.medium)
            .padding(24.dp)
    ) {
        Text(
            text = text,
            fontFamily = pretendard,
            fontWeight = FontWeight.Medium,
            color = textColor,
            fontSize = 16.sp
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
                fontFamily = pretendard,
                fontWeight = FontWeight.Normal,
                color = firstButtonTextColor,
                fontSize = 14.sp
            )
        }

        Spacer(modifier = Modifier.height(4.dp))

        Button(
            onClick = onClickSecondButton,
            colors = ButtonDefaults.buttonColors(DarkGray),
            modifier = Modifier.fillMaxWidth(),
            shape = Shape.medium,
            contentPadding = PaddingValues(vertical = 8.dp),
            border = BorderStroke(1.dp, Gray80)
        ) {
            Text(
                text = secondButtonText,
                fontFamily = pretendard,
                fontWeight = FontWeight.Normal,
                color = Gray80,
                fontSize = 14.sp
            )
        }
    }
}
