package kr.toongether.android.ui

import androidx.compose.animation.ExperimentalSharedTransitionApi
import androidx.compose.animation.SharedTransitionLayout
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.safeDrawingPadding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navOptions
import kr.toongether.comic.navigation.COMIC_ROUTE
import kr.toongether.comic.navigation.comicScreen
import kr.toongether.comic.navigation.navigateToComic
import kr.toongether.designsystem.theme.ToongetherColors
import kr.toongether.episode.navigatoin.episodeScreen
import kr.toongether.episode.navigatoin.navigateToEpisode
import kr.toongether.login.navigation.loginScreen
import kr.toongether.login.navigation.navigateToLogin
import kr.toongether.main.navigation.MAIN_ROUTE
import kr.toongether.main.navigation.mainScreen

@OptIn(ExperimentalSharedTransitionApi::class)
@Composable
fun ToongetherApp(
    navController: NavHostController = rememberNavController()
) {
    SharedTransitionLayout {
        NavHost(
            navController = navController,
            startDestination = MAIN_ROUTE,
            modifier = Modifier
                .fillMaxSize()
                .background(ToongetherColors.BackgroundNormal)
                .safeDrawingPadding()
        ) {
            mainScreen(
                navigateToEpisode = navController::navigateToEpisode,
                navigateToLogin = navController::navigateToLogin,
                sharedTransitionScope = this@SharedTransitionLayout,
            )
            comicScreen(
                navigateToComic = { seriesId, episodeNumber ->
                    navController.navigateToComic(
                        seriesId = seriesId,
                        episodeNumber = episodeNumber,
                        navOptions {
                            popUpTo(COMIC_ROUTE) {
                                inclusive = true
                            }
                        }
                    )
                },
                navigateToLogin = navController::navigateToLogin,
                popBackStack = navController::popBackStack
            )
        loginScreen(popBackStack = navController::popBackStack)
//        signupScreen(navController = navController, alert = {})
            episodeScreen(
                navigateToComic = navController::navigateToComic,
                popBackStack = navController::popBackStack,
                sharedTransitionScope = this@SharedTransitionLayout,
            )
//        settingScreen(navController = navController)
        }
    }
}
