package kr.toongether.ui

import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.airbnb.lottie.compose.LottieAnimation
import com.airbnb.lottie.compose.LottieClipSpec
import com.airbnb.lottie.compose.LottieCompositionSpec
import com.airbnb.lottie.compose.LottieConstants
import com.airbnb.lottie.compose.animateLottieCompositionAsState
import com.airbnb.lottie.compose.rememberLottieComposition
import kr.toongether.designsystem.R

@Composable
fun ToongetherLottie(
    isPlaying: Boolean,
    modifier: Modifier = Modifier
) {
    val composition by rememberLottieComposition(LottieCompositionSpec.RawRes(R.raw.toongether_logo_lottie))
    val progress by animateLottieCompositionAsState(
        composition,
        isPlaying = isPlaying,
        iterations = LottieConstants.IterateForever,
    )
    LottieAnimation(
        composition = composition,
        progress = { progress },
        modifier = modifier.width(100.dp)
    )
}
