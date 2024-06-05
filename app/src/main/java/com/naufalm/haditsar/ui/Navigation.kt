package com.naufalm.haditsar.ui

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.naufalm.haditsar.ui.screens.home.HomeScreen
import com.naufalm.haditsar.ui.screens.info_hadits.InfoScreen
import com.naufalm.haditsar.ui.screens.scan_hadits.ScanSreen

@Composable
fun Navigation() {
    val naviController = rememberNavController()
    NavHost(navController = naviController, startDestination = Routes.Home.route) {
        composable(Routes.Home.route) {
            HomeScreen(navController = naviController)
        }
        composable(Routes.ScanHadits.route) {
            ScanSreen(navController = naviController)
        }
        composable(Routes.InfoHadits.route) {
            InfoScreen(navController = naviController)
        }
    }
}

sealed class Routes(val route: String) {
    data object Home : Routes("main_menu")
    data object ScanHadits : Routes("scan_hadits")
    data object InfoHadits : Routes("info_hadits")
}