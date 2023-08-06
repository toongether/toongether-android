package kr.toongether.serial.navigation

import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavOptions
import androidx.navigation.compose.composable
import kr.toongether.serial.SerialRoute

const val serialRoute = "serial_route"

fun NavController.navigateToSerial(navOptions: NavOptions? = null) {
    this.navigate(serialRoute, navOptions)
}

fun NavGraphBuilder.serialScreen() {
    composable(route = serialRoute) {
        SerialRoute()
    }
}