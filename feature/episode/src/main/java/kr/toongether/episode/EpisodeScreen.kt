package kr.toongether.episode

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.navigationBarsPadding
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import kr.toongether.comic.navigation.navigateToComic
import kr.toongether.designsystem.icon.ToongetherIcons
import kr.toongether.designsystem.icon.icons.Back
import kr.toongether.designsystem.theme.TransparentBlack
import kr.toongether.model.Episode
import kr.toongether.ui.LoadingScreen
import kr.toongether.ui.TitleImageCard
import kr.toongether.ui.seriesCardItems
import org.orbitmvi.orbit.compose.collectAsState

@Composable
internal fun EpisodeRoute(
    id: Long,
    modifier: Modifier = Modifier,
    navController: NavController,
    viewModel: EpisodeViewModel = hiltViewModel()
) {
    val state by viewModel.collectAsState()

    LaunchedEffect(id) {
        viewModel.getSeriesEpisode(id)
    }

    EpisodeScreen(
        modifier = modifier,
        episodeState = state,
        onItemClick = {
            navController.navigateToComic(
                seriesId = id,
                episodeNumber = it.episodeNumber.toLong()
            )
        },
        onClickBack = navController::popBackStack,
        isLoading = state.isLoading
    )
}

@Composable
private fun EpisodeScreen(
    modifier: Modifier = Modifier,
    episodeState: EpisodeState,
    onItemClick: (Episode) -> Unit,
    onClickBack: () -> Unit,
    isLoading: Boolean
) {
    if (isLoading) {
        LoadingScreen()
    } else {
        Surface(
            modifier = modifier
                .fillMaxSize()
                .navigationBarsPadding(),
            color = Color.Black
        ) {
            LazyColumn(
                verticalArrangement = Arrangement.spacedBy(8.dp)
            ) {
                item {
                    Box(modifier.padding(bottom = 20.dp)) {
                        TitleImageCard(
                            thumbnailImage = episodeState.seriesEpisodeList.titleInfo.thumbnailImage,
                            titleImage = episodeState.seriesEpisodeList.titleInfo.titleImage,
                            titleWidth = episodeState.seriesEpisodeList.titleInfo.titleWidth,
                            author = episodeState.seriesEpisodeList.author.name,
                            dayOfWeek = episodeState.seriesEpisodeList.dayOfWeek.title,
                            cycle = episodeState.seriesEpisodeList.cycle.title,
                            genre = episodeState.seriesEpisodeList.genre
                        )

                        Box(
                            modifier = modifier
                                .fillMaxWidth()
                                .height(80.dp)
                                .background(TransparentBlack)
                        )

                        IconButton(
                            modifier = modifier.padding(top = 30.dp, start = 8.dp),
                            onClick = onClickBack
                        ) {
                            Icon(
                                modifier = modifier.size(20.dp),
                                imageVector = ToongetherIcons.Back,
                                contentDescription = null,
                                tint = Color.White
                            )
                        }
                    }
                }
                seriesCardItems(
                    modifier = modifier.padding(horizontal = 12.dp),
                    items = episodeState.seriesEpisodeList,
                    onItemClick = onItemClick
                )
            }
        }
    }
}
