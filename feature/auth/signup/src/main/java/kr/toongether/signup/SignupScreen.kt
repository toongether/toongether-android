package kr.toongether.signup

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.ime
import androidx.compose.foundation.layout.imePadding
import androidx.compose.foundation.layout.navigationBarsPadding
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.IconButton
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.Modifier
import androidx.compose.ui.focus.FocusDirection
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.platform.LocalFocusManager
import androidx.compose.ui.platform.LocalSoftwareKeyboardController
import androidx.compose.ui.platform.SoftwareKeyboardController
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import kotlinx.coroutines.delay
import kr.toongether.designsystem.component.ToongetherButton
import kr.toongether.designsystem.component.ToongetherTextField
import kr.toongether.designsystem.icon.ToongetherIcons
import kr.toongether.designsystem.icon.icons.Back
import kr.toongether.designsystem.icon.icons.Cancel
import kr.toongether.designsystem.theme.Blue60
import kr.toongether.designsystem.theme.Blue80
import kr.toongether.designsystem.theme.Gray60
import kr.toongether.designsystem.theme.pretendard
import kr.toongether.signup.navigation.navigateToCheckEmail
import kr.toongether.ui.AlertScreen
import kr.toongether.ui.LoadingScreen
import org.orbitmvi.orbit.compose.collectAsState
import org.orbitmvi.orbit.compose.collectSideEffect

@OptIn(ExperimentalComposeUiApi::class)
@Composable
fun SignupRoute(
    modifier: Modifier = Modifier,
    navController: NavController,
    viewModel: SignupViewModel = hiltViewModel(),
    alert: (@Composable () -> Unit) -> Unit
) {
    val signupState by viewModel.collectAsState()

    var isShowId by remember { mutableStateOf(false) }
    var isShowEmail by remember { mutableStateOf(false) }
    var isShowAlert by remember { mutableStateOf(false) }

    var nickname by remember { mutableStateOf("") }
    var userId by remember { mutableStateOf("") }
    var email by remember { mutableStateOf("") }

    val keyboardController = LocalSoftwareKeyboardController.current!!
    val focusManager = LocalFocusManager.current

    viewModel.collectSideEffect {
        when (it) {
            is SignupSideEffect.SuccessCheckDuplicateUser -> isShowEmail = true
            is SignupSideEffect.SuccessCheckDuplicateEmail -> viewModel.sendEmail(email)
            is SignupSideEffect.NavigateToCheckEmail -> navController.navigateToCheckEmail(
                email = email,
                name = nickname,
                userId = userId
            )
            is SignupSideEffect.Toast -> {
                isShowAlert = true
                keyboardController.hide()
                alert {
                    AlertScreen(
                        isShowAlert = isShowAlert,
                        text = it.text,
                        buttonText = "확인"
                    ) {
                        isShowAlert = false
                        keyboardController.show()
                    }
                }
            }
            else -> {}
        }
    }

    LaunchedEffect(Unit) {
        focusManager.moveFocus(FocusDirection.Enter)
    }

    LaunchedEffect(isShowId) {
        delay(timeMillis = 10)
        focusManager.moveFocus(FocusDirection.Up)
    }

    LaunchedEffect(isShowEmail) {
        delay(timeMillis = 10)
        focusManager.moveFocus(FocusDirection.Up)
    }

    SignupScreen(
        modifier = modifier,
        onBackClick = navController::popBackStack,
        isShowId = isShowId,
        isShowEmail = isShowEmail,
        nickname = nickname,
        userId = userId,
        email = email,
        onUserIdChange = { userId = it },
        onNicknameChange = { nickname = it },
        onEmailChange = { email = it },
        onClickUserIdCancel = { userId = "" },
        onClickEmailCancel = { email = "" },
        onClickNicknameCancel = { nickname = "" },
        keyboardController = keyboardController,
        onClickEmailButton = {
            if (userId.isBlank() || (userId.matches("^[a-zA-Z](?:[a-zA-Z\\d]{0,14})?$".toRegex())).not() ||
                (userId.length in 1..15).not()
            ) {
                keyboardController.hide()
                isShowAlert = true
                alert {
                    AlertScreen(
                        isShowAlert = isShowAlert,
                        text = "아이디를 확인해주세요",
                        buttonText = "확인"
                    ) {
                        isShowAlert = false
                        keyboardController.show()
                    }
                }
            } else if (nickname.isBlank() || (nickname.length in 1..15).not()) {
                keyboardController.hide()
                isShowAlert = true
                alert {
                    AlertScreen(
                        isShowAlert = isShowAlert,
                        text = "닉네임을 확인해주세요.",
                        buttonText = "확인"
                    ) {
                        isShowAlert = false
                        keyboardController.show()
                    }
                }
            } else if (email.isBlank() ||
                (
                    email.matches(
                            "^[a-zA-Z0-9+-_.]+@[a-zA-Z0-9-]+\\.[a-zA-Z0-9-.]+\$".toRegex()
                        ).not()
                    )
            ) {
                keyboardController.hide()
                isShowAlert = true
                alert {
                    AlertScreen(
                        isShowAlert = isShowAlert,
                        text = "이메일을 확인해주세요.",
                        buttonText = "확인"
                    ) {
                        isShowAlert = false
                        keyboardController.show()
                    }
                }
            } else {
                viewModel.checkDuplicateEmail(it)
            }
        },
        showId = {
            if ((nickname.length in 1..15).not()) {
                keyboardController.hide()
                isShowAlert = true
                alert {
                    AlertScreen(
                        isShowAlert = isShowAlert,
                        text = "닉네임는 1자에서 15자 사이로 \n입력 가능해요.",
                        buttonText = "확인"
                    ) {
                        isShowAlert = false
                        keyboardController.show()
                    }
                }
            } else {
                isShowId = true
            }
        },
        showEmail = {
            if ((userId.length in 1..15).not()) {
                keyboardController.hide()
                isShowAlert = true
                alert {
                    AlertScreen(
                        isShowAlert = isShowAlert,
                        text = "아이디는 1자에서 15자 사이로 \n입력할 수 있어요.",
                        buttonText = "확인"
                    ) {
                        isShowAlert = false
                        keyboardController.show()
                    }
                }
            } else if ((userId.matches("^[a-zA-Z](?:[a-zA-Z\\d]{0,14})?$".toRegex())).not()) {
                keyboardController.hide()
                isShowAlert = true
                alert {
                    AlertScreen(
                        isShowAlert = isShowAlert,
                        text = "아이디는 영문이나 숫자로만 \n입력할 수 있어요.",
                        buttonText = "확인"
                    ) {
                        isShowAlert = false
                        keyboardController.show()
                    }
                }
            } else {
                viewModel.checkDuplicateUser(userId)
            }
        },
        signupState = signupState
    )
}

