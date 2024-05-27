package kr.toongether.android.ui

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navOptions
import kr.toongether.comic.navigation.ComicRoute
import kr.toongether.comic.navigation.comicScreen
import kr.toongether.comic.navigation.navigateToComic
import kr.toongether.episode.navigatoin.episodeScreen
import kr.toongether.episode.navigatoin.navigateToEpisode
import kr.toongether.home.navigation.HomeRoute
import kr.toongether.home.navigation.homeScreen
import kr.toongether.login.navigation.loginScreen
import kr.toongether.login.navigation.navigateToLogin
import kr.toongether.my.navigation.myScreen
import kr.toongether.my.navigation.settingScreen
import kr.toongether.series.navigation.seriesScreen
import kr.toongether.shorts.navigation.shortsScreen
import kr.toongether.signup.navigation.signupScreen

@ExperimentalFoundationApi
@ExperimentalMaterial3Api
@ExperimentalMaterialApi
@Composable
fun ToongetherApp(
    navController: NavHostController = rememberNavController()
) {
    NavHost(
        navController = navController,
        startDestination = HomeRoute,
        modifier = Modifier.fillMaxSize()
    ) {
        homeScreen(
            navigateToComic = navController::navigateToComic,
            navigateToEpisode = navController::navigateToEpisode,
        )
        seriesScreen(navigateToEpisode = navController::navigateToEpisode)
        shortsScreen(navigateToComic = navController::navigateToComic)
        myScreen(navController)
        comicScreen(
            navigateToComic = { seriesId, episodeNumber ->
                navController.navigateToComic(
                    seriesId = seriesId,
                    episodeNumber = episodeNumber,
                    navOptions {
                        popUpTo(ComicRoute) {
                            inclusive = true
                        }
                    }
                )
            },
            navigateToLogin = navController::navigateToLogin,
            popBackStack = navController::popBackStack
        )
        loginScreen(navController = navController)
        signupScreen(navController = navController)
        episodeScreen(navigateToComic = navController::navigateToComic, popBackStack = navController::popBackStack)
        settingScreen(navController = navController)
    }
}
