package com.naufalm.haditsar.ui

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.naufalm.haditsar.ui.screens.home.HomeScreen
import com.naufalm.haditsar.ui.screens.info_hadits.InfoScreen
import com.naufalm.haditsar.ui.screens.scan_hadits.ScanSreen
import com.naufalm.haditsar.viewmodel.InfoViewModel

@Composable
fun Navigation() {
    val naviController = rememberNavController()
    val infoViewModel = InfoViewModel()
    NavHost(navController = naviController, startDestination = Routes.Home.route) {
        composable(Routes.Home.route) {
            HomeScreen(navController = naviController)
        }
        composable(Routes.ScanHadits.route) {
            ScanSreen(navController = naviController)
        }
        composable(Routes.InfoHadits.route) {
            InfoScreen(navController = naviController, haditsList = infoViewModel.hadistListResponse)
            infoViewModel.getHaditsList()
        }
    }
}

sealed class Routes(val route: String) {
    data object Home : Routes("main_menu")
    data object ScanHadits : Routes("scan_hadits")
    data object InfoHadits : Routes("info_hadits")
}