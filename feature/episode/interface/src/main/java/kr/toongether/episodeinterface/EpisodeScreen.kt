package kr.toongether.episodeinterface

import androidx.compose.animation.AnimatedContentScope
import androidx.compose.animation.ExperimentalSharedTransitionApi
import androidx.compose.animation.SharedTransitionScope
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.safeDrawingPadding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import coil.decode.SvgDecoder
import coil.request.ImageRequest
import kr.toongether.designsystem.icon.ToongetherIcons
import kr.toongether.designsystem.theme.ToongetherColors
import kr.toongether.designsystem.theme.ToongetherTypography
import kr.toongether.model.Episode
import java.nio.ByteBuffer

@OptIn(ExperimentalMaterial3Api::class, ExperimentalSharedTransitionApi::class)
@Composable
fun EpisodeScreen(
    modifier: Modifier = Modifier,
    uiState: EpisodeUiState,
    id: Long,
    backgroundImage: String,
    backgroundColor: Color,
    onItemClick: (Episode) -> Unit,
    onClickBack: () -> Unit,
    sharedTransitionScope: SharedTransitionScope,
    animatedContentScope: AnimatedContentScope
) {
    Column(
        modifier = modifier
            .fillMaxSize()
            .background(color = backgroundColor)
    ) {
        with(sharedTransitionScope) {
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .aspectRatio(0.75f)
            ) {
                AsyncImage(
                    modifier = Modifier
                        .sharedElement(
                            sharedTransitionScope.rememberSharedContentState(key = "backgroundImage-$id"),
                            animatedVisibilityScope = animatedContentScope
                        )
                        .fillMaxSize(),
                    model = backgroundImage,
                    contentDescription = null,
                    contentScale = ContentScale.Crop
                )

                TopAppBar(
                    modifier = Modifier.statusBarsPadding(),
                    title = { },
                    navigationIcon = {
                        IconButton(onClick = onClickBack) {
                            Icon(
                                modifier = Modifier.size(24.dp),
                                imageVector = ToongetherIcons.Bold.ArrowLeft,
                                tint = ToongetherColors.LabelNormal,
                                contentDescription = "Back"
                            )
                        }
                    },
                    actions = {
                        IconButton(onClick = { /*TODO*/ }) {
                            Icon(
                                modifier = Modifier.size(24.dp),
                                imageVector = ToongetherIcons.Bold.Heart,
                                tint = ToongetherColors.LabelNormal,
                                contentDescription = "Like"
                            )
                        }
                        IconButton(onClick = { /*TODO*/ }) {
                            Icon(
                                modifier = Modifier.size(24.dp),
                                imageVector = ToongetherIcons.Bold.DotsThree,
                                tint = ToongetherColors.LabelNormal,
                                contentDescription = "ETC"
                            )
                        }
                    },
                    colors = TopAppBarDefaults.topAppBarColors(
                        containerColor = Color.Transparent
                    )
                )

                Box(
                    modifier = Modifier
                        .sharedElement(
                            sharedTransitionScope.rememberSharedContentState(key = "backgroundColor-$id"),
                            animatedVisibilityScope = animatedContentScope
                        )
                        .align(Alignment.BottomCenter)
                        .fillMaxWidth()
                        .fillMaxHeight(0.5f)
                        .background(
                            Brush.verticalGradient(
                                listOf(
                                    backgroundColor.copy(0f),
                                    backgroundColor,
                                )
                            )
                        )
                )

                when (uiState) {
                    is EpisodeUiState.Loading -> {

                    }

                    is EpisodeUiState.Success -> {
                        Column(
                            modifier = Modifier
                                .align(Alignment.BottomCenter)
                                .fillMaxWidth()
                                .fillMaxHeight(0.35f)
                                .padding(horizontal = 20.dp, vertical = 16.dp)
                        ) {
                            AsyncImage(
                                modifier = Modifier
                                    .weight(1f),
                                model = ImageRequest.Builder(LocalContext.current)
                                    .data(ByteBuffer.wrap(uiState.data.titleMaker.alignLeftTitleSvg?.toByteArray() ?: ByteArray(0)))
                                    .decoderFactory(SvgDecoder.Factory())
                                    .build(),
                                contentDescription = null,
                                contentScale = ContentScale.Fit
                            )

                            Spacer(modifier = Modifier.height(4.dp))

                            Text(
                                text = "${uiState.data.author.name} · ${uiState.data.dayOfWeek.id} 웹툰 · ${uiState.data.serialCycle.id} 연재",
                                style = ToongetherTypography.Body3,
                                color = ToongetherColors.LabelNormal,
                            )

                            Spacer(modifier = Modifier.height(8.dp))

                            Text(
                                text = uiState.data.description,
                                style = ToongetherTypography.Label2,
                                color = ToongetherColors.LabelNormal.copy(0.6f),
                            )
                        }
                    }

                    is EpisodeUiState.Error -> TODO()
                }
            }
        }
        LazyColumn(
            modifier = Modifier.padding(horizontal = 16.dp),
            verticalArrangement = Arrangement.spacedBy(4.dp)
        ) {
            when (uiState) {
                is EpisodeUiState.Loading -> {

                }

                is EpisodeUiState.Success -> {
                    itemsIndexed(
                        items = uiState.data.episodeList,
                        key = { _, item -> item.episodeId },
                    ) { index, episode ->
                        Column {
                            Row(
                                modifier = Modifier
                                    .fillMaxWidth()
                                    .clickable(
                                        onClick = { onItemClick(episode) },
                                        interactionSource = remember { MutableInteractionSource() },
                                        indication = null,
                                    ),
                                verticalAlignment = Alignment.CenterVertically,
                                horizontalArrangement = Arrangement.spacedBy(12.dp)
                            ) {
                                AsyncImage(
                                    modifier = Modifier
                                        .width(120.dp)
                                        .aspectRatio(1.6f)
                                        .clip(RoundedCornerShape(4.dp)),
                                    model = episode.thumbnail,
                                    contentDescription = null,
                                    contentScale = ContentScale.Crop
                                )

                                Column {
                                    Text(
                                        text = episode.title,
                                        style = ToongetherTypography.Label2,
                                        color = ToongetherColors.LabelNormal,
                                    )
                                    Text(
                                        text = String.format(
                                            "%d.%02d.%02d",
                                            episode.createdDate.year - 2000,
                                            episode.createdDate.monthNumber,
                                            episode.createdDate.dayOfMonth
                                        ),
                                        style = ToongetherTypography.Label3,
                                        color = ToongetherColors.LabelNormal.copy(0.6f),
                                    )

                                    Spacer(modifier = Modifier.height(4.dp))

                                    Row(
                                        verticalAlignment = Alignment.CenterVertically,
                                        horizontalArrangement = Arrangement.spacedBy(2.dp)
                                    ) {
                                        Icon(
                                            modifier = Modifier.size(14.dp),
                                            imageVector = ToongetherIcons.Fill.ThumbsUp,
                                            tint = ToongetherColors.LabelNormal.copy(0.6f),
                                            contentDescription = "Like"
                                        )
                                        Text(
                                            text = episode.likeCount.toString(),
                                            style = ToongetherTypography.Label3,
                                            color = ToongetherColors.LabelNormal.copy(0.6f),
                                        )

                                        Spacer(modifier = Modifier.width(4.dp))

                                        Icon(
                                            modifier = Modifier.size(14.dp),
                                            imageVector = ToongetherIcons.Fill.ChatDots,
                                            tint = ToongetherColors.LabelNormal.copy(0.6f),
                                            contentDescription = "Comment"
                                        )
                                        Text(
                                            text = episode.commentCount.toString(),
                                            style = ToongetherTypography.Label3,
                                            color = ToongetherColors.LabelNormal.copy(0.6f),
                                        )
                                    }
                                }
                            }

                            if (index < uiState.data.episodeList.size - 1) {
                                Spacer(modifier = Modifier.height(4.dp))
                                Box(
                                    modifier = Modifier
                                        .align(Alignment.End)
                                        .fillMaxWidth(0.65f)
                                        .background(ToongetherColors.White.copy(0.2f))
                                        .height(1.dp)
                                )
                            }
                        }
                    }
                }

                is EpisodeUiState.Error -> TODO()
            }
        }
    }

}
