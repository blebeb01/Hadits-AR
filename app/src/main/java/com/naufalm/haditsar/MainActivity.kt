package com.naufalm.haditsar

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import com.naufalm.haditsar.ui.Navigation
import com.naufalm.haditsar.ui.theme.HaditsARTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            HaditsARTheme {
                Navigation()
            }
        }
    }
}