package kr.toongether.android.navigation

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.compose.NavHost
import kr.toongether.android.ui.ToongetherAppState
import kr.toongether.community.navigation.communityScreen
import kr.toongether.home.navigation.HomeRoute
import kr.toongether.home.navigation.homeScreen
import kr.toongether.my.navigation.myScreen
import kr.toongether.series.navigation.seriesScreen
import kr.toongether.shorts.navigation.shortsScreen

@Composable
fun ToongetherNavHost(
    appState: ToongetherAppState,
    modifier: Modifier = Modifier,
    startDestination: String = HomeRoute
) {
    val navController = appState.navController
    NavHost(
        navController = navController,
        startDestination = startDestination,
        modifier = modifier
    ) {
        homeScreen()
        seriesScreen()
        shortsScreen()
        communityScreen()
        myScreen()
    }
}
