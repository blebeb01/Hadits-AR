package com.naufalm.haditsar.ui

import androidx.camera.core.ExperimentalGetImage
import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.google.accompanist.permissions.ExperimentalPermissionsApi
import com.naufalm.haditsar.ui.screens.home.HomeScreen
import com.naufalm.haditsar.ui.screens.info_hadits.InfoScreen
import com.naufalm.haditsar.ui.screens.scan_hadits.ScanScreen
import com.naufalm.haditsar.viewmodel.InfoViewModel
import com.naufalm.haditsar.viewmodel.ScanViewModel

@ExperimentalGetImage
@OptIn(ExperimentalPermissionsApi::class)
@Composable
fun Navigation() {
    val naviController = rememberNavController()
    val infoViewModel = InfoViewModel()
    val scanViewModel = ScanViewModel()
    NavHost(navController = naviController, startDestination = Routes.Home.route) {
        composable(Routes.Home.route) {
            HomeScreen(navController = naviController)
        }
        composable(Routes.ScanHadits.route) {
            ScanScreen(navController = naviController)
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