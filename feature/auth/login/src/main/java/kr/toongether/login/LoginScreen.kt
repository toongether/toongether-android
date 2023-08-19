package kr.toongether.login

import android.util.Log
import android.widget.Toast
import androidx.compose.foundation.background
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
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
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
import kr.toongether.designsystem.component.ToongetherButton
import kr.toongether.designsystem.component.ToongetherTextField
import kr.toongether.designsystem.icon.ToongetherIcons
import kr.toongether.designsystem.icon.icons.Back
import kr.toongether.designsystem.icon.icons.Cancel
import kr.toongether.designsystem.theme.Blue60
import kr.toongether.designsystem.theme.Blue80
import kr.toongether.designsystem.theme.Gray60
import kr.toongether.designsystem.theme.pretendard
import org.orbitmvi.orbit.compose.collectAsState
import org.orbitmvi.orbit.compose.collectSideEffect

@OptIn(ExperimentalComposeUiApi::class)
@Composable
internal fun LoginRoute(
    modifier: Modifier = Modifier,
    navController: NavController,
    viewModel: LoginViewModel = hiltViewModel()
) {
    var userId by remember { mutableStateOf("") }
    var password by remember { mutableStateOf("") }
    var showPassword by remember { mutableStateOf(false) }
    val keyboardController = LocalSoftwareKeyboardController.current!!
    val context = LocalContext.current

    val state by viewModel.collectAsState()

    viewModel.collectSideEffect {
        when (it) {
            is LoginSideEffect.Toast -> {
                Toast.makeText(context, it.text, Toast.LENGTH_SHORT).show()
                Log.d("ERROR", "LoginRoute: ${state.error?.message}")
            }
        }
    }

    LoginScreen(
        modifier = modifier,
        onBackClick = navController::popBackStack,
        onClickLogin = viewModel::login,
        userId = userId,
        password = password,
        showPassword = showPassword,
        keyboardController = keyboardController,
        onClickUserIdCancel = { userId = "" },
        onPasswordChange = { password = it },
        onUserIdChange = { userId = it },
        onClickShowPassword = { showPassword = !showPassword },
        onClickPasswordCancel = { password = "" }
    )
}

@OptIn(ExperimentalComposeUiApi::class)
@Composable
internal fun LoginScreen(
    modifier: Modifier = Modifier,
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
    onClickPasswordCancel: () -> Unit
) {
    Column(
        modifier = modifier
            .fillMaxSize()
            .background(Color.Black)
    ) {
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
            text = "로그인해주세요",
            color = Color.White,
            fontSize = 24.sp,
            fontWeight = FontWeight.Bold,
            fontFamily = pretendard
        )

        Spacer(modifier = modifier.height(60.dp))

        ToongetherTextField(
            modifier = modifier.fillMaxWidth(),
            text = userId,
            onTextChange = onUserIdChange,
            label = "아이디 또는 이메일",
            placeholder = "example@toongether.kr",
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
                        imageVector = ToongetherIcons.Cancel,
                        contentDescription = null,
                        tint = Gray60
                    )
                }
            }
        )

        Spacer(modifier = modifier.height(20.dp))

        ToongetherTextField(
            modifier = modifier
                .fillMaxWidth(),
            text = password,
            onTextChange = onPasswordChange,
            label = "비밀번호",
            placeholder = "example1234!",
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

        Spacer(modifier = modifier.height(40.dp))

        ToongetherButton(
            modifier = modifier
                .fillMaxWidth()
                .padding(horizontal = 16.dp),
            onClick = { onClickLogin(userId, password) },
            color = if (userId.isNotBlank() && password.isNotBlank()) Blue60 else Blue80
        ) {
            Text(
                text = "로그인",
                fontWeight = FontWeight.SemiBold,
                fontFamily = pretendard,
                color = Color.White,
                fontSize = 18.sp
            )
        }

        Spacer(modifier = modifier.height(16.dp))

        /*Text(
            modifier = modifier.align(Alignment.CenterHorizontally),
            text = "비밀번호가 기억나지 않나요?",
            fontWeight = FontWeight.Normal,
            fontFamily = pretendard,
            color = Gray60,
            fontSize = 14.sp
        )*/
    }
}
