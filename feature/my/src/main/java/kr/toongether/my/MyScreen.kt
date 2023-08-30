package kr.toongether.my

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import kr.toongether.designsystem.component.ToongetherTopAppBar
import kr.toongether.designsystem.utils.NoRippleInteractionSource
import kr.toongether.login.navigation.navigateToLogin

@Composable
internal fun MyRoute(
    modifier: Modifier = Modifier,
    navController: NavController,
    viewModel: MyViewModel = hiltViewModel()
) {
    val tokenState by viewModel.tokenState.collectAsState()

    MyScreen(
        modifier = modifier,
        onClickLogin = navController::navigateToLogin,
        isLogin = tokenState.accessToken.isNotBlank()
    )
}

@Composable
internal fun MyScreen(
    modifier: Modifier = Modifier,
    onClickLogin: () -> Unit,
    isLogin: Boolean
) {
    Surface(
        modifier = modifier
            .fillMaxSize(),
        color = Color.Black
    ) {
        Box(
            modifier = modifier
                .fillMaxSize()
        ) {
            Column {
                ToongetherTopAppBar(
                    title = if (isLogin) "독자님 안녕하세요" else "로그인이 필요해요",
                    modifier = modifier
                        .clickable(
                            interactionSource = NoRippleInteractionSource(),
                            indication = null,
                            onClick = onClickLogin,
                            enabled = isLogin.not()
                        )
                )

//                ToongetherScrollableTabRow(
//                    tabs = MyGenre.values().toList().map { it.title },
// //                selectedTabIndex = pagerState.currentPage,
//                    selectedTabIndex = 0,
//                    onTabClick = { tabIndex ->
//                    }
//                )
            }
        }
    }
}
