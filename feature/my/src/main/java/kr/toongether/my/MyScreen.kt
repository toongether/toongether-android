package kr.toongether.my

import android.util.Log
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import kr.toongether.designsystem.component.ToongetherButton
import kr.toongether.designsystem.component.ToongetherScrollableTabRow
import kr.toongether.designsystem.component.ToongetherTopAppBar
import kr.toongether.designsystem.icon.ToongetherIcons
import kr.toongether.designsystem.icon.icons.Setting
import kr.toongether.designsystem.theme.Shape
import kr.toongether.designsystem.theme.pretendard
import kr.toongether.login.navigation.navigateToLogin
import kr.toongether.my.navigation.navigateToSetting
import kr.toongether.ui.LoadingScreen
import org.orbitmvi.orbit.compose.collectAsState
import org.orbitmvi.orbit.compose.collectSideEffect

@Composable
internal fun MyRoute(
    modifier: Modifier = Modifier,
    navController: NavController,
    viewModel: MyViewModel = hiltViewModel()
) {
    val accessToken by viewModel.accessToken.collectAsState()
    val state by viewModel.collectAsState()

    viewModel.collectSideEffect {
        when (it) {
            is MySideEffect.Toast -> Log.d("TOAST", it.text)
            else -> {}
        }
    }

    LaunchedEffect(accessToken) {
        if (accessToken.isNotBlank()) {
            viewModel.getUser()
        }
    }

    MyScreen(
        modifier = modifier,
        onClickLogin = navController::navigateToLogin,
        isLogin = accessToken.isNotBlank(),
        onClickSetting = navController::navigateToSetting,
        userName = state.userInfo.name,
        isLoading = state.isLoading
    )
}

@Composable
internal fun MyScreen(
    modifier: Modifier = Modifier,
    onClickLogin: () -> Unit,
    onClickSetting: () -> Unit,
    isLogin: Boolean,
    userName: String,
    isLoading: Boolean
) {
    if (isLoading) {
        LoadingScreen()
    } else {
        if (isLogin.not()) {
            Box(
                modifier = modifier
                    .fillMaxSize()
                    .background(Color.Black)
                    .statusBarsPadding()
            ) {
                ToongetherTopAppBar(
                    title = "로그인이 필요해요",
                    actionIcon = ToongetherIcons.Setting,
                    actionIconContentDescription = null,
                    onActionClick = onClickSetting
                )
                ToongetherButton(
                    modifier = modifier.align(Alignment.Center),
                    onClick = onClickLogin,
                    contentPadding = PaddingValues(horizontal = 48.dp, vertical = 12.dp),
                    color = Color.White,
                    shape = Shape.medium
                ) {
                    Text(
                        text = "로그인하기",
                        fontWeight = FontWeight.Bold,
                        fontSize = 16.sp,
                        fontFamily = pretendard,
                        color = Color.Black
                    )
                }
            }
        } else {
            Column(
                modifier = modifier
                    .fillMaxSize()
                    .background(Color.Black)
                    .statusBarsPadding()
            ) {
                ToongetherTopAppBar(
                    title = "$userName 독자님",
                    actionIcon = ToongetherIcons.Setting,
                    actionIconContentDescription = null,
                    onActionClick = onClickSetting
                )

                /* ToongetherScrollableTabRow(
                    tabs = listOf("최근 본 웹툰"),
                    selectedTabIndex = 0,
                    onTabClick = { }
                ) */
            }
        }
    }
}
