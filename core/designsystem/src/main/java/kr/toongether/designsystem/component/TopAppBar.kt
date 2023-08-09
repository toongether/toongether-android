package kr.toongether.designsystem.component

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.colorspace.WhitePoint
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import kr.toongether.designsystem.theme.pretendard
import kr.toongether.designsystem.utils.NoRippleInteractionSource

@Composable
fun ToongetherTopAppBar(
    title: String,
    subTitle: String? = null,
    actionIcon: ImageVector,
    actionIconContentDescription: String? = null,
    modifier: Modifier = Modifier,
    onActionClick: () -> Unit,
    backgroundColor: Color = Color.Black,
) {
    Box(
        modifier = modifier
            .fillMaxWidth()
            .height(48.dp)
            .background(backgroundColor)
            .padding(12.dp)
    ) {
        Row(
            modifier = modifier
                .align(Alignment.Center)
                .wrapContentSize()
        ) {
            Text(
                modifier = modifier.align(Alignment.Bottom),
                text = title,
                fontFamily = pretendard,
                fontWeight = FontWeight.Bold,
                color = Color.White,
                fontSize = 24.sp
            )
            subTitle?.let {
                Text(
                    modifier = modifier.align(Alignment.Bottom),
                    text = it,
                    fontFamily = pretendard,
                    fontWeight = FontWeight.Normal,
                    color = Color.White,
                    fontSize = 14.sp
                )
            }
        }

        IconButton(
            modifier = modifier
                .align(Alignment.CenterEnd)
                .size(24.dp),
            onClick = onActionClick
        ) {
            Icon(
                imageVector = actionIcon,
                contentDescription = actionIconContentDescription,
                modifier = modifier.size(20.dp)
            )
        }
    }
}

@Composable
fun ToongetherTopAppBar(
    title: String,
    subTitle: String? = null,
    modifier: Modifier = Modifier,
    contentColor: Color = Color.White,
    backgroundColor: Color = Color.Black,
) {
    Box(
        modifier = modifier
            .fillMaxWidth()
            .height(50.dp)
            .background(backgroundColor)
            .padding(horizontal = 12.dp)
    ) {
        Row(
            modifier = modifier
                .align(Alignment.CenterStart)
                .wrapContentSize()
        ) {
            Text(
                modifier = modifier.align(Alignment.Bottom),
                text = title,
                fontFamily = pretendard,
                fontWeight = FontWeight.Bold,
                color = contentColor,
                fontSize = 24.sp
            )
            subTitle?.let {
                Spacer(modifier = modifier.size(5.dp))
                
                Text(
                    modifier = modifier
                        .align(Alignment.Bottom)
                        .padding(bottom = 2.dp),
                    text = it,
                    fontFamily = pretendard,
                    fontWeight = FontWeight.Normal,
                    color = contentColor,
                    fontSize = 14.sp
                )
            }
        }
    }
}

@Composable
fun ToongetherTopAppBar(
    titleIcon: ImageVector,
    subTitle: String? = null,
    modifier: Modifier = Modifier,
    contentColor: Color = Color.White,
    backgroundColor: Color = Color.Black,
) {
    Box(
        modifier = modifier
            .fillMaxWidth()
            .height(50.dp)
            .background(backgroundColor)
            .padding(horizontal = 12.dp)
    ) {
        Row(
            modifier = modifier
                .align(Alignment.CenterStart)
                .wrapContentSize()
        ) {
            Icon(
                imageVector = titleIcon,
                contentDescription = null,
                tint = contentColor
            )
            subTitle?.let {
                Spacer(modifier = modifier.size(5.dp))
                Text(
                    modifier = modifier.align(Alignment.Bottom),
                    text = it,
                    fontFamily = pretendard,
                    fontWeight = FontWeight.Normal,
                    color = contentColor,
                    fontSize = 14.sp
                )
            }
        }
    }
}

@Composable
fun ToongetherTopAppBar(
    title: String,
    subTitle: String? = null,
    navigationIcon: ImageVector,
    modifier: Modifier = Modifier,
    onNavigationClick: () -> Unit,
    contentColor: Color = Color.White,
    backgroundColor: Color = Color.Black,
) {
    Box(
        modifier = modifier
            .fillMaxWidth()
            .height(50.dp)
            .background(backgroundColor)
            .padding(horizontal = 5.dp)
    ) {
        Row(
            modifier = Modifier
                .align(Alignment.CenterStart)
                .wrapContentSize()
        ) {

            IconButton(
                modifier = Modifier
                    .align(Alignment.Bottom)
                    .size(30.dp),
                onClick = onNavigationClick,
                interactionSource = remember { NoRippleInteractionSource() }
            ) {
                Icon(
                    imageVector = navigationIcon,
                    contentDescription = null,
                    modifier = Modifier.size(20.dp),
                    tint = contentColor
                )
            }
            Spacer(modifier = Modifier.size(5.dp))
            Text(
                modifier = Modifier.align(Alignment.Bottom),
                text = title,
                fontFamily = pretendard,
                fontWeight = FontWeight.Bold,
                color = contentColor,
                fontSize = 24.sp
            )
            subTitle?.let {
                Spacer(modifier = Modifier.size(5.dp))
                Text(
                    modifier = Modifier
                        .align(Alignment.Bottom)
                        .padding(bottom = 2.dp),
                    text = it,
                    fontFamily = pretendard,
                    fontWeight = FontWeight.Normal,
                    color = contentColor,
                    fontSize = 14.sp
                )
            }
        }
    }
}
