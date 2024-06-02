package kr.toongether.main

import androidx.compose.runtime.Composable
import androidx.compose.runtime.Stable
import androidx.compose.runtime.remember
import androidx.navigation.NavDestination
import androidx.navigation.NavGraph.Companion.findStartDestination
import androidx.navigation.NavHostController
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navOptions
import kr.toongether.archive.source.navigation.navigateToArchive
import kr.toongether.community.navigation.navigateToCommunity
import kr.toongether.main.navigation.NavigationDestination
import kr.toongether.my.navigation.navigateToMy
import kr.toongether.series.navigation.navigateToSeries
import kr.toongether.shorts.navigation.navigateToShorts

@Composable
fun rememberMainScreenState(navController: NavHostController = rememberNavController()): MainScreenState {
    return remember(navController) {
        MainScreenState(navController)
    }
}

@Stable
class MainScreenState(
    val navController: NavHostController
) {
    val currentDestination: NavDestination?
        @Composable get() = navController
            .currentBackStackEntryAsState().value?.destination

    val navigationDestinations: List<NavigationDestination> = NavigationDestination.entries

    fun navigateToNavigationDestination(navigationDestination: NavigationDestination) {
        val navOptions = navOptions {
            popUpTo(navController.graph.findStartDestination().id) {
                saveState = true
            }
            launchSingleTop = true
            restoreState = true
        }

        when (navigationDestination) {
            NavigationDestination.SERIES -> navController.navigateToSeries(navOptions)
            NavigationDestination.SHORTS -> navController.navigateToShorts(navOptions)
            NavigationDestination.MY -> navController.navigateToMy(navOptions)
            NavigationDestination.ARCHIVE -> navController.navigateToArchive(navOptions)
            NavigationDestination.COMMUNITY -> navController.navigateToCommunity(navOptions)
        }
    }
}
