package kr.toongether.comic

import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.hilt.navigation.compose.hiltViewModel
import kr.toongether.comicinterface.ComicScreen
import kr.toongether.comicinterface.ComicSideEffect
import kr.toongether.ui.AlertScreen
import org.orbitmvi.orbit.compose.collectAsState
import org.orbitmvi.orbit.compose.collectSideEffect
import java.time.LocalTime

@Composable
fun ComicScreen(
    episodeNumber: Long,
    seriesId: Long,
    navigateToLogin: () -> Unit,
    navigateToComic: (Long) -> Unit,
    popBackStack: () -> Unit,
    modifier: Modifier = Modifier,
    viewModel: ComicViewModel = hiltViewModel(),
) {
    val comicState by viewModel.collectAsState()
    val lazyListState = rememberLazyListState()

    var showAlert by remember { mutableStateOf(false) }

    var sShowTabs by remember { mutableStateOf(true) }
    var toggledTime: LocalTime? by remember { mutableStateOf(null) }
    var isTopOrBottom by remember { mutableStateOf(true) }

    var isLiked by remember { mutableStateOf(false) }

    viewModel.collectSideEffect {
        when (it) {
            is ComicSideEffect.Toast -> {
                showAlert = true
                alert {
                    AlertScreen(
                        isShowAlert = showAlert,
                        text = it.text,
                        buttonText = "확인"
                    ) {
                        showAlert = false
                    }
                }
            }
            is ComicSideEffect.LoginToast -> {
                showAlert = true
                alert {
                    AlertScreen(
                        isShowAlert = showAlert,
                        text = "로그인이 필요해요.",
                        firstButtonText = "로그인",
                        onClickFirstButton = {
                            showAlert = false
                            navigateToLogin()
                        },
                        secondButtonText = "취소",
                        onClickSecondButton = { showAlert = false }
                    )
                }
            }
            is ComicSideEffect.Like -> {
                isLiked = true

            }

            is ComicSideEffect.UnLike -> {
                isLiked = false
            }
        }
    }

    LaunchedEffect(Unit) {
        if (seriesId == -1L) {
            viewModel.getComic(episodeNumber)
        } else {
            viewModel.getComic(seriesId = seriesId, episodeId = episodeNumber)
        }
    }

    ComicScreen(
        modifier = modifier,
        lazyListState = lazyListState,
        onBackClick = popBackStack,
        uiState = comicState,
        isShowTabs = sShowTabs || isTopOrBottom,
        onNextClick = navigateToComic,
        onBeforeClick = navigateToComic,
        onLikeClick = {
            if (seriesId == -1L) {
                viewModel.likeShorts(it)
            } else {
                viewModel.likeSeries(it)
            }
        },
        isLiked = isLiked
    )
}
