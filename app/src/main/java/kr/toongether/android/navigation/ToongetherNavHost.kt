package kr.toongether.android.navigation

import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.compose.navigation
import com.google.accompanist.navigation.animation.AnimatedNavHost
import kr.toongether.android.ui.ToongetherAppState
import kr.toongether.comic.navigation.comicScreen
import kr.toongether.episode.navigatoin.episodeScreen
import kr.toongether.home.navigation.HomeRoute
import kr.toongether.home.navigation.homeScreen
import kr.toongether.login.navigation.loginScreen
import kr.toongether.my.navigation.myScreen
import kr.toongether.series.navigation.seriesScreen
import kr.toongether.shorts.navigation.shortsScreen
import kr.toongether.signup.navigation.signupScreen

@OptIn(ExperimentalAnimationApi::class)
@Composable
fun ToongetherNavHost(
    appState: ToongetherAppState,
    modifier: Modifier = Modifier,
    startDestination: String = HomeRoute
) {
    val navController = appState.navController

    AnimatedNavHost(
        navController = navController,
        startDestination = startDestination,
        modifier = modifier
    ) {
        homeScreen()
        seriesScreen(navController)
        shortsScreen(navController)
        myScreen(navController)
        comicScreen(navController)
        loginScreen(navController)
        signupScreen(navController)
        episodeScreen(navController)
    }
}
