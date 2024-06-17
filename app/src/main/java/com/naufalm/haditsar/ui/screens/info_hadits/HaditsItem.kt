package com.naufalm.haditsar.ui.screens.info_hadits

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import com.naufalm.haditsar.data.models.Hadits
import com.naufalm.haditsar.ui.theme.LightTeal
import com.naufalm.haditsar.ui.theme.jakartaSansFontFamily

@Composable
fun HaditsItem(hadits: Hadits) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 10.dp, vertical = 5.dp),
        colors = CardDefaults.cardColors(containerColor = LightTeal)
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(10.dp)
        ) {
            Text(
                text = hadits.no_hadith.toString(),
                fontFamily = jakartaSansFontFamily,
                fontWeight = FontWeight.Normal,
                color = Color.Black
            )
            Text(
                text = hadits.matan.arabic,
                fontFamily = jakartaSansFontFamily,
                fontWeight = FontWeight.Normal,
                textAlign = TextAlign.End,
                color = Color.Black
            )
            Text(
                text = "\"${hadits.matan.translation}\"",
                fontFamily = jakartaSansFontFamily,
                fontWeight = FontWeight.Normal,
                color = Color.Black
            )
            Text(
                text = hadits.rawi,
                fontFamily = jakartaSansFontFamily,
                fontWeight = FontWeight.Normal,
                color = Color.Black
            )
        }
    }
}