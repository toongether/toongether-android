//package kr.toongether.ui
//
//import androidx.compose.foundation.layout.Arrangement
//import androidx.compose.foundation.layout.Column
//import androidx.compose.foundation.layout.Row
//import androidx.compose.foundation.layout.aspectRatio
//import androidx.compose.foundation.layout.fillMaxWidth
//import androidx.compose.foundation.layout.size
//import androidx.compose.foundation.shape.CircleShape
//import androidx.compose.foundation.shape.RoundedCornerShape
//import androidx.compose.material3.Text
//import androidx.compose.runtime.Composable
//import androidx.compose.ui.Alignment
//import androidx.compose.ui.Modifier
//import androidx.compose.ui.draw.clip
//import androidx.compose.ui.graphics.Color
//import androidx.compose.ui.layout.ContentScale
//import androidx.compose.ui.text.font.FontWeight
//import androidx.compose.ui.unit.dp
//import androidx.compose.ui.unit.sp
//import coil.compose.AsyncImage
//import kotlinx.datetime.LocalDateTime
//import kr.toongether.common.toRelativeDateTime
//import kr.toongether.designsystem.theme.ToongetherColors
//import kr.toongether.designsystem.theme.pretendard
//
//@Composable
//fun ShortsCard(
//    profileImage: String?,
//    thumbnail: String,
//    title: String,
//    writer: String,
//    views: Int,
//    createdDate: LocalDateTime,
//    modifier: Modifier = Modifier,
//) {
//    Column(
//        modifier = modifier
//            .fillMaxWidth(),
//        verticalArrangement = Arrangement.spacedBy(5.dp)
//    ) {
//        AsyncImage(
//            modifier = modifier
//                .fillMaxWidth()
//                .clip(RoundedCornerShape(4.dp))
//                .aspectRatio(1.6f),
//            model = thumbnail,
//            contentDescription = null,
//            contentScale = ContentScale.Crop
//        )
//
//        Row(
//            horizontalArrangement = Arrangement.spacedBy(8.dp),
//            verticalAlignment = Alignment.CenterVertically
//        ) {
//            AsyncImage(
//                modifier = modifier
//                    .size(30.dp)
//                    .clip(CircleShape),
//                model = profileImage ?: kr.toongether.designsystem.R.drawable.ic_default_profile,
//                contentDescription = null,
//                contentScale = ContentScale.Crop
//            )
//
//            Column {
//                Text(
//                    text = title,
//                    fontFamily = pretendard,
//                    fontSize = 16.sp,
//                    fontWeight = FontWeight.Medium,
//                    color = Color.White
//                )
//                Text(
//                    text = "$writer • 조회수 ${views}회 • ${createdDate.toRelativeDateTime()}",
//                    fontFamily = pretendard,
//                    fontSize = 14.sp,
//                    fontWeight = FontWeight.Medium,
//                    color = ToongetherColors.Gray60
//                )
//            }
//        }
//    }
//}
