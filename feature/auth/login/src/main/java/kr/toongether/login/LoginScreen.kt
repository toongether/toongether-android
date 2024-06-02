package kr.toongether.login

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Visibility
import androidx.compose.material.icons.filled.VisibilityOff
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalSoftwareKeyboardController
import androidx.compose.ui.platform.SoftwareKeyboardController
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import kr.toongether.designsystem.component.ToongetherAlert
import kr.toongether.designsystem.component.ToongetherLargeButton
import kr.toongether.designsystem.component.ToongetherTextField
import kr.toongether.designsystem.icon.ToongetherIcons
import kr.toongether.designsystem.theme.Pretendard
import kr.toongether.designsystem.theme.ToongetherColors
import kr.toongether.designsystem.utils.NoRippleInteractionSource
import org.orbitmvi.orbit.compose.collectAsState
import org.orbitmvi.orbit.compose.collectSideEffect

@Composable
internal fun LoginRoute(
    modifier: Modifier = Modifier,
    viewModel: LoginViewModel = hiltViewModel(),
    onBackClick: () -> Unit,
    onClickSignup: () -> Unit,
) {
    var userId by remember { mutableStateOf("") }
    var password by remember { mutableStateOf("") }
    var showPassword by remember { mutableStateOf(false) }
    val keyboardController = LocalSoftwareKeyboardController.current!!

    val state by viewModel.collectAsState()
    var isShowAlert by remember { mutableStateOf(false) }

    viewModel.collectSideEffect {
        when (it) {
            is LoginSideEffect.Toast -> {
                isShowAlert = true
                keyboardController.hide()
            }
            is LoginSideEffect.Success -> onBackClick()
        }
    }

    if (isShowAlert) {
         ToongetherAlert(
             text = "아이디 또는 비밀번호가 일치하지 않습니다.",
             buttonText = "확인",
             onClickButton = {
                 isShowAlert = false
                 keyboardController.show()
             }
         )
    }

    LoginScreen(
        modifier = modifier,
        state = state,
        onBackClick = onBackClick,
        onClickLogin = viewModel::login,
        userId = userId,
        password = password,
        showPassword = showPassword,
        keyboardController = keyboardController,
        onClickUserIdCancel = { userId = "" },
        onPasswordChange = { password = it },
        onUserIdChange = { userId = it },
        onClickShowPassword = { showPassword = !showPassword },
        onClickPasswordCancel = { password = "" },
        onClickSignup = onClickSignup
    )
}

@Composable
internal fun LoginScreen(
    modifier: Modifier = Modifier,
    state: LoginState,
    userId: String,
    password: String,
    showPassword: Boolean,
    keyboardController: SoftwareKeyboardController,
    onBackClick: () -> Unit,
    onClickLogin: (String, String) -> Unit,
    onUserIdChange: (String) -> Unit,
    onPasswordChange: (String) -> Unit,
    onClickUserIdCancel: () -> Unit,
    onClickShowPassword: () -> Unit,
    onClickPasswordCancel: () -> Unit,
    onClickSignup: () -> Unit
) {
    Box(
        modifier = modifier
            .fillMaxSize()
            .background(ToongetherColors.BackgroundNormal)
    ) {
        Column {
            Spacer(modifier = modifier.statusBarsPadding())

            IconButton(
                onClick = onBackClick
            ) {
                Icon(
                    imageVector = ToongetherIcons.Bold.ArrowLeft,
                    contentDescription = null,
                    tint = ToongetherColors.White
                )
            }

            Spacer(modifier = modifier.height(16.dp))

            Text(
                modifier = modifier.padding(horizontal = 16.dp),
                text = "로그인해주세요",
                color = Color.White,
                fontSize = 24.sp,
                fontWeight = FontWeight.Bold,
                fontFamily = Pretendard
            )

            Spacer(modifier = modifier.height(60.dp))

            ToongetherTextField(
                modifier = modifier.fillMaxWidth(),
                text = userId,
                onTextChange = onUserIdChange,
                label = "아이디 또는 이메일",
                placeholder = "toonie@toongether.kr",
                keyboardOptions = KeyboardOptions(imeAction = ImeAction.Next),
                trailingIcon = {
                    IconButton(
                        modifier = modifier
                            .padding(top = 10.dp, end = 10.dp)
                            .size(24.dp),
                        onClick = onClickUserIdCancel
                    ) {
                        Icon(
                            modifier = modifier.size(18.dp),
                            imageVector = ToongetherIcons.Fill.XCircle,
                            contentDescription = null,
                            tint = ToongetherColors.LabelAssistive
                        )
                    }
                }
            )

            Spacer(modifier = modifier.height(16.dp))

            ToongetherTextField(
                modifier = modifier
                    .fillMaxWidth(),
                text = password,
                onTextChange = onPasswordChange,
                label = "비밀번호",
                placeholder = "••••••••",
                keyboardOptions = KeyboardOptions(imeAction = ImeAction.Done),
                keyboardActions = KeyboardActions(onDone = { keyboardController.hide() }),
                visualTransformation = if (showPassword) VisualTransformation.None else PasswordVisualTransformation(),
                trailingIcon = {
                    Row(
                        modifier = modifier.padding(end = 10.dp)
                    ) {
                        IconButton(
                            modifier = modifier
                                .padding(top = 10.dp, end = 10.dp)
                                .size(24.dp),
                            onClick = onClickPasswordCancel
                        ) {
                            Icon(
                                modifier = modifier.size(18.dp),
                                imageVector = ToongetherIcons.Fill.XCircle,
                                contentDescription = null,
                                tint = ToongetherColors.LabelAssistive
                            )
                        }

                        IconButton(
                            modifier = modifier
                                .padding(top = 10.dp, end = 10.dp)
                                .size(24.dp),
                            onClick = onClickShowPassword
                        ) {
                            Icon(
                                imageVector = if (showPassword) Icons.Filled.Visibility else Icons.Filled.VisibilityOff,
                                contentDescription = "Visibility",
                                tint = ToongetherColors.LabelAssistive
                            )
                        }
                    }
                }
            )

            Spacer(modifier = modifier.height(40.dp))

            ToongetherLargeButton(
                modifier = modifier
                    .fillMaxWidth()
                    .padding(horizontal = 16.dp),
                onClick = { onClickLogin(userId, password) },
                color = if (userId.isNotBlank() && password.isNotBlank()) ToongetherColors.PrimaryNormal else ToongetherColors.PrimaryNormal.copy(0.6f),
                text = "로그인"
            )

            Spacer(modifier = modifier.height(16.dp))

            Row(
                modifier = modifier
                    .align(Alignment.CenterHorizontally)
            ) {
                Text(
                    modifier = modifier,
                    text = "툰게더가 처음이신가요? ",
                    fontWeight = FontWeight.Normal,
                    fontFamily = Pretendard,
                    color = Color.White,
                    fontSize = 14.sp
                )

                Text(
                    modifier = modifier
                        .clickable(
                            interactionSource = NoRippleInteractionSource(),
                            indication = null,
                            onClick = onClickSignup
                        ),
                    text = "회원가입",
                    fontWeight = FontWeight.SemiBold,
                    fontFamily = Pretendard,
                    color = ToongetherColors.PrimaryNormal,
                    fontSize = 14.sp
                )
            }
        }
    }
}
