package kr.toongether.my

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import kr.toongether.designsystem.component.ToongetherButton
import kr.toongether.designsystem.component.ToongetherTopAppBar
import kr.toongether.designsystem.theme.pretendard
import kr.toongether.login.navigation.navigateToLogin

@Composable
internal fun MyRoute(
    modifier: Modifier = Modifier,
    navController: NavController,
) {
    MyScreen(
        modifier = modifier,
        navController = navController
    )
}

@Composable
internal fun MyScreen(
    modifier: Modifier = Modifier,
    navController: NavController,
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
            ToongetherTopAppBar(
                title = "마이 페이지",
                subTitle = "준비 중"
            )

            Column(
                modifier = modifier
                    .align(Alignment.Center),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Text(
                    text = "아직 사용할 수 없어요.",
                    fontFamily = pretendard,
                    fontWeight = FontWeight.Bold,
                    fontSize = 16.sp,
                    color = Color.White
                )

                Spacer(modifier = modifier.size(10.dp))

                ToongetherButton(
                    color = Color.White,
                    onClick = {
                        navController.navigateToLogin()
                    }
                ) {
                    Text(
                        text = "로그인",
                        fontFamily = pretendard,
                        fontWeight = FontWeight.Bold,
                        fontSize = 16.sp,
                        color = Color.Black
                    )
                }
            }
        }
    }
}
