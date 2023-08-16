package kr.toongether.community

import android.content.Context
import android.content.Intent
import android.net.Uri
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
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import kr.toongether.designsystem.component.ToongetherButton
import kr.toongether.designsystem.component.ToongetherTopAppBar
import kr.toongether.designsystem.theme.pretendard

@Composable
internal fun CommunityRoute(
    modifier: Modifier = Modifier,
    context: Context = LocalContext.current
) {
    CommunityScreen(
        modifier = modifier,
        context = context
    )
}

@Composable
internal fun CommunityScreen(
    modifier: Modifier = Modifier,
    context: Context
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
                title = "커뮤니티",
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
                        context.startActivity(
                            Intent(
                                Intent.ACTION_VIEW,
                                Uri.parse("https://toongether.kr/beta")
                            )
                        )
                    }
                ) {
                    Text(
                        text = "자세히 알아보기",
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
