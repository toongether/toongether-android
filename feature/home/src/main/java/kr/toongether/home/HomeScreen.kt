package kr.toongether.home

import android.content.Context
import android.content.Intent
import android.net.Uri
import androidx.compose.foundation.Image
import androidx.compose.foundation.ScrollState
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import kr.toongether.designsystem.component.ToongetherCard
import kr.toongether.designsystem.component.ToongetherTopAppBar
import kr.toongether.designsystem.icon.ToongetherIcons
import kr.toongether.designsystem.icon.icons.Check
import kr.toongether.designsystem.icon.icons.Clock
import kr.toongether.designsystem.icon.icons.RightArrow
import kr.toongether.designsystem.icon.icons.Toongether
import kr.toongether.designsystem.theme.Blue60
import kr.toongether.designsystem.theme.Gray50
import kr.toongether.designsystem.theme.pretendard

@Composable
internal fun HomeRoute(
    modifier: Modifier = Modifier,
    context: Context = LocalContext.current
) {
    val scrollState = rememberScrollState()

    HomeScreen(
        modifier = modifier,
        context = context,
        scrollState = scrollState
    )
}

@Composable
internal fun HomeScreen(
    modifier: Modifier = Modifier,
    context: Context,
    scrollState: ScrollState
) {
    Column(
        modifier = modifier
            .fillMaxSize()
            .background(Color.Black)
            .verticalScroll(scrollState)
    ) {
        Column(
            modifier = modifier
                .height(257.dp)
                .fillMaxWidth()
                .background(Brush.verticalGradient(listOf(Blue60, Color.Transparent)))
        ) {
            ToongetherTopAppBar(
                modifier = modifier.statusBarsPadding(),
                titleIcon = ToongetherIcons.Toongether,
                subTitle =
                "프리 릴리즈",
                backgroundColor = Color.Transparent
            )
            Box(
                modifier = modifier
                    .fillMaxWidth()
                    .padding(horizontal = 12.dp)
            ) {
                Text(
                    modifier = modifier.align(Alignment.CenterStart),
                    text = "툰게더,\n출시를 향하여!",
                    fontFamily = pretendard,
                    fontSize = 24.sp,
                    color = Color.White,
                    fontWeight = FontWeight.Bold
                )

                Image(
                    modifier = modifier
                        .size(127.dp, 151.dp)
                        .align(Alignment.CenterEnd),
                    painter = painterResource(id = kr.toongether.designsystem.R.drawable.ic_tooie),
                    contentDescription = null
                )
            }
        }

        Text(
            modifier = modifier.padding(start = 12.dp),
            text = "Android v0.2",
            fontSize = 12.sp,
            fontFamily = pretendard,
            fontWeight = FontWeight.SemiBold,
            color = Color.White
        )

        Spacer(modifier = modifier.height(4.dp))

        ToongetherCard(
            title = "툰게더에 대하여",
            icon = ToongetherIcons.RightArrow,
            iconTint = Color.White,
            onClick = {
                context.startActivity(
                    Intent(
                        Intent.ACTION_VIEW,
                        Uri.parse("https://go.toongether.kr/about")
                    )
                )
            }
        )

        Spacer(modifier = modifier.height(8.dp))

        ToongetherCard(
            title = "웹툰 업로드해보기",
            icon = ToongetherIcons.RightArrow,
            iconTint = Color.White,
            onClick = {
                context.startActivity(
                    Intent(
                        Intent.ACTION_VIEW,
                        Uri.parse("https://go.toongether.kr/try")
                    )
                )
            }
        )

        Spacer(modifier = modifier.height(8.dp))

        ToongetherCard(
            title = "피드백하기",
            icon = ToongetherIcons.RightArrow,
            iconTint = Color.White,
            onClick = {
                context.startActivity(
                    Intent(
                        Intent.ACTION_VIEW,
                        Uri.parse("https://go.toongether.kr/feedback")
                    )
                )
            }
        )

        Spacer(modifier = modifier.height(20.dp))

        Text(
            modifier = modifier.padding(start = 12.dp),
            text = "개발 진행 상황",
            fontSize = 12.sp,
            fontFamily = pretendard,
            fontWeight = FontWeight.SemiBold,
            color = Color.White
        )

        Spacer(modifier = modifier.height(4.dp))

        ToongetherCard(
            title = "단편 웹툰 열람",
            icon = ToongetherIcons.Check,
            iconTint = Blue60,
            text = "개발 완료",
            textColor = Blue60
        )

        Spacer(modifier = modifier.height(8.dp))

        ToongetherCard(
            title = "연재 웹툰 열람",
            icon = ToongetherIcons.Check,
            iconTint = Blue60,
            text = "개발 완료",
            textColor = Blue60
        )

        Spacer(modifier = modifier.height(8.dp))

        ToongetherCard(
            title = "로그인",
            icon = ToongetherIcons.Check,
            iconTint = Blue60,
            text = "개발 완료",
            textColor = Blue60
        )

        Spacer(modifier = modifier.height(8.dp))

        ToongetherCard(
            title = "웹툰 회차별 공감",
            icon = ToongetherIcons.Check,
            iconTint = Blue60,
            text = "개발 완료",
            textColor = Blue60
        )

        Spacer(modifier = modifier.height(8.dp))

        ToongetherCard(
            title = "웹툰 회차별 댓글",
            icon = ToongetherIcons.Clock,
            text = "개발 중"
        )

        Spacer(modifier = modifier.height(8.dp))

        ToongetherCard(
            title = "웹툰 검색 및 필터링",
            icon = ToongetherIcons.Clock,
            text = "개발 중"
        )

        Spacer(modifier = modifier.height(8.dp))

        ToongetherCard(
            title = "웹툰 이어보기",
            icon = ToongetherIcons.Clock,
            text = "개발 중"
        )

        Spacer(modifier = modifier.height(8.dp))

        ToongetherCard(
            title = "작가 개인 페이지",
            icon = ToongetherIcons.Clock,
            text = "개발 중"
        )

        Spacer(modifier = modifier.height(8.dp))

        ToongetherCard(
            title = "홈 화면",
            icon = ToongetherIcons.Clock,
            text = "개발 중"
        )

        Spacer(modifier = modifier.height(8.dp))

        ToongetherCard(
            title = "커뮤니티 서비스",
            icon = ToongetherIcons.Clock,
            text = "개발 중"
        )

        Spacer(modifier = modifier.height(8.dp))

        ToongetherCard(
            title = "라이트 모드",
            icon = ToongetherIcons.Clock,
            text = "개발 중"
        )

        Spacer(modifier = modifier.height(20.dp))

        Text(
            modifier = modifier.align(Alignment.CenterHorizontally),
            text = "Copyright © 2023 Progress. All rights reserved.",
            fontSize = 8.sp,
            fontFamily = pretendard,
            fontWeight = FontWeight.SemiBold,
            color = Gray50
        )

        Spacer(modifier = modifier.height(20.dp))
    }
}
