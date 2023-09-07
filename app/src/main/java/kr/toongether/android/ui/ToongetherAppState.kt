package kr.toongether.android.ui

import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.runtime.Composable
import androidx.compose.runtime.Stable
import androidx.compose.runtime.remember
import androidx.navigation.NavDestination
import androidx.navigation.NavGraph.Companion.findStartDestination
import androidx.navigation.NavHostController
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.navOptions
import com.google.accompanist.navigation.animation.rememberAnimatedNavController
import kr.toongether.android.navigation.NavigationDestination
import kr.toongether.community.navigation.CommunityRoute
import kr.toongether.community.navigation.navigateToCommunity
import kr.toongether.home.navigation.HomeRoute
import kr.toongether.home.navigation.navigateToHome
import kr.toongether.my.navigation.MyRoute
import kr.toongether.my.navigation.navigateToMy
import kr.toongether.series.navigation.SeriesRoute
import kr.toongether.series.navigation.navigateToSeries
import kr.toongether.shorts.navigation.ShortsRoute
import kr.toongether.shorts.navigation.navigateToShorts

@OptIn(ExperimentalAnimationApi::class)
@Composable
fun rememberToongetherAppState(
    navController: NavHostController = rememberAnimatedNavController()
): ToongetherAppState {
    return remember(navController) {
        ToongetherAppState(navController)
    }
}

@Stable
class ToongetherAppState(
    val navController: NavHostController
) {
    val currentDestination: NavDestination?
        @Composable get() = navController
            .currentBackStackEntryAsState().value?.destination

    val navigationDestinations: List<NavigationDestination> = NavigationDestination.values().asList()

    val isShowBottomBar: Boolean
        @Composable get() = when (currentDestination?.route) {
            HomeRoute, SeriesRoute, ShortsRoute, CommunityRoute, MyRoute -> true
            else -> false
        }

    fun navigateToNavigationDestination(navigationDestination: NavigationDestination) {
        val navOptions = navOptions {
            popUpTo(navController.graph.findStartDestination().id) {
                saveState = true
            }
            launchSingleTop = true
            restoreState = true
        }

        when (navigationDestination) {
            NavigationDestination.HOME -> navController.navigateToHome(navOptions)
            NavigationDestination.SERIES -> navController.navigateToSeries(navOptions)
            NavigationDestination.SHORTS -> navController.navigateToShorts(navOptions)
            NavigationDestination.MY -> navController.navigateToMy(navOptions)
        }
    }
}
