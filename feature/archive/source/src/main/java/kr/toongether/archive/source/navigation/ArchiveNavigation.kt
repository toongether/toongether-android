package kr.toongether.archive.source.navigation

import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavOptions
import androidx.navigation.compose.composable
import kr.toongether.archive.source.ArchiveScreen

const val ARCHIVE_ROUTE = "archive_route"

fun NavController.navigateToArchive(navOptions: NavOptions? = null) {
    this.navigate(ARCHIVE_ROUTE, navOptions)
}

fun NavGraphBuilder.archiveScreen() {
    composable(route = ARCHIVE_ROUTE) {
        ArchiveScreen()
    }
}
