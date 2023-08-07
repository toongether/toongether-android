package kr.toongether.my

import android.content.Context
import android.content.Intent
import android.net.Uri
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
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
internal fun MyRoute(
    modifier: Modifier = Modifier,
    context: Context = LocalContext.current
) {
    MyScreen(
        modifier = modifier,
        context = context
    )
}

@Composable
internal fun MyScreen(
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
                modifier = modifier
                    .align(Alignment.TopCenter),
                title = {
                    Row(
                        modifier = modifier
                            .padding(bottom = 10.dp)
                    ) {
                        Box(
                            modifier = modifier
                                .fillMaxHeight()
                        ) {
                            Text(
                                modifier = modifier.align(Alignment.BottomCenter),
                                text = "마이 페이지",
                                fontFamily = pretendard,
                                fontWeight = FontWeight.Bold,
                                color = Color.White,
                                fontSize = 26.sp
                            )
                        }
                        Spacer(modifier = modifier.size(5.dp))
                        Box(
                            modifier = modifier
                                .fillMaxHeight()
                        ) {
                            Text(
                                modifier = modifier.align(Alignment.BottomCenter),
                                text = "준비 중",
                                fontFamily = pretendard,
                                fontWeight = FontWeight.Normal,
                                color = Color.White,
                                fontSize = 14.sp
                            )
                        }
                    }
                }
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
