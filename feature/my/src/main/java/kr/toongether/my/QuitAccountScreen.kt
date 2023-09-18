package kr.toongether.my

import android.content.Intent
import android.net.Uri
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.navigationBarsPadding
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.material.IconButton
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import androidx.navigation.navOptions
import kr.toongether.designsystem.component.ToongetherCard
import kr.toongether.designsystem.component.ToongetherLargeButton
import kr.toongether.designsystem.icon.ToongetherIcons
import kr.toongether.designsystem.icon.icons.Back
import kr.toongether.designsystem.icon.icons.RightArrow
import kr.toongether.designsystem.theme.Red
import kr.toongether.designsystem.theme.pretendard
import kr.toongether.my.navigation.navigateToMy
import kr.toongether.ui.AlertScreen
import org.orbitmvi.orbit.compose.collectSideEffect

@Composable
internal fun QuitAccountRoute(
    modifier: Modifier = Modifier,
    navController: NavController,
    viewModel: MyViewModel = hiltViewModel(),
    alert: (@Composable () -> Unit) -> Unit
) {
    val context = LocalContext.current
    var isShowAlert by remember { mutableStateOf(false) }

    viewModel.collectSideEffect {
        when (it) {
            is MySideEffect.NavigateToMy -> {
                navController.navigateToMy(
                    navOptions {
                        this.popUpTo(kr.toongether.my.navigation.MyRoute) {
                            inclusive = true
                        }
                    }
                )
            }
            is MySideEffect.Toast -> {
                isShowAlert = true
                alert {
                    AlertScreen(
                        isShowAlert = isShowAlert,
                        text = it.text,
                        buttonText = "확인"
                    ) {
                        isShowAlert = false
                    }
                }
            }
            else -> {}
        }
    }

    QuitAccountScreen(
        modifier = modifier,
        onClickBack = navController::popBackStack,
        onClickQuitInfo = {
            context.startActivity(
                Intent(
                    Intent.ACTION_VIEW,
                    Uri.parse("https://go.toongether.kr/quit")
                )
            )
        },
        onClickButton = {
            isShowAlert = true
            alert {
                AlertScreen(
                    isShowAlert = isShowAlert,
                    text = "정말 탈퇴하실간가요?",
                    firstButtonText = "탈퇴하기",
                    firstButtonColor = Red,
                    onClickFirstButton = {
                        isShowAlert = false
                        viewModel.deleteUser()
                    },
                    secondButtonText = "취소",
                    onClickSecondButton = { isShowAlert = false }
                )
            }
        }
    )
}

@Composable
private fun QuitAccountScreen(
    modifier: Modifier = Modifier,
    onClickBack: () -> Unit,
    onClickQuitInfo: () -> Unit,
    onClickButton: () -> Unit
) {
    Box(
        modifier
            .fillMaxSize()
            .statusBarsPadding()
            .background(Color.Black)
    ) {
    }
    Column {
        Spacer(modifier = modifier.statusBarsPadding())

        IconButton(
            onClick = onClickBack
        ) {
            Icon(
                imageVector = ToongetherIcons.Back,
                contentDescription = null,
                tint = Color.White
            )
        }

        Spacer(modifier = modifier.height(16.dp))

        Text(
            modifier = modifier.padding(horizontal = 16.dp),
            text = "정말로\n탈퇴하실 건가요?",
            color = Color.White,
            fontSize = 24.sp,
            fontWeight = FontWeight.Bold,
            fontFamily = pretendard
        )

        Spacer(modifier = modifier.height(20.dp))

        ToongetherCard(
            title = "툰게더 회원탈퇴 안내",
            icon = ToongetherIcons.RightArrow,
            onClick = onClickQuitInfo,
            iconTint = Color.White
        )

        Spacer(modifier = modifier.weight(1f))

        ToongetherLargeButton(
            modifier = modifier.padding(horizontal = 12.dp),
            text = "탈퇴하기",
            color = Red,
            onClick = onClickButton
        )

        Spacer(
            modifier = modifier
                .navigationBarsPadding()
                .padding(bottom = 12.dp)
        )
    }
}
