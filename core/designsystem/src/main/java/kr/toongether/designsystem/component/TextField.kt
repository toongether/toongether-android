package kr.toongether.designsystem.component

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Divider
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.focus.FocusRequester
import androidx.compose.ui.focus.focusRequester
import androidx.compose.ui.focus.onFocusChanged
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import kr.toongether.designsystem.theme.Blue60
import kr.toongether.designsystem.theme.Gray60
import kr.toongether.designsystem.theme.pretendard

@Composable
fun ToongetherTextField(
    modifier: Modifier = Modifier,
    text: String,
    onTextChange: (String) -> Unit,
    enabled: Boolean = true,
    label: String? = null,
    placeholder: String? = null,
    singleLine: Boolean = true,
    maxLines: Int = 1,
    isError: Boolean = false,
    trailingIcon: @Composable (() -> Unit)? = null,
    visualTransformation: VisualTransformation = VisualTransformation.None,
    keyboardOptions: KeyboardOptions = KeyboardOptions.Default,
    keyboardActions: KeyboardActions = KeyboardActions()
) {
    var isFocused by remember { mutableStateOf(false) }
    val focusRequester by remember { mutableStateOf(FocusRequester.Default) }

    Column {
        TextField(
            modifier = modifier
                .focusRequester(focusRequester)
                .onFocusChanged { isFocused = it.isFocused },
            value = text,
            textStyle = TextStyle(
                fontSize = 20.sp,
                fontFamily = pretendard,
                color = Color.White,
                fontWeight = FontWeight.Normal
            ),
            onValueChange = onTextChange,
            enabled = enabled,
            label = {
                label?.let {
                    Text(
                        text = it,
                        fontFamily = pretendard,
                        fontWeight = FontWeight.SemiBold,
                        fontSize = 12.sp
                    )
                }
            },
            placeholder = {
                placeholder?.let {
                    Text(
                        text = it,
                        fontFamily = pretendard,
                        fontWeight = FontWeight.Normal,
                        fontSize = 20.sp
                    )
                }
            },
            singleLine = singleLine,
            maxLines = maxLines,
            colors = TextFieldDefaults.colors(
                focusedTextColor = Color.White,
                focusedLabelColor = Blue60,
                focusedPlaceholderColor = Gray60,
                focusedContainerColor = Color.Transparent,
                focusedIndicatorColor = Color.Transparent,
                unfocusedTextColor = Color.White,
                unfocusedContainerColor = Color.Transparent,
                unfocusedLabelColor = Gray60,
                unfocusedPlaceholderColor = Gray60,
                unfocusedIndicatorColor = Color.Transparent
            ),
            isError = isError,
            visualTransformation = visualTransformation,
            keyboardOptions = keyboardOptions,
            keyboardActions = keyboardActions,
            trailingIcon = if (isFocused) trailingIcon else null
        )

        Divider(
            modifier = modifier
                .fillMaxWidth().padding(horizontal = 15.dp),
            color = if (isFocused) Blue60 else Gray60
        )
    }
}