@OptIn(ExperimentalComposeUiApi::class)
@Composable
internal fun SignupScreen(
    modifier: Modifier = Modifier,
    onBackClick: () -> Unit,
    isShowId: Boolean,
    isShowEmail: Boolean,
    nickname: String,
    userId: String,
    email: String,
    onUserIdChange: (String) -> Unit,
    onNicknameChange: (String) -> Unit,
    onEmailChange: (String) -> Unit,
    onClickUserIdCancel: () -> Unit,
    onClickEmailCancel: () -> Unit,
    onClickNicknameCancel: () -> Unit,
    keyboardController: SoftwareKeyboardController,
    onClickEmailButton: (String) -> Unit,
    showEmail: () -> Unit,
    showId: () -> @Composable Unit,
    signupState: SignupState
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
                text = if (isShowEmail) "이메일을\n입력해주세요" else if (isShowId) "아이디를\n입력해주세요" else "닉네임을\n입력해주세요",
                color = Color.White,
                fontSize = 24.sp,
                fontWeight = FontWeight.Bold,
                fontFamily = pretendard
            )

            Spacer(modifier = modifier.height(60.dp))

            if (isShowEmail) {
                ToongetherTextField(
                    modifier = modifier
                        .fillMaxWidth(),
                    text = email,
                    onTextChange = onEmailChange,
                    label = "이메일",
                    placeholder = "toonie@toongether.kr",
                    keyboardOptions = KeyboardOptions(imeAction = ImeAction.Done),
                    keyboardActions = KeyboardActions(onDone = { keyboardController.hide() }),
                    trailingIcon = {
                        IconButton(
                            modifier = modifier
                                .padding(top = 10.dp, end = 10.dp)
                                .size(24.dp),
                            onClick = onClickEmailCancel
                        ) {
                            Icon(
                                modifier = modifier.size(18.dp),
                                imageVector = ToongetherIcons.Cancel,
                                contentDescription = null,
                                tint = Gray60
                            )
                        }
                    }
                )

                Spacer(modifier = modifier.height(20.dp))
            }

            if (isShowId) {
                ToongetherTextField(
                    modifier = modifier
                        .fillMaxWidth(),
                    text = userId,
                    onTextChange = onUserIdChange,
                    label = "아이디",
                    placeholder = "toonie",
                    keyboardOptions = KeyboardOptions(imeAction = ImeAction.Next),
                    keyboardActions = KeyboardActions(onNext = { showEmail.invoke() }),
                    trailingIcon = {
                        IconButton(
                            modifier = modifier
                                .padding(top = 10.dp, end = 10.dp)
                                .size(24.dp),
                            onClick = onClickUserIdCancel
                        ) {
                            Icon(
                                modifier = modifier.size(18.dp),
                                imageVector = ToongetherIcons.Cancel,
                                contentDescription = null,
                                tint = Gray60
                            )
                        }
                    }
                )

                Spacer(modifier = modifier.height(20.dp))
            }

            ToongetherTextField(
                modifier = modifier
                    .fillMaxWidth(),
                text = nickname,
                onTextChange = onNicknameChange,
                label = "닉네임",
                placeholder = "투니",
                keyboardOptions = KeyboardOptions(imeAction = ImeAction.Next),
                keyboardActions = KeyboardActions(onNext = { showId.invoke() }),
                trailingIcon = {
                    IconButton(
                        modifier = modifier
                            .padding(top = 10.dp, end = 10.dp)
                            .size(24.dp),
                        onClick = onClickNicknameCancel
                    ) {
                        Icon(
                            modifier = modifier.size(18.dp),
                            imageVector = ToongetherIcons.Cancel,
                            contentDescription = null,
                            tint = Gray60
                        )
                    }
                }
            )
        }
        if (isShowEmail && isShowId) {
            ToongetherButton(
                modifier = modifier
                    .fillMaxWidth()
                    .align(Alignment.BottomCenter)
                    .navigationBarsPadding()
                    .padding(bottom = 24.dp)
                    .padding(horizontal = 16.dp),
                onClick = { onClickEmailButton(email) },
                color = if (userId.isNotBlank() && nickname.isNotBlank() && email.isNotBlank() &&
                    email.matches("^[a-zA-Z0-9+-_.]+@[a-zA-Z0-9-]+\\.[a-zA-Z0-9-.]+\$".toRegex())
                ) {
                    Blue60
                } else {
                    Blue80
                }
            ) {
                Text(
                    text = "이메일 인증하기",
                    fontWeight = FontWeight.SemiBold,
                    fontFamily = pretendard,
                    color = Color.White,
                    fontSize = 18.sp
                )
            }
        }

        if (isShowEmail.not()) {
            if (WindowInsets.ime.getBottom(LocalDensity.current) > 0) {
                ToongetherButton(
                    modifier = modifier
                        .fillMaxWidth()
                        .align(Alignment.BottomCenter)
                        .navigationBarsPadding()
                        .imePadding(),
                    onClick = if (isShowId.not()) showId else showEmail,
                    color = if (isShowId) {
                        if (userId.length in 1..15 && userId.matches("^[a-zA-Z](?:[a-zA-Z\\d]{0,14})?$".toRegex())) {
                            Blue60
                        } else {
                            Blue80
                        }
                    } else {
                        if (nickname.length in 1..15) Blue60 else Blue80
                    },
                    shape = RoundedCornerShape(0)
                ) {
                    Text(
                        text = "다음",
                        fontWeight = FontWeight.SemiBold,
                        fontFamily = pretendard,
                        color = Color.White,
                        fontSize = 18.sp
                    )
                }
            }
        }

        if (signupState.isLoading) {
            LoadingScreen()
        }
    }
}
