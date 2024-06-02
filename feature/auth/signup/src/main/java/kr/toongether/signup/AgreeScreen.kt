//package kr.toongether.signup
//
//import android.content.Intent
//import android.net.Uri
//import androidx.compose.foundation.background
//import androidx.compose.foundation.layout.Box
//import androidx.compose.foundation.layout.Column
//import androidx.compose.foundation.layout.Spacer
//import androidx.compose.foundation.layout.fillMaxSize
//import androidx.compose.foundation.layout.height
//import androidx.compose.foundation.layout.navigationBarsPadding
//import androidx.compose.foundation.layout.padding
//import androidx.compose.foundation.layout.statusBarsPadding
//import androidx.compose.material.IconButton
//import androidx.compose.material3.Icon
//import androidx.compose.material3.Text
//import androidx.compose.runtime.Composable
//import androidx.compose.ui.Modifier
//import androidx.compose.ui.graphics.Color
//import androidx.compose.ui.platform.LocalContext
//import androidx.compose.ui.text.font.FontWeight
//import androidx.compose.ui.unit.dp
//import androidx.compose.ui.unit.sp
//import androidx.navigation.NavController
//import kr.toongether.designsystem.component.ToongetherCard
//import kr.toongether.designsystem.component.ToongetherLargeButton
//import kr.toongether.designsystem.icon.ToongetherIcons
//import kr.toongether.designsystem.icon.icons.Back
//import kr.toongether.designsystem.icon.icons.RightArrow
//import kr.toongether.designsystem.theme.pretendard
//import kr.toongether.signup.navigation.navigateToSignup
//
//@Composable
//internal fun AgreeRoute(
//    modifier: Modifier = Modifier,
//    navController: NavController
//) {
//    val context = LocalContext.current
//
//    AgreeScreen(
//        modifier = modifier,
//        onClickBack = navController::popBackStack,
//        onClickPrivacy = {
//            context.startActivity(
//                Intent(
//                    Intent.ACTION_VIEW,
//                    Uri.parse("https://go.toongether.kr/privacy")
//                )
//            )
//        },
//        onClickInfo = {
//            context.startActivity(
//                Intent(
//                    Intent.ACTION_VIEW,
//                    Uri.parse("https://go.toongether.kr/terms")
//                )
//            )
//        },
//        onClickButton = navController::navigateToSignup
//    )
//}
//
//@Composable
//private fun AgreeScreen(
//    modifier: Modifier = Modifier,
//    onClickBack: () -> Unit,
//    onClickInfo: () -> Unit,
//    onClickPrivacy: () -> Unit,
//    onClickButton: () -> Unit
//) {
//    Box(
//        modifier
//            .fillMaxSize()
//            .statusBarsPadding()
//            .background(Color.Black)
//    ) {
//    }
//    Column {
//        Spacer(modifier = modifier.statusBarsPadding())
//
//        IconButton(
//            onClick = onClickBack
//        ) {
//            Icon(
//                imageVector = ToongetherIcons.Back,
//                contentDescription = null,
//                tint = Color.White
//            )
//        }
//
//        Spacer(modifier = modifier.height(16.dp))
//
//        Text(
//            modifier = modifier.padding(horizontal = 16.dp),
//            text = "약관에\n동의해주세요",
//            color = Color.White,
//            fontSize = 24.sp,
//            fontWeight = FontWeight.Bold,
//            fontFamily = pretendard
//        )
//
//        Spacer(modifier = modifier.height(20.dp))
//
//        ToongetherCard(
//            title = "툰게더 서비스 이용약관",
//            icon = ToongetherIcons.RightArrow,
//            onClick = onClickInfo,
//            iconTint = Color.White
//        )
//
//        Spacer(modifier = modifier.height(8.dp))
//
//        ToongetherCard(
//            title = "개인정보 취급방침",
//            icon = ToongetherIcons.RightArrow,
//            onClick = onClickPrivacy,
//            iconTint = Color.White
//        )
//
//        Spacer(modifier = modifier.weight(1f))
//
//        ToongetherLargeButton(
//            modifier = modifier.padding(horizontal = 12.dp),
//            text = "동의하기",
//            onClick = onClickButton
//        )
//
//        Spacer(
//            modifier = modifier
//                .navigationBarsPadding()
//                .padding(bottom = 12.dp)
//        )
//    }
//}
