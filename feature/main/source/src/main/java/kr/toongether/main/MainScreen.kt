package kr.toongether.main

import androidx.compose.animation.AnimatedContentScope
import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.EnterTransition
import androidx.compose.animation.ExitTransition
import androidx.compose.animation.ExperimentalSharedTransitionApi
import androidx.compose.animation.SharedTransitionScope
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.safeDrawingPadding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.NavigationBarItemDefaults
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavDestination
import androidx.navigation.NavDestination.Companion.hierarchy
import androidx.navigation.compose.NavHost
import coil.compose.AsyncImage
import com.airbnb.lottie.compose.LottieAnimation
import com.airbnb.lottie.compose.LottieCompositionSpec
import com.airbnb.lottie.compose.rememberLottieComposition
import kotlinx.coroutines.delay
import kr.toongether.archive.source.navigation.archiveScreen
import kr.toongether.community.navigation.communityScreen
import kr.toongether.designsystem.theme.GangwonEduPower
import kr.toongether.designsystem.theme.ToongetherColors
import kr.toongether.main.navigation.NavigationDestination
import kr.toongether.my.navigation.myScreen
import kr.toongether.series.navigation.SERIES_ROUTE
import kr.toongether.series.navigation.seriesScreen
import kr.toongether.shorts.navigation.shortsScreen

@OptIn(ExperimentalSharedTransitionApi::class)
@Composable
fun MainScreen(
    modifier: Modifier = Modifier,
    mainScreenState: MainScreenState = rememberMainScreenState(),
    navigateToEpisode: (Long, String, String) -> Unit,
    navigateToLogin: () -> Unit,
    sharedTransitionScope: SharedTransitionScope,
    animatedContentScope: AnimatedContentScope
) {
    var showLaunchScreen by rememberSaveable { mutableStateOf(true) }

    LaunchedEffect(key1 = Unit) {
        delay(2000)
        showLaunchScreen = false
    }


    AnimatedVisibility(visible = showLaunchScreen) {
        Box(
            modifier = modifier
                .fillMaxSize()
                .background(ToongetherColors.BackgroundNormal),
            contentAlignment = Alignment.Center
        ) {
            val composition by rememberLottieComposition(LottieCompositionSpec.RawRes(kr.toongether.designsystem.R.raw.toongether_splash_dark_lottie))
            LottieAnimation(
                modifier = Modifier.width(260.dp),
                composition = composition,
            )
        }
    }
    AnimatedVisibility(visible = !showLaunchScreen) {
        Scaffold(
            modifier = modifier
                .fillMaxSize()
                .safeDrawingPadding(),
            bottomBar = {
                ToongetherBottomBar(
                    destinations = mainScreenState.navigationDestinations,
                    onNavigateToDestination = mainScreenState::navigateToNavigationDestination,
                    currentDestination = mainScreenState.currentDestination
                )
            }
        ) { paddingValues ->
            NavHost(
                modifier = Modifier.padding(paddingValues),
                navController = mainScreenState.navController,
                startDestination = SERIES_ROUTE,
                enterTransition = { EnterTransition.None },
                exitTransition = { ExitTransition.None }

            ) {
                seriesScreen(
                    navigateToEpisode = navigateToEpisode,
                    sharedTransitionScope = sharedTransitionScope,
                    animatedContentScope = animatedContentScope
                )
                shortsScreen(navigateToLogin)
                communityScreen()
                archiveScreen()
                myScreen()
            }
        }
    }
}


@Composable
private fun ToongetherBottomBar(
    destinations: List<NavigationDestination>,
    onNavigateToDestination: (NavigationDestination) -> Unit,
    currentDestination: NavDestination?,
    modifier: Modifier = Modifier,
) {
    NavigationBar(
        modifier = modifier,
        containerColor = ToongetherColors.BackgroundNormal,
    ) {
        destinations.forEach { destination ->
            val selected = currentDestination.isNavigationDestinationInHierarchy(destination)
            NavigationBarItem(
                selected = selected,
                onClick = { onNavigateToDestination(destination) },
                icon = {
                    destination.icon?.let {
                        Icon(
                            modifier = Modifier.size(24.dp),
                            imageVector = it(),
                            contentDescription = null,
                            tint = if (selected) ToongetherColors.LabelNormal else ToongetherColors.LabelAssistive
                        )
                    } ?: run {
                        AsyncImage(
                            modifier = Modifier
                                .size(24.dp)
                                .clip(CircleShape),
                            model = kr.toongether.designsystem.R.drawable.ic_toonie_default,
                            contentDescription = null,
                        )
                    }
                },
                label = {
                    Text(
                        text = destination.label,
                        fontSize = 12.sp,
                        fontFamily = GangwonEduPower,
                        color = if (selected) ToongetherColors.LabelNormal else ToongetherColors.LabelAssistive
                    )
                },
                colors = NavigationBarItemDefaults.colors(
                    indicatorColor = Color.Transparent
                )
            )
        }
    }
}

private fun NavDestination?.isNavigationDestinationInHierarchy(destination: NavigationDestination) =
    this?.hierarchy?.any {
        it.route?.contains(destination.name, true) ?: false
    } ?: false
