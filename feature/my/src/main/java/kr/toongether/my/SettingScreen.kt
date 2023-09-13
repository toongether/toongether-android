package kr.toongether.my

import android.content.Intent
import android.net.Uri
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import kr.toongether.designsystem.component.ToongetherCard
import kr.toongether.designsystem.component.ToongetherTopAppBarWithBack
import kr.toongether.designsystem.icon.ToongetherIcons
import kr.toongether.designsystem.icon.icons.RightArrow
import kr.toongether.designsystem.theme.Red
import kr.toongether.login.navigation.navigateToLogin

@Composable
internal fun SettingRoute(
    modifier: Modifier = Modifier,
    navController: NavController,
    viewModel: MyViewModel = hiltViewModel()
) {
    val context = LocalContext.current
    val accessToken by viewModel.accessToken.collectAsState()

    SettingScreen(
        modifier = modifier,
        onClickBack = navController::popBackStack,
        onClickPrivacy = {
            context.startActivity(
                Intent(
                    Intent.ACTION_VIEW,
                    Uri.parse("https://go.toongether.kr/privacy")
                )
            )
        },
        isLogin = accessToken.isNotBlank(),
        onClickLogout = {
            viewModel.deleteToken()
            navController.popBackStack()
        },
        onClickQuit = { /* TODO : 회원 탈퇴 구현하기 */ },
        onClickLogin = navController::navigateToLogin
    )
}

@Composable
private fun SettingScreen(
    modifier: Modifier = Modifier,
    onClickBack: () -> Unit,
    onClickPrivacy: () -> Unit,
    isLogin: Boolean,
    onClickLogout: () -> Unit,
    onClickQuit: () -> Unit,
    onClickLogin: () -> Unit
) {
    Column(
        modifier = modifier
            .fillMaxSize()
            .statusBarsPadding()
            .background(Color.Black)
    ) {
        ToongetherTopAppBarWithBack(
            title = "툰게더 설정",
            onClickBack = onClickBack
        )

        Spacer(modifier = modifier.height(12.dp))

        ToongetherCard(
            title = "개인정보 처리방침",
            icon = ToongetherIcons.RightArrow,
            onClick = onClickPrivacy
        )

        Spacer(modifier = modifier.height(8.dp))

        if (isLogin) {
            ToongetherCard(
                title = "로그아웃",
                icon = ToongetherIcons.RightArrow,
                onClick = onClickLogout
            )

            Spacer(modifier = modifier.height(8.dp))

            ToongetherCard(
                title = "회원탈퇴",
                titleColor = Red,
                icon = ToongetherIcons.RightArrow,
                onClick = onClickQuit
            )
        } else {
            ToongetherCard(
                title = "로그인",
                icon = ToongetherIcons.RightArrow,
                onClick = onClickLogin
            )
        }
    }
}
