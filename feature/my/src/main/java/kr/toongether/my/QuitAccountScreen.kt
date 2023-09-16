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
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import kr.toongether.designsystem.component.ToongetherButton
import kr.toongether.designsystem.component.ToongetherCard
import kr.toongether.designsystem.component.ToongetherLargeButton
import kr.toongether.designsystem.component.ToongetherTopAppBarWithBack
import kr.toongether.designsystem.icon.ToongetherIcons
import kr.toongether.designsystem.icon.icons.Back
import kr.toongether.designsystem.icon.icons.RightArrow
import kr.toongether.designsystem.theme.Red
import kr.toongether.designsystem.theme.pretendard
import java.net.URLEncoder
import java.nio.charset.StandardCharsets

@Composable
internal fun QuitAccountRoute(
    modifier: Modifier = Modifier,
    navController: NavController,
) {
    val context = LocalContext.current

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
        onClickButton = { },
    )
}

@Composable
private fun QuitAccountScreen(
    modifier: Modifier = Modifier,
    onClickBack: () -> Unit,
    onClickQuitInfo: () -> Unit,
    onClickButton: () -> Unit,
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
        
        Spacer(modifier = modifier.navigationBarsPadding().padding(bottom = 12.dp))
    }
}