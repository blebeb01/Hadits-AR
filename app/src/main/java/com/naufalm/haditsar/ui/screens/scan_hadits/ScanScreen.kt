package com.naufalm.haditsar.ui.screens.scan_hadits

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavController

@Composable
fun ScanSreen(navController: NavController) {
    Column(
        modifier = Modifier
            .fillMaxSize()
    ) {
        ARScreen()
    }
}