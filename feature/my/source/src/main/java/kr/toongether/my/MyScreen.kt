package kr.toongether.my

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.hilt.navigation.compose.hiltViewModel
import kr.toongether.designsystem.theme.ToongetherColors

@Composable
internal fun MyRoute(
    modifier: Modifier = Modifier,
    viewModel: MyViewModel = hiltViewModel()
) {
    Box(modifier = Modifier.fillMaxSize().background(ToongetherColors.BackgroundNormal))
//    val accessToken by viewModel.accessToken.collectAsState()
//    val state by viewModel.collectAsState()
//
//    viewModel.collectSideEffect {
//        when (it) {
//            is MySideEffect.Toast -> Log.d("TOAST", it.text)
//            else -> {}
//        }
//    }
//
//    LaunchedEffect(accessToken) {
//        if (accessToken.isNotBlank()) {
//            viewModel.getUser()
//        }
//    }
//
//    MyScreen(
//        modifier = modifier,
//        onClickLogin = navController::navigateToLogin,
//        isLogin = accessToken.isNotBlank(),
//        onClickSetting = navController::navigateToSetting,
//        userName = state.userInfo.name,
//        isLoading = state.isLoading
//    )
}
/*

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

                */
/* ToongetherScrollableTabRow(
                    tabs = listOf("최근 본 웹툰"),
                    selectedTabIndex = 0,
                    onTabClick = { }
                ) *//*

            }
        }
    }
}
*/
