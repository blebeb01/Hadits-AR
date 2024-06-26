package com.naufalm.haditsar.ui.screens.scan_hadits

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun BubbleText(text: String) {
    Box(
        modifier = Modifier
            .background(Color.White, shape = RoundedCornerShape(8.dp))
            .border(BorderStroke(1.dp, Color.Gray), shape = RoundedCornerShape(8.dp))
            .padding(8.dp)
    ) {
        Text(text = text, fontSize = 16.sp, fontWeight = FontWeight.Normal)
    }
}