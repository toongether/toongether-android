package kr.toongether.signup

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.imePadding
import androidx.compose.foundation.layout.navigationBarsPadding
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.IconButton
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Visibility
import androidx.compose.material.icons.filled.VisibilityOff
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.Modifier
import androidx.compose.ui.focus.FocusDirection
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.LocalFocusManager
import androidx.compose.ui.platform.LocalSoftwareKeyboardController
import androidx.compose.ui.platform.SoftwareKeyboardController
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import kr.toongether.common.shortToast
import kr.toongether.designsystem.component.ToongetherButton
import kr.toongether.designsystem.component.ToongetherTextField
import kr.toongether.designsystem.icon.ToongetherIcons
import kr.toongether.designsystem.icon.icons.Back
import kr.toongether.designsystem.icon.icons.Cancel
import kr.toongether.designsystem.theme.Blue60
import kr.toongether.designsystem.theme.Blue80
import kr.toongether.designsystem.theme.Gray60
import kr.toongether.designsystem.theme.pretendard
import kr.toongether.ui.LoadingScreen
import org.orbitmvi.orbit.compose.collectAsState
import org.orbitmvi.orbit.compose.collectSideEffect

@OptIn(ExperimentalComposeUiApi::class)
@Composable
fun InputPasswordRoute(
    modifier: Modifier = Modifier,
    navController: NavController,
    name: String,
    userId: String,
    email: String,
    code: String,
    viewModel: SignupViewModel = hiltViewModel()
) {
    val state by viewModel.collectAsState()
    val context = LocalContext.current

    var password by remember { mutableStateOf("") }
    var passwordCheck by remember { mutableStateOf("") }

    val keyboardController = LocalSoftwareKeyboardController.current!!
    val focusManager = LocalFocusManager.current

    var showPassword by remember { mutableStateOf(false) }
    var showPasswordCheck by remember { mutableStateOf(false) }

    viewModel.collectSideEffect {
        when (it) {
            is SignupSideEffect.NavigateToMy -> navController.popBackStack(
                "my_route",
                inclusive = false
            )

            is SignupSideEffect.Toast -> context.shortToast(it.text)
            else -> {}
        }
    }

    InputPasswordScreen(
        modifier = modifier,
        onBackClick = navController::popBackStack,
        password = password,
        passwordCheck = passwordCheck,
        onPasswordChange = { password = it },
        onPasswordCheckChange = { passwordCheck = it },
        keyboardController = keyboardController,
        onClickPasswordCancel = { password = "" },
        onClickPasswordCheckCancel = { passwordCheck = "" },
        state = state,
        onClickSignupButton = {
            viewModel.signup(
                name = name,
                userId = userId,
                email = email,
                code = code,
                password = it
            )
        },
        onClickShowPassword = { showPassword = !showPassword },
        onClickShowPasswordCheck = { showPasswordCheck = !showPasswordCheck },
        onClickNext = { focusManager.moveFocus(FocusDirection.Down) },
        showPassword = showPassword,
        showPasswordCheck = showPasswordCheck
    )
}

@OptIn(ExperimentalComposeUiApi::class)
@Composable
internal fun InputPasswordScreen(
    modifier: Modifier = Modifier,
    onBackClick: () -> Unit,
    password: String,
    passwordCheck: String,
    onPasswordChange: (String) -> Unit,
    onPasswordCheckChange: (String) -> Unit,
    keyboardController: SoftwareKeyboardController,
    onClickPasswordCancel: () -> Unit,
    onClickPasswordCheckCancel: () -> Unit,
    state: SignupState,
    onClickSignupButton: (String) -> Unit,
    onClickShowPassword: () -> Unit,
    onClickShowPasswordCheck: () -> Unit,
    showPassword: Boolean,
    showPasswordCheck: Boolean,
    onClickNext: () -> Unit
) {
    Box(
        modifier
            .fillMaxSize()
            .background(Color.Black)
    ) {
        Column {
            Spacer(modifier = modifier.statusBarsPadding())

            IconButton(
                onClick = onBackClick
            ) {
                Icon(
                    imageVector = ToongetherIcons.Back,
                    contentDescription = null,
                    tint = Color.White
                )
            }

            Spacer(modifier = modifier.height(20.dp))

            Text(
                modifier = modifier.padding(horizontal = 16.dp),
                text = "비밀번호를\n입력해주세요",
                color = Color.White,
                fontSize = 24.sp,
                fontWeight = FontWeight.Bold,
                fontFamily = pretendard
            )

            Spacer(modifier = modifier.height(60.dp))

            ToongetherTextField(
                modifier = modifier
                    .fillMaxWidth(),
                text = password,
                onTextChange = onPasswordChange,
                placeholder = "example1234!",
                keyboardOptions = KeyboardOptions(imeAction = ImeAction.Next),
                visualTransformation = if (showPassword) VisualTransformation.None else PasswordVisualTransformation(),
                label = "비밀번호",
                keyboardActions = KeyboardActions(onNext = { onClickNext.invoke() }),
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
                                imageVector = ToongetherIcons.Cancel,
                                contentDescription = null,
                                tint = Gray60
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
                                tint = Gray60
                            )
                        }
                    }
                }
            )

            Spacer(modifier = modifier.height(20.dp))

            ToongetherTextField(
                modifier = modifier
                    .fillMaxWidth(),
                text = passwordCheck,
                onTextChange = onPasswordCheckChange,
                label = "비밀번호 확인",
                placeholder = "example1234!",
                keyboardOptions = KeyboardOptions(imeAction = ImeAction.Done),
                visualTransformation = if (showPasswordCheck) {
                    VisualTransformation.None
                } else {
                    PasswordVisualTransformation()
                },
                keyboardActions = KeyboardActions(onDone = { keyboardController.hide() }),
                trailingIcon = {
                    Row(
                        modifier = modifier.padding(end = 10.dp)
                    ) {
                        IconButton(
                            modifier = modifier
                                .padding(top = 10.dp, end = 10.dp)
                                .size(24.dp),
                            onClick = onClickPasswordCheckCancel
                        ) {
                            Icon(
                                modifier = modifier.size(18.dp),
                                imageVector = ToongetherIcons.Cancel,
                                contentDescription = null,
                                tint = Gray60
                            )
                        }

                        IconButton(
                            modifier = modifier
                                .padding(top = 10.dp, end = 10.dp)
                                .size(24.dp),
                            onClick = onClickShowPasswordCheck
                        ) {
                            Icon(
                                imageVector = if (showPasswordCheck) {
                                    Icons.Filled.Visibility
                                } else {
                                    Icons.Filled.VisibilityOff
                                },
                                contentDescription = "Visibility",
                                tint = Gray60
                            )
                        }
                    }
                }
            )
        }

        ToongetherButton(
            modifier = modifier
                .fillMaxWidth()
                .align(Alignment.BottomCenter)
                .navigationBarsPadding()
                .imePadding()
                .padding(bottom = 24.dp)
                .padding(horizontal = 16.dp),
            onClick = { onClickSignupButton(password) },
            color = if (password.isBlank() || password != passwordCheck) Blue80 else Blue60
        ) {
            Text(
                text = "완료",
                fontWeight = FontWeight.SemiBold,
                fontFamily = pretendard,
                color = Color.White,
                fontSize = 18.sp
            )
        }

        if (state.isLoading) {
            LoadingScreen()
        }
    }
}
