package com.renatoarg.thecountriesgame.view

import android.util.Log
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.renatoarg.domain.viewmodel.CountryUi
import com.renatoarg.thecontriesgame.R
import com.renatoarg.thecountriesgame._common.LoadImageFromUrl

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun CountryListItem(
    country: CountryUi,
    modifier: Modifier,
    onClick: (String) -> Unit
) {
    Card(
        modifier = modifier
            .fillMaxWidth()
            .padding(horizontal = 8.dp, vertical = 4.dp),
        elevation = CardDefaults.cardElevation(),
        shape = RoundedCornerShape(8.dp),
        onClick = {
            onClick(country.name)
        }
    ) {
        Row(
            modifier = modifier.background(Color.White),
            verticalAlignment = Alignment.CenterVertically,
        ) {
            Box(
                modifier = modifier
                    .width(100.dp)
                    .padding(8.dp),
            ) {
                LoadImageFromUrl(
                    imageUrl = country.imageUrl,
                    contentDescription = stringResource(id = R.string.cont_desc_country_flag)
                )
            }
            Text(
                text = country.name,
                fontWeight = FontWeight.Bold,
                color = Color.Black,
                maxLines = 1,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 8.dp)
            )
        }
    }
}

@Preview(
    name = "Country name",
    group = "Any",
    showSystemUi = true,
    showBackground = true
)
@Composable
fun showCountryListItem() {
    CountryListItem(
        country = CountryUi(
            name = "Brazil",
            imageUrl = "http://any-image.jpg"
        ),
        modifier = Modifier,
        onClick = {
            Log.d("CountryListItem", "showCountryListItem: onClick")
        }
    )
}