//package kr.toongether.signup
//
//import android.os.CountDownTimer
//import androidx.compose.foundation.background
//import androidx.compose.foundation.clickable
//import androidx.compose.foundation.layout.Box
//import androidx.compose.foundation.layout.Column
//import androidx.compose.foundation.layout.Spacer
//import androidx.compose.foundation.layout.fillMaxSize
//import androidx.compose.foundation.layout.fillMaxWidth
//import androidx.compose.foundation.layout.height
//import androidx.compose.foundation.layout.imePadding
//import androidx.compose.foundation.layout.navigationBarsPadding
//import androidx.compose.foundation.layout.padding
//import androidx.compose.foundation.layout.statusBarsPadding
//import androidx.compose.foundation.text.KeyboardActions
//import androidx.compose.foundation.text.KeyboardOptions
//import androidx.compose.material.IconButton
//import androidx.compose.material3.Icon
//import androidx.compose.material3.Text
//import androidx.compose.runtime.Composable
//import androidx.compose.runtime.LaunchedEffect
//import androidx.compose.runtime.getValue
//import androidx.compose.runtime.mutableStateOf
//import androidx.compose.runtime.remember
//import androidx.compose.runtime.setValue
//import androidx.compose.ui.Alignment
//import androidx.compose.ui.ExperimentalComposeUiApi
//import androidx.compose.ui.Modifier
//import androidx.compose.ui.focus.FocusDirection
//import androidx.compose.ui.graphics.Color
//import androidx.compose.ui.platform.LocalFocusManager
//import androidx.compose.ui.platform.LocalSoftwareKeyboardController
//import androidx.compose.ui.platform.SoftwareKeyboardController
//import androidx.compose.ui.text.font.FontWeight
//import androidx.compose.ui.text.input.ImeAction
//import androidx.compose.ui.text.input.KeyboardType
//import androidx.compose.ui.unit.dp
//import androidx.compose.ui.unit.sp
//import androidx.hilt.navigation.compose.hiltViewModel
//import androidx.navigation.NavController
//import kr.toongether.designsystem.component.ToongetherButton
//import kr.toongether.designsystem.component.ToongetherTextField
//import kr.toongether.designsystem.icon.ToongetherIcons
//import kr.toongether.designsystem.icon.icons.Back
//import kr.toongether.designsystem.theme.Blue60
//import kr.toongether.designsystem.theme.Blue80
//import kr.toongether.designsystem.theme.Gray60
//import kr.toongether.designsystem.theme.pretendard
//import kr.toongether.signup.navigation.navigateToInputPassword
//import kr.toongether.ui.AlertScreen
//import kr.toongether.ui.LoadingScreen
//import org.orbitmvi.orbit.compose.collectAsState
//import org.orbitmvi.orbit.compose.collectSideEffect
//
//@OptIn(ExperimentalComposeUiApi::class)
//@Composable
//fun CheckEmailRoute(
//    modifier: Modifier = Modifier,
//    navController: NavController,
//    email: String,
//    name: String,
//    userId: String,
//    viewModel: SignupViewModel = hiltViewModel(),
//    alert: (@Composable () -> Unit) -> Unit
//) {
//    val state by viewModel.collectAsState()
//
//    var isShowAlert by remember { mutableStateOf(false) }
//
//    val keyboardController = LocalSoftwareKeyboardController.current!!
//    val focusManager = LocalFocusManager.current
//
//    var code by remember { mutableStateOf("") }
//    var timer by remember { mutableStateOf("") }
//
//    val countDown by remember {
//        mutableStateOf(
//            object : CountDownTimer(300_000, 1000) {
//                override fun onTick(millisUntilFinished: Long) {
//                    timer = "%02d : %02d".format(
//                        (millisUntilFinished.toFloat() / 1000 / 60).toInt(),
//                        (millisUntilFinished.toFloat() / 1000 % 60).toInt()
//                    )
//                }
//
//                override fun onFinish() {
//                    timer = "00 : 00"
//                }
//            }
//        )
//    }
//
//    viewModel.collectSideEffect {
//        when (it) {
//            is SignupSideEffect.NavigateToInputPassword -> {
//                navController.navigateToInputPassword(
//                    code = code,
//                    email = email,
//                    name = name,
//                    userId = userId
//                )
//            }
//            is SignupSideEffect.Toast -> {
//                keyboardController.hide()
//                isShowAlert = true
//                alert {
//                    AlertScreen(
//                        isShowAlert = isShowAlert,
//                        text = it.text,
//                        buttonText = "확인"
//                    ) {
//                        isShowAlert = false
//                        keyboardController.show()
//                    }
//                }
//            }
//            else -> {}
//        }
//    }
//
//    LaunchedEffect(Unit) {
//        countDown.start()
//        focusManager.moveFocus(FocusDirection.Enter)
//    }
//
//    CheckEmailScreen(
//        modifier = modifier,
//        onBackClick = navController::popBackStack,
//        code = code,
//        onTextChange = {
//            if (it.length <= 6) code = it
//        },
//        keyboardController = keyboardController,
//        timer = timer,
//        onClickCheckButton = { viewModel.checkEmail(email, it) },
//        onClickRefresh = {
//            countDown.cancel()
//            countDown.start()
//            viewModel.sendEmail(email)
//        },
//        state = state
//    )
//}
//
//@OptIn(ExperimentalComposeUiApi::class)
//@Composable
//internal fun CheckEmailScreen(
//    modifier: Modifier = Modifier,
//    onBackClick: () -> Unit,
//    code: String,
//    timer: String,
//    onTextChange: (String) -> Unit,
//    keyboardController: SoftwareKeyboardController,
//    onClickCheckButton: (String) -> Unit,
//    onClickRefresh: () -> Unit,
//    state: SignupState
//) {
//    Box(
//        modifier
//            .fillMaxSize()
//            .background(Color.Black)
//    ) {
//        Column {
//            Spacer(modifier = modifier.statusBarsPadding())
//
//            IconButton(
//                onClick = onBackClick
//            ) {
//                Icon(
//                    imageVector = ToongetherIcons.Back,
//                    contentDescription = null,
//                    tint = Color.White
//                )
//            }
//
//            Spacer(modifier = modifier.height(20.dp))
//
//            Text(
//                modifier = modifier.padding(horizontal = 16.dp),
//                text = "인증번호 6자리를\n입력해주세요",
//                color = Color.White,
//                fontSize = 24.sp,
//                fontWeight = FontWeight.Bold,
//                fontFamily = pretendard
//            )
//
//            Spacer(modifier = modifier.height(60.dp))
//
//            Box {
//                ToongetherTextField(
//                    modifier = modifier
//                        .fillMaxWidth(),
//                    text = code,
//                    onTextChange = onTextChange,
//                    placeholder = "인증번호 6자리",
//                    keyboardOptions = KeyboardOptions.Default.copy(
//                        keyboardType = KeyboardType.Number,
//                        imeAction = ImeAction.Done
//                    ),
//                    keyboardActions = KeyboardActions(onDone = { keyboardController.hide() })
//                )
//                Text(
//                    modifier = modifier
//                        .align(Alignment.BottomEnd)
//                        .padding(end = 16.dp, bottom = 5.dp),
//                    text = timer,
//                    fontSize = 20.sp,
//                    fontFamily = pretendard,
//                    fontWeight = FontWeight.Normal,
//                    color = Gray60
//                )
//            }
//
//            Spacer(modifier = modifier.height(10.dp))
//
//            Text(
//                modifier = modifier
//                    .padding(start = 16.dp)
//                    .clickable { onClickRefresh.invoke() },
//                text = "인증번호 다시 받기",
//                fontWeight = FontWeight.Normal,
//                color = Gray60,
//                fontFamily = pretendard,
//                fontSize = 14.sp
//            )
//        }
//
//        ToongetherButton(
//            modifier = modifier
//                .fillMaxWidth()
//                .align(Alignment.BottomCenter)
//                .navigationBarsPadding()
//                .imePadding()
//                .padding(bottom = 24.dp)
//                .padding(horizontal = 16.dp),
//            onClick = { onClickCheckButton(code) },
//            color = if (code.isBlank() || code.length < 6) Blue80 else Blue60
//        ) {
//            Text(
//                text = "인증하기",
//                fontWeight = FontWeight.SemiBold,
//                fontFamily = pretendard,
//                color = Color.White,
//                fontSize = 18.sp
//            )
//        }
//
//        if (state.isLoading) {
//            LoadingScreen()
//        }
//    }
//}
