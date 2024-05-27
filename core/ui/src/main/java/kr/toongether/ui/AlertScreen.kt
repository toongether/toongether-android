//package kr.toongether.ui
//
//import androidx.compose.animation.AnimatedVisibility
//import androidx.compose.animation.fadeIn
//import androidx.compose.animation.fadeOut
//import androidx.compose.foundation.background
//import androidx.compose.foundation.layout.Box
//import androidx.compose.foundation.layout.fillMaxSize
//import androidx.compose.foundation.layout.padding
//import androidx.compose.runtime.Composable
//import androidx.compose.ui.Alignment
//import androidx.compose.ui.Modifier
//import androidx.compose.ui.graphics.Color
//import androidx.compose.ui.unit.dp
//import kr.toongether.designsystem.component.ToongetherAlert
//import kr.toongether.designsystem.theme.Blue60
//import kr.toongether.designsystem.theme.TransparentBlack30
//
//@Composable
//fun AlertScreen(
//    modifier: Modifier = Modifier,
//    isShowAlert: Boolean,
//    text: String,
//    textColor: Color = Color.White,
//    buttonText: String,
//    buttonTextColor: Color = Color.White,
//    buttonColor: Color = Blue60,
//    onClickButton: () -> Unit
//) {
//    AnimatedVisibility(
//        visible = isShowAlert,
//        enter = fadeIn(),
//        exit = fadeOut()
//    ) {
//        Box(
//            modifier = modifier
//                .fillMaxSize()
//                .background(TransparentBlack30)
//                .padding(45.dp)
//        ) {
//            ToongetherAlert(
//                modifier = Modifier.align(Alignment.Center),
//                text = text,
//                textColor = textColor,
//                buttonText = buttonText,
//                buttonTextColor = buttonTextColor,
//                onClickButton = onClickButton,
//                buttonColor = buttonColor
//            )
//        }
//    }
//}
//
//@Composable
//fun AlertScreen(
//    modifier: Modifier = Modifier,
//    isShowAlert: Boolean,
//    text: String,
//    textColor: Color = Color.White,
//    firstButtonText: String,
//    firstButtonTextColor: Color = Color.White,
//    firstButtonColor: Color = Blue60,
//    onClickFirstButton: () -> Unit,
//    secondButtonText: String,
//    onClickSecondButton: () -> Unit
//) {
//    AnimatedVisibility(
//        visible = isShowAlert,
//        enter = fadeIn(),
//        exit = fadeOut()
//    ) {
//        Box(
//            modifier = modifier
//                .fillMaxSize()
//                .background(TransparentBlack30)
//                .padding(45.dp)
//        ) {
//            ToongetherAlert(
//                modifier = Modifier.align(Alignment.Center),
//                text = text,
//                textColor = textColor,
//                firstButtonText = firstButtonText,
//                firstButtonTextColor = firstButtonTextColor,
//                firstButtonColor = firstButtonColor,
//                onClickFirstButton = onClickFirstButton,
//                secondButtonText = secondButtonText,
//                onClickSecondButton = onClickSecondButton
//            )
//        }
//    }
//}
