package com.naufalm.haditsar.ui.screens.home

import android.annotation.SuppressLint
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.systemBars
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.windowInsetsPadding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.naufalm.haditsar.ui.Routes
import com.naufalm.haditsar.ui.theme.Mint
import com.naufalm.haditsar.ui.theme.Teal
import com.naufalm.haditsar.ui.theme.Viridian
import com.naufalm.haditsar.ui.theme.jakartaSansFontFamily

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun HomeScreen(navController: NavController) {
    Surface {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .background(color = Color.White)
                .windowInsetsPadding(WindowInsets.systemBars)
        ) {
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .weight(0.4f),
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Center
            ) {
                Text(
                    text = "Hadits AR",
                    fontSize = 40.sp,
                    fontFamily = jakartaSansFontFamily,
                    fontWeight = FontWeight.ExtraBold,
                    color = Viridian
                )
            }
            Card(
                modifier = Modifier
                    .fillMaxSize()
                    .weight(weight = 0.6f),
                shape = RoundedCornerShape(topEnd = 50.dp, topStart = 50.dp),
                colors = CardDefaults.cardColors(containerColor = Mint)
            ) {
                Column(
                    modifier = Modifier
                        .fillMaxSize(),
                    horizontalAlignment = Alignment.CenterHorizontally,
                    verticalArrangement = Arrangement.Center
                ) {
                    Button(
                        onClick = { navController.navigate(Routes.ScanHadits.route) },
                        modifier = Modifier
                            .width(300.dp),
                        colors = ButtonDefaults.buttonColors(containerColor = Viridian)
                    ) {
                        Text(
                            text = "Scan Hadits",
                            modifier = Modifier.padding(vertical = 10.dp),
                            fontFamily = jakartaSansFontFamily,
                            fontWeight = FontWeight.Bold,
                            fontSize = 18.sp,
                            color = Color.White
                        )
                    }
                    Spacer(modifier = Modifier.height(55.dp))
                    Button(
                        onClick = { navController.navigate(Routes.InfoHadits.route) },
                        modifier = Modifier
                            .width(300.dp),
                        colors = ButtonDefaults.buttonColors(containerColor = Teal)
                    ) {
                        Text(
                            text = "Info Hadits",
                            modifier = Modifier.padding(vertical = 10.dp),
                            fontFamily = jakartaSansFontFamily,
                            fontWeight = FontWeight.Normal,
                            fontSize = 18.sp,
                            color = Color.Black
                        )
                    }
                }
            }
        }
    }
}
