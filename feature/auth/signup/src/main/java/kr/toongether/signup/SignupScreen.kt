package kr.toongether.signup

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.navigationBarsPadding
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.foundation.text.KeyboardActionScope
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.IconButton
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
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalSoftwareKeyboardController
import androidx.compose.ui.platform.SoftwareKeyboardController
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
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

@OptIn(ExperimentalComposeUiApi::class)
@Composable
fun SignupRoute(
    modifier: Modifier = Modifier,
    navController: NavController
) {
    var isShowId by remember { mutableStateOf(false) }
    var isShowEmail by remember { mutableStateOf(false) }

    var nickname by remember { mutableStateOf("") }
    var userId by remember { mutableStateOf("") }
    var email by remember { mutableStateOf("") }

    val keyboardController = LocalSoftwareKeyboardController.current!!

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
        onClickEmailButton = navController::navigateToCheckEmail,
        showId = { isShowId = true },
        showEmail = { isShowEmail = true },
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
    onClickEmailButton: () -> Unit,
    showEmail: KeyboardActionScope.() -> Unit,
    showId: KeyboardActionScope.() -> Unit,
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
                text = if (isShowId) "아이디를\n입력해주세요" else if (isShowEmail) "이메일을\n입력해주세요" else "닉네임을\n입력해주세요",
                color = Color.White,
                fontSize = 24.sp,
                fontWeight = FontWeight.Bold,
                fontFamily = pretendard
            )

            Spacer(modifier = modifier.height(60.dp))

            if (isShowEmail) {
                ToongetherTextField(
                    modifier = modifier.fillMaxWidth(),
                    text = email,
                    onTextChange = onEmailChange,
                    label = "이메일",
                    placeholder = "example@toongether.kr",
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
                    placeholder = "example",
                    keyboardOptions = KeyboardOptions(imeAction = ImeAction.Next),
                    keyboardActions = KeyboardActions(onNext = showEmail),
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
                placeholder = "홍길동",
                keyboardOptions = KeyboardOptions(imeAction = ImeAction.Next),
                keyboardActions = KeyboardActions(onNext = showId),
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

        ToongetherButton(
            modifier = modifier
                .fillMaxWidth()
                .align(Alignment.BottomCenter)
                .navigationBarsPadding()
                .padding(bottom = 24.dp)
                .padding(horizontal = 16.dp),
            onClick = onClickEmailButton,
            color = if (userId.isNotBlank() && nickname.isNotBlank() && email.isNotBlank()) Blue60 else Blue80
        ) {
            Text(
                text = if (isShowEmail && isShowId) "이메일 인증하기" else "다음",
                fontWeight = FontWeight.SemiBold,
                fontFamily = pretendard,
                color = Color.White,
                fontSize = 18.sp
            )
        }
    }
}
