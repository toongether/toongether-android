package kr.toongether.episode

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
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
import kr.toongether.model.Episode
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
                episodeId = it.id,
                author = state.seriesEpisode.author.name
            )
        },
        onClickBack = navController::popBackStack
    )
}

@Composable
private fun EpisodeScreen(
    modifier: Modifier = Modifier,
    episodeState: EpisodeState,
    onItemClick: (Episode) -> Unit,
    onClickBack: () -> Unit,
) {

    Surface(
        modifier = modifier
            .fillMaxSize(),
        color = Color.Black
    ) {
        Column(
            modifier = modifier
                .fillMaxSize()
        ) {
            Box {
                TitleImageCard(
                    thumbnailImage = episodeState.seriesEpisode.titleInfo.thumbnailImage,
                    titleImage = episodeState.seriesEpisode.titleInfo.titleImage,
                    titleWidth = episodeState.seriesEpisode.titleInfo.titleWidth,
                    author = episodeState.seriesEpisode.author.name,
                    dayOfWeek = episodeState.seriesEpisode.dayOfWeek.title,
                    cycle = episodeState.seriesEpisode.cycle.title,
                    genre = episodeState.seriesEpisode.genre
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

            LazyColumn(
                verticalArrangement = Arrangement.spacedBy(8.dp),
                contentPadding = PaddingValues(vertical = 20.dp, horizontal = 12.dp)
            ) {
                seriesCardItems(
                    items = episodeState.seriesEpisode,
                    onItemClick = onItemClick
                )
            }
        }
    }
}
