//package kr.toongether.my
//
//import android.content.Intent
//import android.net.Uri
//import androidx.compose.foundation.background
//import androidx.compose.foundation.layout.Column
//import androidx.compose.foundation.layout.Spacer
//import androidx.compose.foundation.layout.fillMaxSize
//import androidx.compose.foundation.layout.height
//import androidx.compose.foundation.layout.statusBarsPadding
//import androidx.compose.runtime.Composable
//import androidx.compose.runtime.collectAsState
//import androidx.compose.runtime.getValue
//import androidx.compose.runtime.mutableStateOf
//import androidx.compose.runtime.remember
//import androidx.compose.runtime.setValue
//import androidx.compose.ui.Modifier
//import androidx.compose.ui.graphics.Color
//import androidx.compose.ui.platform.LocalContext
//import androidx.compose.ui.unit.dp
//import androidx.hilt.navigation.compose.hiltViewModel
//import androidx.navigation.NavController
//import kr.toongether.designsystem.component.ToongetherCard
//import kr.toongether.designsystem.component.ToongetherTopAppBarWithBack
//import kr.toongether.designsystem.icon.ToongetherIcons
//import kr.toongether.designsystem.icon.icons.RightArrow
//import kr.toongether.designsystem.theme.Red
//import kr.toongether.login.navigation.navigateToLogin
//import kr.toongether.my.navigation.navigateToQuitAccount
//import kr.toongether.ui.AlertScreen
//
//@Composable
//internal fun SettingRoute(
//    modifier: Modifier = Modifier,
//    navController: NavController,
//    viewModel: MyViewModel = hiltViewModel(),
//    alert: (@Composable () -> Unit) -> Unit
//) {
//    val context = LocalContext.current
//    val accessToken by viewModel.accessToken.collectAsState()
//
//    var isShowAlert by remember { mutableStateOf(false) }
//
//    SettingScreen(
//        modifier = modifier,
//        onClickBack = navController::popBackStack,
//        onClickPrivacy = {
//            context.startActivity(
//                Intent(
//                    Intent.ACTION_VIEW,
//                    Uri.parse("https://go.toongether.kr/privacy")
//                )
//            )
//        },
//        isLogin = accessToken.isNotBlank(),
//        onClickLogout = {
//            isShowAlert = true
//            alert {
//                AlertScreen(
//                    isShowAlert = isShowAlert,
//                    text = "로그아웃 하시겠어요?",
//                    firstButtonText = "로그아웃",
//                    onClickFirstButton = {
//                        isShowAlert = false
//                        viewModel.deleteToken()
//                        navController.popBackStack()
//                    },
//                    secondButtonText = "취소",
//                    onClickSecondButton = { isShowAlert = false }
//                )
//            }
//        },
//        onClickQuit = navController::navigateToQuitAccount,
//        onClickLogin = navController::navigateToLogin
//    )
//}
//
//@Composable
//private fun SettingScreen(
//    modifier: Modifier = Modifier,
//    onClickBack: () -> Unit,
//    onClickPrivacy: () -> Unit,
//    isLogin: Boolean,
//    onClickLogout: () -> Unit,
//    onClickQuit: () -> Unit,
//    onClickLogin: () -> Unit
//) {
//    Column(
//        modifier = modifier
//            .fillMaxSize()
//            .statusBarsPadding()
//            .background(Color.Black)
//    ) {
//        ToongetherTopAppBarWithBack(
//            title = "툰게더 설정",
//            onClickBack = onClickBack
//        )
//
//        Spacer(modifier = modifier.height(12.dp))
//
//        ToongetherCard(
//            title = "개인정보 처리방침",
//            icon = ToongetherIcons.RightArrow,
//            onClick = onClickPrivacy,
//            iconTint = Color.White
//        )
//
//        Spacer(modifier = modifier.height(8.dp))
//
//        if (isLogin) {
//            ToongetherCard(
//                title = "로그아웃",
//                icon = ToongetherIcons.RightArrow,
//                onClick = onClickLogout,
//                iconTint = Color.White
//            )
//
//            Spacer(modifier = modifier.height(8.dp))
//
//            ToongetherCard(
//                title = "회원탈퇴",
//                titleColor = Red,
//                icon = ToongetherIcons.RightArrow,
//                onClick = onClickQuit,
//                iconTint = Color.White
//            )
//        } else {
//            ToongetherCard(
//                title = "로그인",
//                icon = ToongetherIcons.RightArrow,
//                onClick = onClickLogin,
//                iconTint = Color.White
//            )
//        }
//    }
//}
